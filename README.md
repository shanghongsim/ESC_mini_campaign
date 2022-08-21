# Peer test of Liaw Yu Zheng

By Sim Shang Hong (1005500)

## Limitations

1. Peer's code was not modular and thus was very hard to test. For example, the main comparison unit written by peer was in csv_compare.java but all the code was written in the public static void main method with no other access point. The code was not broken up into different methods and this significantly limits the amount of unit tests that can be written.
2. Furthermore, file path input is hardcoded in the main method, making changing csv file inputs programmatically not possible. However, making a fuzzer unit or paramteric unit test will require us to be able to change file path (an input) programatically, a functionality that was not available. Thus, making a fuzzer unit and parametric test is not possible possible.
3. Code was not well documented and it did not state assumptions of the system eg how many columns expected (if any expectation at all).

## Overview of test

Thus decided to implement basic unit tests to check if constructor is callable and if output is successfully written to output.csv. I also did some manual testing (change the hardcoded file path in peer's implemrenation) to check if it can handle different file formats

## Testing

1. Unit testing
   a. Test if constructor is callable => passed
   b. Test if output successfully written to output.csv by checking if output.csv is empty. => Failed. Output not written to output.csv. Bug #1.
2. Fault based testing
   Manually changed the hardcoded file path in peer's code to another randomly generated csv file (CsvRandomGenerator.java, own code) to check if it can handle files with both 4 columns instead of both 5 columns. The program threw an exception. However, there was no documentation stating that files need exactly 5 columns. Bug #2/

## Bugs

1. Output not written to output.csv correctly as output.csv empty (unit test)
2. Program crashes when we give csv files with less than 5 columns (fault based testing)
