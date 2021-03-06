.. _code-samples-label:

Code Samples
=============

Make sure that you've installed BrainFlow package before running the code samples below.

See :ref:`installation-label` for details.

Python
--------

**To run some signal processing samples, you may need to install:**

- matplotlib
- pandas
- mne

BrainFlow doesn't use these packages and doesn't install them, but the packages will be used in demos below.

Python Get Data from a Board
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/brainflow_get_data.py
   :language: py

Python Read Write File
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/serialization.py
   :language: py

Python Downsample Data
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/downsampling.py
   :language: py

Python Transforms
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/transforms.py
   :language: py

Python Signal Filtering
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/signal_filtering.py
   :language: py

Python Denoising
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/denoising.py
   :language: py

Python MNE Integration
~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/brainflow_to_mne.py
   :language: py

Python Band Power
~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/python/band_power.py
   :language: py

Java
------

Java Get Data from a Board
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../java-package/brainflow/src/main/java/brainflow/examples/BrainFlowGetData.java
   :language: java

Java Read Write File
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../java-package/brainflow/src/main/java/brainflow/examples/Serialization.java
   :language: java

Java Downsample Data
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../java-package/brainflow/src/main/java/brainflow/examples/Downsampling.java
   :language: java

Java Transforms
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../java-package/brainflow/src/main/java/brainflow/examples/Transforms.java
   :language: java

Java Signal Filtering
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../java-package/brainflow/src/main/java/brainflow/examples/SignalFiltering.java
   :language: java

Java Denoising
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../java-package/brainflow/src/main/java/brainflow/examples/Denoising.java
   :language: java

Java Band Power
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../java-package/brainflow/src/main/java/brainflow/examples/BandPower.java
   :language: java

C#
-----

C# Read Data from a Board
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../csharp-package/brainflow/brainflow_get_data/brainflow_get_data.cs
   :language: c#

C# Read Write File
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../csharp-package/brainflow/serialization/serialization.cs
   :language: c#

C# Downsample Data
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../csharp-package/brainflow/downsampling/downsampling.cs
   :language: c#

C# Transforms
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../csharp-package/brainflow/transforms/transforms.cs
   :language: c#

C# Signal Filtering
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../csharp-package/brainflow/signal_filtering/signal_filtering.cs
   :language: c#

C# Denoising
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../csharp-package/brainflow/denoising/denoising.cs
   :language: c#

C# Band Power
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../csharp-package/brainflow/band_power/band_power.cs
   :language: c#


C++
-----

.. compound::

   To compile examples below for Linux or MacOS run: ::

      cd tests/cpp/get_data_demo
      mkdir build
      cd build
      cmake -DCMAKE_PREFIX_PATH=TYPE_FULL_PATH_TO_BRAINFLOW_INSTALLED_FOLDER ..
      # e.g. cmake -DCMAKE_PREFIX_PATH=/home/andrey/brainflow/installed_linux ..
      make

For Windows it's almost the same.

**Make sure that compiled dynamic libraries exist in search path before running an executable by doing one of the following:**

- for Linux and MacOS add them to LD_LIBRARY_PATH env variable
- for Windows add them to PATH env variable
- or just copypaste them to the folder where your executable is located

CMake File Example
~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/get_data_demo/CMakeLists.txt
   :language: none

C++ Read Data from a Board
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/get_data_demo/src/brainflow_get_data.cpp
   :language: cpp

C++ Read Write File
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/signal_processing_demo/src/serialization.cpp
   :language: cpp

C++ Downsample Data
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/signal_processing_demo/src/downsampling.cpp
   :language: cpp

C++ Transforms
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/signal_processing_demo/src/transforms.cpp
   :language: cpp

C++ Signal Filtering
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/signal_processing_demo/src/signal_filtering.cpp
   :language: cpp

C++ Denoising
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/signal_processing_demo/src/denoising.cpp
   :language: cpp

C++ Band Power
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/cpp/signal_processing_demo/src/band_power.cpp
   :language: cpp

R
----

R Get Data from a Board
~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/r/brainflow_get_data.R
   :language: r

R Read Write File
~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/r/serialization.R
   :language: r

R Transforms
~~~~~~~~~~~~~

.. literalinclude:: ../tests/r/transforms.R
   :language: r

R Signal Filtering
~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../tests/r/signal_filtering.R
   :language: r

R Denoising
~~~~~~~~~~~~~

.. literalinclude:: ../tests/r/denoising.R
   :language: r

R Band Power
~~~~~~~~~~~~~

.. literalinclude:: ../tests/r/band_power.R
   :language: r

Matlab
--------

Matlab Get Data from a Board
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../matlab-package/brainflow/examples/BrainFlowGetData.m
   :language: matlab

Matlab Read Write File
~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../matlab-package/brainflow/examples/Serialization.m
   :language: matlab

Matlab Transforms
~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../matlab-package/brainflow/examples/Transforms.m
   :language: matlab

Matlab Signal Filtering
~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../matlab-package/brainflow/examples/SignalFiltering.m
   :language: matlab

Matlab Denoising
~~~~~~~~~~~~~~~~~

.. literalinclude:: ../matlab-package/brainflow/examples/Denoising.m
   :language: matlab

Matlab Band Power
~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../matlab-package/brainflow/examples/BandPower.m
   :language: matlab

Julia
--------

Julia Get Data from a Board
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../julia-package/brainflow/test/brainflow_get_data.jl
   :language: julia

Julia Read Write File
~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../julia-package/brainflow/test/serialization.jl
   :language: julia

Julia Transforms
~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../julia-package/brainflow/test/transforms.jl
   :language: julia

Julia Signal Filtering
~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: ../julia-package/brainflow/test/signal_filtering.jl
   :language: julia

Julia Denoising
~~~~~~~~~~~~~~~~~

.. literalinclude:: ../julia-package/brainflow/test/denoising.jl
   :language: julia

Julia Band Power
~~~~~~~~~~~~~~~~~

.. literalinclude:: ../julia-package/brainflow/test/band_power.jl
   :language: julia

Notebooks
------------
.. toctree::

   ./notebooks/brainflow_mne
   ./notebooks/denoising
   ./notebooks/band_power
