package com.bankaccount;

public class Account {

    private String account_id;
    private String account_number;
    private String account_currency;
    private String account_type;
    private String account_balance;

    public Account(String account_id, String account_number, String account_currency, String account_type, String account_balance) {
        this.account_id = account_id;
        this.account_number = account_number;
        this.account_currency = account_currency;
        this.account_type = account_type;
        this.account_balance = account_balance;
    }

    @Override
    public String toString(){
        return (account_id + " " + account_number + " " + account_currency + " " + account_type + " " + account_balance);
    }
}
