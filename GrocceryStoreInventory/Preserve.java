/**
 * Summary:  Subclass of FoodItem. Has overridden methods to add jar size and toString.
 * Student Name: Fady Shenouda
 * Student Number: 041030674
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Declaration: I declare that this is my own original work and is free from plagarism
 * @author/Professor James Mwangi PhD.
 *
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The type Preserve.
 */
public class Preserve extends FoodItem{

    private int jarSize;


    /**
     * Default constructor of Preserve, sets jarSize to 0
     */
    public Preserve(){

    this.jarSize = 0;

    }

    /**
     * Overridden method, prompts user to add jarSize value.
     * @param keyboard [Scanner object that is passed thru as param]
     * @return [Returns true or false based on successful method execution]
     */
    @Override
    public boolean addItem(Scanner keyboard,boolean fromFile) {

        // boolean loop control
        boolean jar = false;
        if (fromFile) {
super.addItem(keyboard,true);
this.jarSize = keyboard.nextInt();
keyboard.nextLine();
return true;
        } else {
            // calling parent method
            super.addItem(keyboard, false);

            // loop
            do {

                try {

                    // prompting jar size
                    System.out.print("Enter the jar size: ");

                    // setting jar size
                    this.jarSize = keyboard.nextInt();

                    if (this.jarSize < 0) {

                        System.out.println("Invalid input... try again.");

                    } else {

                        return true;
                    }

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
     * ToString method, returns preserve object as formatted string
     * @return [Returns formatted string]
     */
    @Override
    public String toString(){


        return String.format(super.toString() + " jar size: %smL\n", this.jarSize);


    }
    /**
     * Overriden output item.
     * @return [Returns formatted string]
     */
    public String outputItem(){
        return "p\n"+super.outputItem() + this.jarSize +"\n";
    }
    }
