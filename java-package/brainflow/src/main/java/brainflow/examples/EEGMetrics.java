package brainflow.examples;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

import brainflow.BoardIds;
import brainflow.BoardShim;
import brainflow.BrainFlowClassifiers;
import brainflow.BrainFlowInputParams;
import brainflow.BrainFlowMetrics;
import brainflow.DataFilter;
import brainflow.LogLevels;
import brainflow.MLModel;

public class EEGMetrics
{

    public static void main (String[] args) throws Exception
    {
        BoardShim.enable_board_logger ();
        BrainFlowInputParams params = new BrainFlowInputParams ();
        int board_id = BoardIds.SYNTHETIC_BOARD.get_code ();
        BoardShim board_shim = new BoardShim (board_id, params);
        int sampling_rate = BoardShim.get_sampling_rate (board_id);
        int[] eeg_channels = BoardShim.get_eeg_channels (board_id);

        board_shim.prepare_session ();
        board_shim.start_stream (3600);
        BoardShim.log_message (LogLevels.LEVEL_INFO.get_code (), "Start sleeping in the main thread");
        Thread.sleep (10000);
        board_shim.stop_stream ();
        double[][] data = board_shim.get_board_data ();
        board_shim.release_session ();

        Pair<double[], double[]> bands = DataFilter.get_avg_band_powers (data, eeg_channels, sampling_rate, true);
        double[] feature_vector = ArrayUtils.addAll (bands.getLeft (), bands.getRight ());
        MLModel concentration = new MLModel (BrainFlowMetrics.CONCENTRATION.get_code (),
                BrainFlowClassifiers.ALGORITHMIC.get_code ());
        concentration.prepare ();
        System.out.print ("Concentration: " + concentration.predict (feature_vector));
        concentration.release ();
    }
}
