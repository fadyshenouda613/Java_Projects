/**
 * Summary:  Subclass of FoodItem. Has overridden methods to add orchard and toString.
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
 * The type Fruit.
 */
public class Fruit extends FoodItem {

    private String orchardName;


    /**
     * Default constructor of fruit object, sets orchard name to null.
     */
    public Fruit() {
        this.orchardName = null;

    }

    /**
     * Overridden method, prompts and sets orchard supplier name.
     *
     * @param keyboard [Scanner object that is passed thru as param]
     * @return [Returns true or false based on successful method execution]
     */
    @Override
    public boolean addItem(Scanner keyboard, boolean fromFile) {

        if (fromFile) { // if from file
            super.addItem(keyboard, true);
            this.orchardName = keyboard.nextLine();
            return true;
        } else {
            // calling parent method
            super.addItem(keyboard, false);

            // loop
            do {

                try {

                    // prompting user input
                    keyboard.nextLine();
                    System.out.print("Enter name of orchard supplier: ");

                    // setting user input
                    this.orchardName = keyboard.nextLine();
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
     * Overridden toString method, returns Fruit object as formatted string.
     *
     * @return [Returns formatted string]
     */
    @Override
    public String toString() {


        return String.format(super.toString() + " orchard supplier: %s\n", this.orchardName);


    }
    /**
     * Overriden string output.
     *
     * @return [String Format]
     */
    public String outputItem() {
        return "f\n" + super.outputItem() + this.orchardName + "\n";
    }

}
