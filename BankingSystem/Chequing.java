package com.company;/*
 * File description: Chequing class. Subclass of Account. Contains overridden method to update balance
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: Feb 27
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * The purpose of this class is to read and get chequing object variables. Has methods to read and print relevant info and update balance.
 * Subclass of account.
 * @author Fady Shenouda
 * @version 1.0
 * @since 1.8
 */

public class Chequing extends Account implements Policies {

    /**
     * Overlaoded constructor of chequing object
     * @param accHolder [the information of the account holder]
     * @param accountNumber [the account number of the account holder]
     * @param accountBalance [balance of the account holder]
     */
    public Chequing (Person accHolder, int accountNumber, int accountBalance){

        super (accHolder, accountNumber, accountBalance);


    }

    /**
     * No args constructor of chequing object
     */
    public Chequing(){

        super();

    }



    @Override
/**
 * Method to update balance of chequing account object, uses implemented chequing fee
 */
    void updateBalance() {

        double accountBalance = super.getAccountBalance();

        // updaing balance based on chequing account formula
        accountBalance = accountBalance - CHEQUING_FEE;

        super.setAccountBalance(accountBalance);

    }



}
