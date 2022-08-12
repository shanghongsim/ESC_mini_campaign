# ESC mini campaign
By Liaw Yu Zheng (1005192)

This repository aims to document the submissions for a mini campaign in 50.003 Elements of Software Construction from weeks 8 to 13.

## Details
The mini campaign aims to reconcile data by reading two CSV files and then compare records in these CSV files row by row against a unique combination and record all mismatches as exceptions. A new CSV file will then be generated that lists the exceptions found.

## Use case diagram
![Use case diagram](https://user-images.githubusercontent.com/90777322/178271290-567b2798-57ea-436b-86fa-a324af7d6005.png)
From the use case diagram, the compartor first takes in the CSV files as input. Then, it will compare the account IDs in both files. If there are no common IDs, an empty CSV file is returned. If there is at least once common ID, the comparator then checks the details of the bank account such as the type of currency used, the balance, and the type of account. If both records tally, for all common IDs, then an empty CSV file is returned. Otherwise, it takes in the mismatched records and puts it as exception which will be recorded in the CSV file.

Given a malicious user may only edit the input files, it is possible that false positives/negatives occur by editing either the account ID or the account details.

## Equivalence class partitioning and boundary value analysis
![Sample equivalance classes](https://user-images.githubusercontent.com/90777322/179521748-c104c791-91fc-43bd-8265-ec6226f63e43.png)


A few sample equivalance classes that can be used for testing include the following:
- Exact match to show that the comparison works and the CSV will return an empty file if all accounts in both files tally
- Currency mismatch to show that the currencies do not tally. For example, USD is compared against USE, which is not a valid currency code. CAD (Canadian dollar) is compared to another currency, MAD (Moroccan dirham).
- Account type mismatch to show that the account types do not tally. For example, current account vs. curent account (invalid account type) and current account vs. savings account.
- Amount mismatch to show that the amounts do not tally, where the dollars and/or cents (for decimal based currencies) do not tally.

Examples of boundary values include:
- Currencies in file: SAR, QAR, ZAR
  - Currencies just outside the boundary: Valid currencies that do not match with currencies listed (e.g. SCR), invalid currencies (e.g. ZAD).
- Account types: Savings/Current.
  - Account types outside of boundary: Current/Savings or an invalid account type (Curent).
- Amounts: Both amounts must be equal
  - Amounts outside of boundary: Non-equal amount, invalid amount.

## Usage
Use csv_compare.java and two csv files to be compared. Replace sample_file_1.csv and sample_file_3.csv with two files to be compared.
