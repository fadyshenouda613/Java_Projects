/**
 * Summary: Subclass of FoodItem. Has overridden methods to add weight and toString.
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
 * The type Meat.
 */
public class Meat extends FoodItem{

    private int weight;

    /**
     * Default constructor of meat object, sets weight to 0.
     */
    public Meat(){

        this.weight = 0;

    }

    /**
     * Overridden method, prompts user for weight of meat in grams.
     * @param keyboard [Scanner object that is passed thru as param]
     * @return [Returns true if method successfully executes]
     */
    @Override
    public boolean addItem(Scanner keyboard,boolean fromFile) {

        // loop control
        boolean weight = false;
if(fromFile){
super.addItem(keyboard,true);
this.weight = keyboard.nextInt();
keyboard.nextLine();
return true;
}
else {
    // calling parent method
    super.addItem(keyboard, false);

    // loop
    do {

        try {

            // getting input
            keyboard.nextLine();
            System.out.print("Enter the weight in grams: ");
            this.weight = keyboard.nextInt();
            return true;

            // catching error
        } catch (InputMismatchException e) {
            // clearing scanner & error message
            keyboard.nextLine();
            System.out.println("Invalid input... try again.");

        }
    } while (true);
}
    }

    /**
     * Overridden to string method that prints entire meat object attributes + weight
     * @return [Returns formatted string]
     */
    @Override
    public String toString(){


        return String.format(super.toString() + " weight: %dg\n", this.weight);


    }
    /**
     * Overridden to string method that prints entire meat object attributes + weight
     * @return [Returns formatted string]
     */
    public String outputItem(){
        return "m\n"+super.outputItem() + this.weight +"\n";
    }


}
