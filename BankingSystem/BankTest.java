package com.company;/*
 * File description: Main class of program, holds menu loop for banking system.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: Feb 27
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is to loop thru menu options and read accounts / run monthly processes / print all accounts.
 * @author Fady Shenouda
 * @version 1.0
 * @since 1.8
 */
public class BankTest {


    public static void main(String arg[]){

        /** Scanner variable for main class**/
        Scanner keyboard = new Scanner(System.in);

        /** The name of the bank**/
        String name = null;

        /** The input choice of user **/
        int menuChoice = 0;

        /** The amount of accounts to be stored initially**/
        int numAccounts = 0;

        /** Default state of menu **/
        boolean menuOn = true;


        // Requesting and reading bank name input
        System.out.print("Enter the name of the Bank: ");
        name = keyboard.nextLine();


        // Requesting and reading number of accounts
        System.out.print("Enter number of accounts: ");
        numAccounts = keyboard.nextInt();
        while (numAccounts <= 0){

            System.out.println("*** Please enter a non-negative / 0 number ***");
            System.out.print("Number of accounts: ");
            numAccounts = keyboard.nextInt();

        }


        // Creating bank object with overloaded constructor, using previous variables to set name and student size
        Bank bank = new Bank(name, numAccounts);


        // While loop that keeps menu running
        while (menuOn == true){

try{
    // Displaying menu options
    System.out.println("1. Read account");
    System.out.println("2. Run monthly process");
    System.out.println("3. Print all accounts");
    System.out.println("4. Read data from file");
    System.out.println("5. Write data to file");
    System.out.println("6. Exit");


    // Requesting and reading user input for menu option
    System.out.print("Enter your option: ");
    menuChoice = keyboard.nextInt();

}catch(InputMismatchException e){ //input missmatch exception
    System.out.println("Please enter a valid menu option!"); //output
    keyboard.next();
}


            // Switch decision structure, 3 options
            switch(menuChoice){


                // Menu option 1.
                case 1:

                    // Calls method readAccounts from bank object, passes in Scanner
                    bank.readAccounts(keyboard);
                    break;


                // Menu option 2.
                case 2:

                    // Calls method runMonthlyProcess from bank object
                    bank.runMonthlyProcess();
                    break;


                // Menu option 3.
                case 3:

                    // Calls method printAccounts from bank object
                    bank.printAccounts();
                    break;
                case 4:

                    try {
                        bank.fileReader(keyboard);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    try {
                        bank.printFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;



                case 6:
                    menuOn = false;
                    break;


                // Default case option, if user inputs an invalid menu option error message is displayed
                default:

                    // invalid input error message
                    System.out.printf("***** Invalid option. . . Please try again *****\n");
                    break;

            }

        }

        // Closing Scanner object
        keyboard.close();

    }


}


