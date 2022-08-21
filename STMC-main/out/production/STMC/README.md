# Software Testing Mini Campaign for ESC 

## Introduction

CI05 1004878 Zhang Tianqin 

Problem Statement: Data Reconciliation 

Description: Consider a CSV file that stores a list of records (e.g., records of bank accounts). This is a software program that reads two such CSV files, compares records stored in these CSV files row by row against a unique combination and records all mismatches as exceptions, and generates another csv file listing the exceptions. 

How it works:
The Java file "PrintDiffDataCSV" requires paths for two CSV files, A and B. 
1. It will first iterate all the lines in file A and store the lines in an arraylist, then iterate the lines in file B. 
2. If the line in file B is contained in file A, delete the record from file A, otherwise add the line to the result arraylist.
3. Append the remaining result in file A to the result arraylist.
4. Write the result to a CSV file named "result.csv".

Given the sample_file_1.csv and sample_file_3.csv, the result from comparing these two csv files (read by Excel):

<img width="356" alt="Screenshot 2022-07-11 at 8 44 20 AM" src="https://user-images.githubusercontent.com/99006100/178169330-65deef3f-da18-4c2a-8203-b51c846796b8.png">


Use case diagram for this problem:

![image](https://user-images.githubusercontent.com/99006100/178208650-eeb32b27-762f-49aa-b227-74c95138c89d.png)

Assume that the malicious user may only interact with the inputs.

## Testing
**Equivalence Class Partitioning**

There are four classes of test cases: namely "Input file type", "Input file number", "File content: header", "File content: competitive values". For each class, the test cases for boundary values and middle values can be found in the folder "SystemTest".
<p align="center">
<img width="700" alt="Screenshot 2022-07-18 at 10 50 17 PM" src="https://user-images.githubusercontent.com/99006100/179538713-5d54aa8d-9349-42a3-8519-3a909b123f2f.png">

<img width="700" alt="Screenshot 2022-07-18 at 10 48 42 PM" src="https://user-images.githubusercontent.com/99006100/179538423-39f638b4-71ea-4f45-960a-555f679ec58f.png">

</p>


