package com.company;/*
 * File description: Bank Class. Has methods to read account types, print info, and run monthly processes on accounts.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: Feb 27
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import static java.awt.SystemColor.info;

/**
 * The purpose of this class is to hold methods used to operate the banking system.
 * @author Fady Shenouda
 * @version 1.0
 * @since 1.8
 */
public class Bank {


    private String name;

    private ArrayList<Account> accounts;

    /**
     * Overlaoded constructor of bank object
     * @param name [name of the bank]
     * @param accountSize [initial account size of banking system]
     */
    public Bank (String name, int accountSize){

        this.name = name;

        accounts = new ArrayList<>(accountSize);


    }

    /**
     * Method to read a banking acount depending on the
     * @param keyboard [Scanner object, passed thru]
     */
    public void readAccounts(Scanner keyboard) {

        /** The inputted account type*/
        int accountType;

        /** The default state of the menu to read the accounts*/
        boolean menuOn = true;




        // Printing account type header
        System.out.printf("Enter details of Account %d\n", this.accounts.size() + 1);
        System.out.printf("===========================\n");


        // While loop for account type menu
        while (menuOn) {
            try {
                // Printing menu options
                System.out.println("1 - Chequing Account");
                System.out.println("2 - Savings Account");


                // Requesting and storing menu inputs
                System.out.print("Enter Account type: ");
                accountType = keyboard.nextInt();
                keyboard.nextLine();
            }catch(InputMismatchException ex){
                System.out.println("**** Enter valid account type ****");
                keyboard.next();
                continue;
            }

            // Switch decision structure for account menu
            switch (accountType) {


                // Menu option 1
                case 1:

                    // Creating a Chequing object within the account array
                    this.accounts.add(new Chequing());

                    // Calling chequing account method to read info
                    this.accounts.get(accounts.size() - 1).readInfo(keyboard);
                    // Setting while loop condition to false
                    menuOn = false;
                    break;


                // Menu option 2
                case 2:

                    // Creating savings object within the account array
                    this.accounts.add(new Savings());

                    // Calling saving account radInfo method from within account array
                    this.accounts.get(accounts.size() - 1).readInfo(keyboard);

                    // Setting while loop condition to false
                    menuOn = false;

                    break;

                // Default case, outputs error message when invalid menu input is recieved
                default:

                    // printing invalid input message
                    System.out.println("**** Enter valid account type ****");
                    break;
            }


        }









    }

    /**
     * Method to run the monthly processes of each bank account type
     */
    public void runMonthlyProcess() {


        // decision structure to see if accounts array is empty
        if (this.accounts.isEmpty()) {

            System.out.printf("***** No accounts to process *****\n");


        } else {

            // loop iterates through accounts array and updates it with method call
            for (int i = 0; i < this.accounts.size(); i++) {


                this.accounts.get(i).updateBalance();

            }

        }

    }

    /**
     * Method to print the bank accounts based on thier type
     */
    public void printAccounts(){

        // decision structure to see if accounts array is empty, prints error message if so
        if (this.accounts.isEmpty()){

            System.out.println("***** No accounts to print *****");


        } else {

            // printing account title
            printTitle();

            // loop iterates through accounts array and prints using method
            for (int i = 0; i < this.accounts.size(); i++){

                this.accounts.get(i).printAccountInfo();

            }


        }



    }


    /**
     * Method to print title of bank system
     */
    public void printTitle() {

        System.out.printf("%45s BANK\n", this.name.toUpperCase(Locale.ROOT));
        System.out.println("=====================================================================================================================");
        System.out.println("Acc Number |                Name |                   Email |                  Phone Number |            Balance ");
        System.out.println("======================================================================================================================");


    }
    public void fileReader(Scanner scanner) throws IOException {
        File accountsSource = new File("AccountsSource.txt");
        scanner=new Scanner(accountsSource);
        while(scanner.hasNext()){
            String type = scanner.next();
            if(type.equalsIgnoreCase("c")){
                accounts.add(new Chequing());

            }
            if(type.equalsIgnoreCase("s")){
                accounts.add(new Savings());
            }
            int accountNumber = Integer.parseInt(scanner.next());
            String firstName = scanner.next();
            String lastName = scanner.next();
            String email = scanner.next();
            int phoneNumber = Integer.parseInt(scanner.next());
            double accountBalance = Double.parseDouble(scanner.next());
            accounts.get(accounts.size() - 1).readFile(accountNumber,firstName,lastName,email,phoneNumber,accountBalance);
        }


    }
    public void printFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("AccountsOutput.txt"));
      for (int i =0; i<accounts.size(); i++) {
          if (accounts.get(i) instanceof Chequing){
              writer.write("C");
          }else{
              if (accounts.get(i) instanceof Savings){
                 writer.write("S");
              }
          }
          writer.write(" "+accounts.get(i).getAccountNumber()+" "+ accounts.get(i).returnFirstName()+ " "
                  + accounts.get(i).returnLastName()+" "+ accounts.get(i).returnEmail()+ " "
                  + accounts.get(i).returnPhone() + " " +accounts.get(i).getAccountBalance()+"\n");
      }
      writer.close();
    }

}
