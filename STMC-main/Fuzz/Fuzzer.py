from itertools import count
import random
import os
import re
import pandas as pd

import string

capletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
digit = "0123456789"
types = ["SAVINGS", "CURRENT"]
characters = string.ascii_letters + string.digits + string.punctuation

# case: valid/invalid file path
def generate_path():
    # valid file path or invalid file path
    valid = random.random()>=0.5
    if valid:
        files = os.listdir("FuzzedData")

        #return a filepath inside data folder, which is valid
        file_path = "Fuzz/FuzzedData/" + files[random.randint(0,len(files)-1)]
    else:
        file_path = ''.join(random.choice(characters) for i in range(10))
    print (file_path)
    return file_path



def generate_selected_columns():
    valid = random.random()>0.5

    if valid:
        # non repetitive
        repeat = random.random()>0.5
        if repeat:
            sample_num = random.randint(0,10)
            cols = random.sample([0,1,2,3],sample_num)
        else:
            sample_num = random.randint(0,4)
            cols = random.sample([0,1,2,3],sample_num)

    else:
        sample_num = random.randint(0,4)
        cols = random.sample([4,5,6,7], sample_num)

    return ",".join(cols)

def generate_csv(missing_rate, col_num_lower, col_num_upper, id_not_ordered, file_name):

    full_cols = ["Customer ID#","Account No.","Currency","Type","Balance"]
    
    # randomly choose cols
    col_num = random.randint(0,4)
    col_index = random.sample([0,1,2,3],col_num)
    cols = [full_cols[i] for i in col_index]

    # decide whether add col balance
    missing_balance = random.random()<0.05
    if not missing_balance:
        cols.append("Balance")

    df = pd.DataFrame(columns = cols)

    if (len(cols)==0):
        df.to_csv(f"data/{file_name}", index=False)

    print(cols)

    


    # row_num
    row_num = random.randint(col_num_lower,col_num_upper)
        
    # id starts from 1
    count_id = 1

    for i in range(row_num):
        row = {}
        for colname in cols:
            if colname == "Customer ID#":
                miss = random.random()<missing_rate
                if miss:
                    row["Customer ID#"] = ""
                else:
                    id = "ID"+str(count_id)
                    row["Customer ID#"] = id
                count_id+=1


            elif colname == "Account No.":
                miss = random.random()<missing_rate
                if miss:
                    row["Account No."] = ""
                else:
                    account = ""
                    # generate 3 cap letters
                    for i in range(3):
                        account += capletters[random.randint(0,25)]
                    # plus 8 digits
                    for i in range(8):
                        account += digit[random.randint(0,9)]
                    row["Account No."] = account

            elif colname == "Currency":
                # if miss, append an empty string
                miss = random.random()<missing_rate
                if miss:
                    row["Currency"] = ""
                else:
                    cur = ""
                    # generate 3 cap letters
                    for i in range(3):
                        cur += capletters[random.randint(0,25)]
                    row["Currency"] = cur

            elif colname == "Type":
                # if miss, append an empty string
                miss = random.random()<missing_rate
                if miss:
                    row["Type"] = ""
                else:
                    r = random.random()<=0.5
                    if r:
                        tp = "SAVINGS"
                    else:
                        tp = "CURRENT"
                    row["Type"] = tp
            
            elif colname == "Balance":
                miss = random.random()<missing_rate
                if miss:
                    row["Balance"] = ""
                else:
                    bal = ""
                    # length of balance
                    r = random.randint(0,9)
                    for i in range(r):
                        # randomly choose a digit
                        if i==0:
                            bal += digit[random.randint(1,9)]
                        else:
                            bal += digit[random.randint(0,9)]
                    row["Balance"] = bal
    
        df = df.append(row, ignore_index=True)
    
    # random_permute
    if id_not_ordered:
        df = df.sample(frac = 1)
    
    df.to_csv(f"Fuzz/FuzzedData/{file_name}", index=False)


for i in range(18):
    missing_rate = random.random()/100
    test_name = "testData" + str(i+1)
    if random.random()<0.75:
        ordered = True
    else:
        ordered = False
        
    generate_csv(missing_rate, 20, 100, ordered, test_name)