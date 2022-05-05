package com.company;/*
 * File description: Savings Class. Subclass of Accounts. Has overridden method to udpate balance
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: Feb 27
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * The purpose of this class is to read and get savings object variables. Has methods to read and print relevant info and update balance.
 * Subclass of account.
 * @author Fady Shenouda
 * @version 1.0
 * @since 1.8
 */
public class Savings extends Account implements Policies {

    private static final double MONTHS = 12;

    /**
     * Overloaded savings object constructor
     * @param accHolder [the information of the account holder]
     * @param accountNumber [the account number of the account holder]
     * @param accountBalance [balance of the account holder]
     */
    public Savings(Person accHolder, int accountNumber, int accountBalance){

        super(accHolder, accountNumber, accountBalance);


    }

    /**
     * No param constructor for savings object
     */
    public Savings(){

        super();

    }




    @Override
    /**
     * method that updates the balance of savings account, uses implemented interest rate from policies
     */
    void updateBalance() {

        double accountBalance = super.getAccountBalance();

        // updating balance based on savings account formula
        accountBalance = accountBalance + (accountBalance * (SAVING_INTEREST_RATE / MONTHS));

        super.setAccountBalance(accountBalance);
    }
}
