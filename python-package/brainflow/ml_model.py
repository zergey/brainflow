import ctypes
import numpy
from numpy.ctypeslib import ndpointer
import pkg_resources
import enum
import os
import platform
import sys
import struct
import json
from typing import List, Set, Dict, Tuple

from nptyping import NDArray, Float64

from brainflow.board_shim import BrainFlowError
from brainflow.exit_codes import BrainflowExitCodes


class BrainFlowMetrics (enum.Enum):
    """Enum to store all supported metrics"""

    RELAXATION = 0 #:
    CONCENTRATION = 1 #:


class BrainFlowClassifiers (enum.Enum):
    """Enum to store all supported classifiers"""

    ALGORITHMIC = 0 #:
    REGRESSION = 1 #:
    SVM = 2 #:


class BoardControllerDLL (object):

    __instance = None

    @classmethod
    def get_instance (cls):
        if cls.__instance is None:
            cls.__instance = cls ()
        return cls.__instance

    def __init__ (self):
        if platform.system () == 'Windows':
            if struct.calcsize ("P") * 8 == 64:
                dll_path = 'lib\\MLModule.dll'
            else:
                dll_path = 'lib\\MLModule32.dll'
        elif platform.system () == 'Darwin':
            dll_path = 'lib/libMLModule.dylib'
        else:
            dll_path = 'lib/libMLModule.so'
        full_path = pkg_resources.resource_filename (__name__, dll_path)
        if os.path.isfile (full_path):
            # for python we load dll by direct path but this dll may depend on other dlls and they will not be found!
            # to solve it we can load all of them before loading the main one or change PATH\LD_LIBRARY_PATH env var.
            # env variable looks better, since it can be done only once for all dependencies
            dir_path = os.path.abspath (os.path.dirname (full_path))
            if platform.system () == 'Windows':
                os.environ['PATH'] = dir_path + os.pathsep + os.environ.get ('PATH', '')
            else:
                os.environ['LD_LIBRARY_PATH'] = dir_path + os.pathsep + os.environ.get ('LD_LIBRARY_PATH', '')
            self.lib = ctypes.cdll.LoadLibrary (full_path)
        else:
            raise FileNotFoundError ('Dynamic library %s is missed, did you forget to compile brainflow before installation of python package?' % full_path)

        self.prepare = self.lib.prepare
        self.prepare.restype = ctypes.c_int
        self.prepare.argtypes = [
            ctypes.c_int,
            ctypes.c_int
        ]

        self.release = self.lib.release
        self.release.restype = ctypes.c_int
        self.release.argtypes = [
            ctypes.c_int,
            ctypes.c_int
        ]

        self.predict = self.lib.predict
        self.predict.restype = ctypes.c_int
        self.predict.argtypes = [
            ndpointer (ctypes.c_double),
            ctypes.c_int,
            ndpointer (ctypes.c_double),
            ctypes.c_int,
            ctypes.c_int
        ]


class MLModel (object):
    """MLModel class used to calc derivative metrics from raw data

    :param metric: metric to calculate
    :type metric: int
    :param classifier: classifier which will be used for calculation
    :type classifier: int
    """
    def __init__ (self, metric: int, classifier: int) -> None:
        self.metric = metric
        self.classifier = classifier

    def prepare (self) -> None:
        """prepare classifier"""

        res = BoardControllerDLL.get_instance ().prepare (self.metric, self.classifier)
        if res != BrainflowExitCodes.STATUS_OK.value:
            raise BrainFlowError ('unable to prepare classifier', res)

    def release (self) -> None:
        """release classifier"""

        res = BoardControllerDLL.get_instance ().release (self.metric, self.classifier)
        if res != BrainflowExitCodes.STATUS_OK.value:
            raise BrainFlowError ('unable to release classifier', res)

    def predict (self, data: NDArray) -> float:
        """calculate metric from data

        :param data: input array
        :type data: NDArray
        :return: metric value
        :rtype: float
        """
        output = numpy.zeros (1).astype (numpy.float64)
        res = BoardControllerDLL.get_instance ().predict (data, data.shape[0], output, self.metric, self.classifier)
        if res != BrainflowExitCodes.STATUS_OK.value:
            raise BrainFlowError ('unable to calc metric', res)
        return output[0]
