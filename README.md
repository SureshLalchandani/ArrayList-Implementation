It's a part of academic assignments and replicates few behaviours of ArrayList in java.

Navigate to the folder of this README file:

Perform Below commands to compile/run/clean the program:


## To clean:
ant -buildfile myArrayList/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile myArrayList/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile myArrayList/src/build.xml run -Darg0=input.txt -Darg1=output.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile myArrayList/src/build.xml tarzip

-----------------------------------------------------------------------


