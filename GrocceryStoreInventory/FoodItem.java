/**
 * Summary: Parent class of all food objects. Has methods to set food attributes, update quantity, input food code, and buy or sell items.
 * Student Name: Fady Shenouda
 * Student Number: 041030674
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Declaration: I declare that this is my own original work and is free from plagarism
 *
 * @author/Professor James Mwangi PhD.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The type Food item.
 */
public class FoodItem {

    private int itemCode;

    private String itemName;

    private float itemPrice;

    private int itemQuantityInStock;

    private float itemCost;


    /**
     * Default constructor of food item. Sets all values of food object to null/0.
     */
    public FoodItem() {

        // Setting values to null/0
        this.itemCode = 0;
        this.itemName = null;
        this.itemPrice = 0;
        this.itemQuantityInStock = 0;
        this.itemCost = 0;


    }

    /**
     * Method prompts user for inputs for food item attributes like name, quantity, cost etc
     *
     * @param keyboard [Scanner object that is passed thru as param]
     * @param fromFile the from file
     * @return [Returns true if program successfully processes]
     */
    public boolean addItem(Scanner keyboard,boolean fromFile) {

        // setting loop control variables
        boolean name = false;
        boolean quantity = false;
        boolean cost = false;
        boolean sales = false;

        if(fromFile){ // if its from file
            keyboard.nextLine();
            this.itemName = keyboard.nextLine();
            this.itemQuantityInStock= keyboard.nextInt();
            this.itemPrice = keyboard.nextFloat();
            this.itemCost = keyboard.nextFloat();
            keyboard.nextLine();
            return true;
            }

        else {
            // Name input while loop
            do {

                // trying to take name input
                try {

                    // clearing scanner
                    keyboard.nextLine();

                    // prompting input
                    System.out.print("Enter the name for the item: ");

                    // setting input
                    this.itemName = keyboard.nextLine();

                    // breaking out of loop condition
                    name = true;

                    // catching error
                } catch (InputMismatchException e) {

                    // clearing scanner and outputting error message
                    keyboard.nextLine();
                    System.out.println("Invalid input... try again.");

                }

            } while (!name);


            // Quantity input while loop
            do {

                // trying to take quantity input
                try {

                    // prompting input
                    System.out.print("Enter the quantity for the item: ");

                    // setting input
                    this.itemQuantityInStock = keyboard.nextInt();

                    // checking if inputted stock quantity is less than 1
                    if (this.itemQuantityInStock < 1) {

                        // error message
                        System.out.println("Invalid input... try again.");

                    } else {

                        // breaking out of loop
                        quantity = true;

                    }

                    // catching error
                } catch (InputMismatchException e) {

                    // clearing scanner and outputting error message
                    keyboard.nextLine();
                    System.out.println("Invalid input... try again.");

                }

            } while (!quantity);

            // Cost input while loop
            do {

                // trying to take cost input
                try {

                    // prompting input
                    System.out.print("Enter the cost of the item: ");

                    // setting input
                    this.itemCost = keyboard.nextFloat();

                    // making sure item cost isn't negative
                    if (this.itemCost < 0) {

                        System.out.println("Invalid input... try again.");

                    } else {

                        // breaking out of loop
                        cost = true;

                    }

                    // catching error
                } catch (InputMismatchException e) {

                    // clearing scanner & outputting error
                    keyboard.nextLine();
                    System.out.println("Invalid input... try again.");

                }

            } while (!cost);


            // sales price of item loop
            do {

                // trying to set sales price of item
                try {

                    // prompting input
                    System.out.print("Enter the sales price of the item: ");

                    // setting input
                    this.itemPrice = keyboard.nextFloat();

                    // item price can't be negative
                    if (this.itemPrice < 0) {

                        System.out.println("Invalid input... try again");

                    } else {

                        // breaking out of loop and returning true for successful program run
                        sales = true;
                        return true;
                    }

                    // catching error
                } catch (InputMismatchException e) {

                    // clearing scanner & outputting error
                    keyboard.nextLine();
                    System.out.print("Invalid input");

                }

            } while (!sales);

        }
            // return false for bad method run
            return false;

    }

    /**
     * Method updates the quantity of the food item. Checks if the resulting stock amount will result in 0.
     *
     * @param amount amount is the quantity of the item
     * @return returns true or false according to successfully added or no.
     */
    public boolean updateItem(int amount) {


        // if resulting stock is less than 0, return false
        if (this.itemQuantityInStock + amount < 0) {

            return false;

        } else {

            // else complete transaction and return true
            this.itemQuantityInStock = this.itemQuantityInStock + amount;

            return true;

        }


    }

    /**
     * Method checks if passed thru food item code matches another.
     *
     * @param item the item
     * @return return true or false according to if the item code matches.
     */
    public boolean isEqual(FoodItem item) {

        // if item codes match, return true
        // return false if don't match
        return item.itemCode == this.itemCode;
    }

    /**
     * Method prompts user for input code of food item.
     *
     * @param keyboard [Scanner object, passed thru as param]
     * @param b        the b
     */
    public void inputCode(Scanner keyboard, boolean b) {

if(b){
    this.itemCode = keyboard.nextInt();
}
else {
    do {

        // trying to get code for food item
        try {

            // prompting and setting input
            System.out.print("Enter the code for the item: ");
            this.itemCode = keyboard.nextInt();

            // breaking out fo loop and returning true
            return;

            // catching error
        } catch (InputMismatchException e) {

            // clearing scanner and outputting error message
            keyboard.nextLine();
            System.out.println("Invalid input... try again.");

        }

    } while (true);
}
    }

    /**
     * Method returns food item as a formatted string.
     *
     * @return [Returns food item as formatted string.]
     */
    @Override
    public String toString() {

        // formatting string object
        return String.format("Item: %d | %s | %d | price: %.2f$ | cost: %.2f$ |", this.itemCode, this.itemName, this.itemQuantityInStock, this.itemPrice, this.itemCost);

    }

    /**
     * Gets item code.
     *
     * @return the item code
     */
    public int getItemCode() {
        return itemCode; // returns Item code.
    }

    /**
     * Output item string.
     *
     * @return String format
     */
    public String outputItem(){
        return itemCode + "\n" + itemName + "\n" + itemQuantityInStock + "\n" + itemCost + "\n" + itemPrice + "\n";
    }


}
