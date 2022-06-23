/**
 * Summary: This class contains the main method of the program.
 * Student Name: Fady Shenouda
 * Student Number: 041030674
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Declaration: I declare that this is my own original work and is free from plagarism
 *
 * @author/Professor James Mwangi PhD.
 */

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assign2 {

    /**
     * Main method that executes the program..
     *
     * @param args [Arguments of program]
     */
    public static void main(String[] args) {

        // Creating inventory object
        Inventory inventory = new Inventory();

        // Creating scanner object
        Scanner keyboard = new Scanner(System.in);

        // loop control
        boolean menuOn = true;

        // user inputs
        int userInput = 0;

        // loop
        while (menuOn) {

            // start of try statement
            try {

                // calling static menu method
                displayMenu();

                // getting user input
                userInput = keyboard.nextInt();
                keyboard.nextLine();

                // switch case statement start
                switch (userInput) {
                    case 1 ->
                            // calling method to add item to inventory
                            inventory.addItem(keyboard, false);
                    case 2 ->

                            // printing entire inventory
                            System.out.println(inventory.toString());
                    case 3 -> {

                        // calling buy  method
                        boolean buy = true;
                        inventory.updateQuantity(keyboard, buy);
                    }
                    case 4 -> {

                        // calling sell method
                        boolean sell = false;
                        inventory.updateQuantity(keyboard, sell);
                    }
                    case 5 -> inventory.searchItem(keyboard); // searching for item
                    case 6 -> inventory.saveToFile(keyboard); // saving inventory to file
                    case 7 -> inventory.readFromFile(keyboard); // reading inventory from file.
                    case 8 -> {

                        // ending loop
                        menuOn = false;

                        // exit message
                        System.out.println("Program exiting... Created by Fady Shenouda");

                        // closing scanner
                        keyboard.close();
                    }
                    default -> System.out.println("Invalid input... try again.");
                }


                // catching error
            } catch (InputMismatchException e) {

                // clearing scanner and printing error message
                keyboard.nextLine();
                System.out.println("Invalid input... try again.");

            } catch (FileNotFoundException e) {
                // clearing scanner and printing error message

                keyboard.nextLine();
                System.out.println("The file was not found!");
            }


        }


    }


    /**
     * Static method to display menu.
     */
    static void displayMenu() {
//displays menu
        System.out.print("Please select one of the following:\n" +
                "1: Add item to inventory\n" +
                "2: Display current inventory\n" +
                "3: Buy item(s)\n" +
                "4: Sell item(s)\n" +
                "5: Search for Item\n" +
                "6: Save Inventory to file\n" +
                "7: Read Inventory from file\n" +
                "8: To exit\n" +
                "Input: ");

    }


}
