# Assignment 1's README

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

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 09/15/2017] 

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

1. I have used int array as it has the complexity of O(1) i.e Constant because of fixed size;

2. I have also used ArrayList data structure to store all String results. ArrayList is a good choice because it has complexity of O(n) and also mutable data structure.


-----------------------------------------------------------------------
