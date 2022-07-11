# ESC mini campaign
By Liaw Yu Zheng (1005192)

This repository aims to document the submissions for a mini campaign in 50.003 Elements of Software Construction from weeks 8 to 13.

## Details
The mini campaign aims to reconcile data by reading two CSV files and then compare records in these CSV files row by row against a unique combination and record all mismatches as exceptions. A new CSV file will then be generated that lists the exceptions found.

## Use case diagram
![Use case diagram](https://user-images.githubusercontent.com/90777322/178271290-567b2798-57ea-436b-86fa-a324af7d6005.png)
From the use case diagram, the compartor first takes in the CSV files as input. Then, it will compare the account IDs in both files. If there are no common IDs, an empty CSV file is returned. If there is at least once common ID, the comparator then checks the details of the bank account such as the type of currency used, the balance, and the type of account. If both records tally, for all common IDs, then an empty CSV file is returned. Otherwise, it takes in the mismatched records and puts it as exception which will be recorded in the CSV file.

Given a malicious user may only edit the input files, it is possible that false positives/negatives occur by editing either the account ID or the account details.
