/**
 * Summary:  Subclass of FoodItem. Has overridden methods to add farm name and toString.
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
 * The type Vegetable.
 */
public class Vegetable extends FoodItem {

    private String farmName;


    /**
     * Default constructor of vegetable, sets farm name to null.
     */
    public Vegetable() {

        this.farmName = null;

    }

    /**
     * Overridden method that promps user for farm name.
     * @param keyboard [Scanner object that is passed thru as param]
     * @return [Returns true or false based on successful execution]
     */
    @Override
    public boolean addItem(Scanner keyboard,boolean fromFile) {
        // loop control
        boolean farm = false;

        if (fromFile) {
super.addItem(keyboard,true);
this.farmName = keyboard.nextLine();
return true;
        } else {
            // adding item with keyboard passed thru
            super.addItem(keyboard, false);

            // loop
            do {

                try {

                    // getting inputs
                    keyboard.nextLine();
                    System.out.print("Enter the farm name: ");

                    // setting inputs
                    this.farmName = keyboard.nextLine();

                    return true;

                    // catching error
                } catch (InputMismatchException e) {


                    keyboard.nextLine();
                    // error message
                    System.out.println("Invalid input... try again.");

                }

            } while (true);


        }
    }

    /**
     * Overridden toString method, returns vegetable object as formatted string
     * @return [Fromatted string]
     */
    @Override
    public String toString() {

        return String.format(super.toString() + " farm name: %s\n", this.farmName);

    }
    /**
     * Overridden outputitem method to return the formatted string.
     * @return [Fromatted string]
     */
    public String outputItem() {
        return "v\n" + super.outputItem() + this.farmName +"\n";
    }
}
