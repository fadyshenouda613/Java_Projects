package com.company;/*
 * File description: Abstract Account class for banking system. Contains setters / getters and methods to print info
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: Feb 27
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
import java.util.Scanner;
/**
 * The purpose of this class is to read and get account object variables. Has methods to read and print relevant info
 * @author Fady Shenouda
 * @version 1.0
 * @since 1.8
 */
public abstract class Account {

    private Person accHolder;

    private int accountNumber;

    private double accountBalance;


    /**
     * Overloaded constructor of account object
     * @param accHolder [the information of the account holder]
     * @param accountNumber [the account number of the account holder]
     * @param accountBalance [balance of the account holder]
     */
    public Account (Person accHolder, int accountNumber, int accountBalance){

        this.accHolder = accHolder;

        this.accountNumber = accountNumber;

        this.accountBalance = accountBalance;
    }

    /**
     * No param constructor of account object
     */
    public Account(){

        this.accHolder = null;

        this.accountNumber = 0;

        this.accountBalance = 0;

    }
    public void readFile(int accountNumber, String firstName, String lastName, String email, int phoneNumber, double accountBalance){
        this.accHolder = new Person(firstName, lastName, email,phoneNumber);
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;

    }

    /**
     * Method to read bank account details from individual
     * @param keyboard [scanner object, passed thru]
     */
    public void readInfo(Scanner keyboard){

        System.out.print("Enter first name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Enter last name: ");
        String lastName = keyboard.nextLine();

        System.out.print("Enter email: ");
        String email = keyboard.nextLine();

        System.out.print("Enter phone number: ");
        long phoneNumber = keyboard.nextLong();

        this.accHolder = new Person(firstName, lastName, email, phoneNumber);

        System.out.print("Enter your account number: ");
        this.accountNumber = keyboard.nextInt();

        System.out.print("Enter your account balance: ");
        this.accountBalance = keyboard.nextDouble();

        balanceCheck(keyboard);


    }

    /**
     * Method to check if balance is negative
     * @param keyboard scanner
     */
    public void balanceCheck (Scanner keyboard){

        while (this.accountBalance < 0){

            System.out.println("Please input a non-negative balance");
            System.out.print("Account balance: ");
            this.accountBalance = keyboard.nextDouble();


        }

    }


    /**
     * Method to print relevant account details of account holder
     */
    public void printAccountInfo(){

        System.out.printf("%10d |", this.accountNumber);

        System.out.printf("%20s |", accHolder.getFirstName() + " " + accHolder.getLastName());

        System.out.printf("%24s |", accHolder.getEmail());

        System.out.printf("%30d |", accHolder.getPhoneNumber());

        System.out.printf("%23.2f |\n", this.accountBalance);





    }

    /**
     * abstract method to be implemented in subclass
     */
    abstract void updateBalance();

    /**
     * Method to get the balance of the account holder
     * @return this returns account balance
     */
    public double getAccountBalance(){


        return this.accountBalance;

    }


    /**
     * Method to update the balance of the account holder
     * @param accountBalance [Scanner object, passed thru]
     */
    public void setAccountBalance(double accountBalance){

        this.accountBalance = accountBalance;

    }

    public String returnFirstName(){
        return accHolder.getFirstName();
    }
    public String returnLastName(){
        return accHolder.getLastName();
    }
    public String returnEmail(){
        return accHolder.getEmail();
    }
    public long returnPhone(){
        return accHolder.getPhoneNumber();
    }
    public int getAccountNumber() {
        return accountNumber;
    }

}
