package brainflow;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.lang3.SystemUtils;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class MLModel
{
    private interface DllInterface extends Library
    {
        int prepare (int metric, int classifier);

        int release (int metric, int classifier);

        int predict (double[] data, int data_len, double[] output, int metric, int classifier);
    }

    private static DllInterface instance;

    static
    {
        // SystemUtils doesnt have smth like IS_OS_ANDROID, need to check using
        // properties
        boolean is_os_android = "The Android Project".equals (System.getProperty ("java.specification.vendor"));

        String lib_name = "libMLModule.so";
        if (SystemUtils.IS_OS_WINDOWS)
        {
            lib_name = "MLModule.dll";

        } else if (SystemUtils.IS_OS_MAC)
        {
            lib_name = "libMLModule.dylib";
        }

        if (is_os_android)
        {
            // for android you need to put these files manually to jniLibs folder, unpacking
            // doesnt work
            lib_name = "MLModule"; // no lib prefix and no extension for android
        } else
        {
            // need to extract libraries from jar
            unpack_from_jar (lib_name);
        }

        instance = (DllInterface) Native.loadLibrary (lib_name, DllInterface.class);
    }

    private static Path unpack_from_jar (String lib_name)
    {
        try
        {
            File file = new File (lib_name);
            if (file.exists ())
                file.delete ();
            InputStream link = (BoardShim.class.getResourceAsStream (lib_name));
            Files.copy (link, file.getAbsoluteFile ().toPath ());
            return file.getAbsoluteFile ().toPath ();
        } catch (Exception io)
        {
            System.err.println ("file: " + lib_name + " is not found in jar file");
            return null;
        }
    }

    private int metric;
    private int classifier;

    /**
     * Create MLModel object
     */
    public MLModel (int metric, int classifier)
    {
        this.metric = metric;
        this.classifier = classifier;
    }

    /**
     * Prepare classifier
     * 
     * @throws BrainFlowError
     */
    public void prepare () throws BrainFlowError
    {
        int ec = instance.prepare (metric, classifier);
        if (ec != ExitCode.STATUS_OK.get_code ())
        {
            throw new BrainFlowError ("Error in prepare", ec);
        }
    }

    /**
     * Release classifier
     * 
     * @throws BrainFlowError
     */
    public void release () throws BrainFlowError
    {
        int ec = instance.release (metric, classifier);
        if (ec != ExitCode.STATUS_OK.get_code ())
        {
            throw new BrainFlowError ("Error in release", ec);
        }
    }

    /**
     * Get score of classifier
     * 
     * @throws BrainFlowError
     */
    public double predict (double[] data) throws BrainFlowError
    {
        double[] val = new double[1];
        int ec = instance.predict (data, data.length, val, metric, classifier);
        if (ec != ExitCode.STATUS_OK.get_code ())
        {
            throw new BrainFlowError ("Error in predict", ec);
        }
        return val[0];
    }
}