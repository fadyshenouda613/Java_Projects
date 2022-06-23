/**
 * Summary: Inventory class. Holds methods to create food items, update quantity, and check if they exist.
 * Student Name: Fady Shenouda
 * Student Number: 041030674
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Declaration: I declare that this is my own original work and is free from plagiarism
 *
 * @author/Professor James Mwangi PhD.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * The type Inventory.
 */
public class Inventory {

    private final ArrayList<FoodItem> inventory = new ArrayList<>();

    private int numItems = 0;

    /**
     * Default constructor of Inventory. Creates an array of FoodItem objects with the size of 20.
     */
    public Inventory() {
    }

    /**
     * Method prompts user for the type of food item they wish to add to the array. Has exception handling and error catching.
     *
     * @param keyboard [Scanner object, passed through as param.]
     * @param fromFile boolean if im reading from a file.
     * @return [Returns true or false depending on if method executes successfully.]
     */
    public boolean addItem(Scanner keyboard, boolean fromFile) {


        // setting variables
        String userInput;

        if (fromFile) { // if its from file
            String type = keyboard.nextLine(); //get type
            switch (type) { // switch case for type
                case "f" -> { // if fruit
                    Fruit fruit = new Fruit();
                    fruit.inputCode(keyboard, true); //input code
                    if (alreadyExists(fruit) == -1) { // if it already exists
                        System.out.println("Item code already exists.");
                        System.out.println("Error encountered while reading the file, aborting...");
                        return false;
                    } else if (alreadyExists(fruit) > -1) { // if it doesnt exist add the item
                        fruit.addItem(keyboard, true);
                        inventory.add(fruit);
                        return true;
                    }

                    keyboard.nextLine();
                }
                case "p" -> { //if it is preserve
                    Preserve preserve = new Preserve(); // creating new preserve
                    preserve.inputCode(keyboard, true); //input item code
                    if (alreadyExists(preserve) == -1) { // if item code already exists
                        System.out.println("Item code already exists.");
                        System.out.println("Error encountered while reading the file, aborting...");
                        return false;
                    } else if (alreadyExists(preserve) > -1) {  // if item code does not exist
                        preserve.addItem(keyboard, true);
                        inventory.add(preserve);
                        return true;
                    }
                    keyboard.nextLine();
                }
                case "m" -> { // if meat
                    Meat meat = new Meat();
                    meat.inputCode(keyboard, true); // input code
                    if (alreadyExists(meat) == -1) { // if code already exists
                        System.out.println("Item code already exists.");
                        System.out.println("Error encountered while reading the file, aborting...");
                        return false;
                    } else if (alreadyExists(meat) > -1) { // if code does not exist AKA is not a duplicate
                        meat.addItem(keyboard, true); // add item to inventory
                        inventory.add(meat); //ad item to inventory
                        return true;
                    }
                    keyboard.nextLine();
                }
                case "v" -> { // if its a vegetable
                    Vegetable vegetable = new Vegetable();
                    vegetable.inputCode(keyboard, true); // input code
                    if (alreadyExists(vegetable) == -1) { // if it already exists
                        System.out.println("Item code already exists.");
                        System.out.println("Error encountered while reading the file, aborting...");
                        return false;
                    } else if (alreadyExists(vegetable) > -1) {  // if it is not a duplicate
                        vegetable.addItem(keyboard, true); // add vegetable item
                        inventory.add(vegetable); // add the vegetable item to inventory.
                        return true;
                    }
                    keyboard.nextLine();
                }
            }
        }

        if (!fromFile) {
            boolean tryCheck = true;
            // while loop for food item prompt
            while (tryCheck) {

                // trying to determine which food item user wants to process
                try {

                    // prompting and setting input
                    System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p), or a meat(m)?: ");
                    userInput = keyboard.nextLine();


                    // if user selects fruit, proceed
                    switch (userInput) {
                        case "f", "F" -> {

                            // creating new fruit object
                            Fruit holder = new Fruit();

                            // breaking out of loop
                            tryCheck = false;

                            // setting input code of fruit object
                            holder.inputCode(keyboard, false);

                            // if food item code doesn't exist, proceed
                            if (alreadyExists(holder) > -1) {

                                // setting fruit object to array
                                inventory.add(holder);

                                // calling method to set other attributes
                                inventory.get(numItems).addItem(keyboard, false);

                                // incrementing array index by 1
                                numItems = numItems + 1;

                            } else {

                                // error message stating item exists
                                System.out.println("Item code already exists...");

                            }


                            // if vegetable is selected
                        }
                        case "v", "V" -> {

                            // creating vegetable object
                            Vegetable holder = new Vegetable();

                            // breaking out of loop
                            tryCheck = false;

                            // setting input code of object
                            holder.inputCode(keyboard, false);

                            // if code doesn't exist, proceed
                            if (alreadyExists(holder) > -1) {

                                // setting vegetable object to spot in array
                                inventory.add(holder);

                                // setting rest of attributes
                                inventory.get(numItems).addItem(keyboard, false);

                                // incrementing index by 1
                                numItems = numItems + 1;

                            } else {

                                // error message
                                System.out.println("Item code already exists...");

                            }

                            // if preserves are selected
                        }
                        case "p", "P" -> {

                            // creating preserve object
                            Preserve holder = new Preserve();

                            // breaking out of loop
                            tryCheck = false;

                            // setting item code
                            holder.inputCode(keyboard, false);

                            // if item code doesn't exist, proceed
                            if (alreadyExists(holder) > -1) {

                                // inserting preserve into array
                                inventory.add(holder);

                                // setting rest of attributes to preserve
                                inventory.get(numItems).addItem(keyboard, false);

                                // incrementing items by 1
                                numItems = numItems + 1;

                            } else {

                                // error message
                                System.out.println("Item code already exists...");

                            }


                            // if user selects meat
                        }
                        case "m", "M" -> {

                            // creating meat object
                            Meat holder = new Meat();

                            // breaking out of loop
                            tryCheck = false;

                            // setting input code of object
                            holder.inputCode(keyboard, false);

                            // if code doesn't exist, proceed
                            if (alreadyExists(holder) > -1) {

                                // inserting meat into array
                                inventory.add(holder);

                                // setting rest of meat attributes
                                inventory.get(numItems).addItem(keyboard, false);

                                // incrementing num items by 1
                                numItems = numItems + 1;

                            } else {

                                // error message
                                System.out.println("Item code already exists...");

                            }

                        }
                        default ->

                                // error message
                                System.out.println("Invalid input... try again.");
                    }
                    inventory.sort(Comparator.comparingInt(FoodItem::getItemCode));

                    // catching error
                } catch (InputMismatchException e) {

                    // clearing scanner & outputting error message
                    keyboard.nextLine();
                    System.out.println("Invalid input... try again.");

                }
            }
        }
        return false;
    }

    /**
     * Method checks if a food item code already exists within the array.
     *
     * @param item [Passed through food item to be checked]
     * @return [Returns -1 if item code already exists]
     */
    public int alreadyExists(FoodItem item) {

        // setting variables
        int index = 0;

        // if there is no item in the array, the check doesn't proceed
        if (inventory.isEmpty()) {

            return 0;

        }


        // loops through array till last populated index
        for (FoodItem foodItem : inventory) {

            // if item code in array is equal to passed through object, return -1
            if (foodItem.getItemCode() == item.getItemCode()) {


                return -1;

            }

        }


        // returns 0 if no matching code has been found
        return 0;
    }

    /**
     * Method updates the quantity of a food item. It either adds (buys) or subtracts (sells) from the quantity.
     *
     * @param keyboard  [Scanner object, passed through]
     * @param buyOrSell [Boolean value to determine buying or selling process]
     */
    public void updateQuantity(Scanner keyboard, boolean buyOrSell) {

        // creating variables
        int index = 0;

        // dummy object used to compare item codes
        FoodItem holder = new FoodItem();

        int quantity;

        // getting the last index of the inventory
        index = inventory.size() - 1;

        // if boolean = ture, proceed with buying
        if (buyOrSell) {

            // if array is empty, no items to buy
            if (inventory.isEmpty()) {

                // error message
                System.out.println("Error... no items to buy");

            } else {

                // start of do loop, boolean control variable
                boolean code = false;

                do {

                    // trying to set input code of dummy object
                    try {

                        holder.inputCode(keyboard, false);

                        code = true;

                        // catching error
                    } catch (InputMismatchException e) {

                        // clearing input & error message
                        keyboard.nextLine();
                        System.out.println("Invalid input... try again.");

                    }

                } while (!code);

                // looping through entire length of array
                for (FoodItem item : inventory) {

                    // if last populated spot in array is equal to current object in loop & current object code in array is not equal to passed through object, proceed
                    if (inventory.get(index) == item && !item.isEqual(holder)) {

                        // error message & breaking loop
                        System.out.println("Item does not exist.");
                        break;


                        // if matching code is found, proceed
                    } else if (item.isEqual(holder)) {

                        do {

                            // prompting and setting quantity to sell
                            System.out.print("Enter valid quantity to buy: ");
                            quantity = keyboard.nextInt();

                            if (quantity < 0) {

                                System.out.println("Invalid input... try again");

                            }


                        } while (quantity < 0);


                        // updating object quantity
                        item.updateItem(quantity);
                        break;

                    }

                }
            }

            // if boolean is false, proceed with selling
        } else {

            // if array empty, error message
            if (inventory.get(0) == null) {

                // error message
                System.out.println("Error... no items to sell.");


            } else {

                // boolean loop control
                boolean code = false;

                do {

                    // trying to set input code for dummy object
                    try {


                        holder.inputCode(keyboard, false);
                        code = true;

                        // catching error
                    } catch (InputMismatchException e) {

                        // clearing scanner
                        keyboard.nextLine();

                        // error message
                        System.out.println("Invalid input... try again.");

                    }

                } while (!code);

                // looping through entire length of array
                for (FoodItem item : inventory) {

                    // if last populated spot in array is equal to current object in loop & current object code in array is not equal to passed through object, proceed
                    if (inventory.get(index) == item && !item.isEqual(holder)) {

                        // error message
                        System.out.println("Item does not exist.");

                        // breaking out of loop
                        break;


                        // if current code in array is equal to dummy code, proceed
                    } else if (item.isEqual(holder)) {

                        do {

                            // prompting and setting quantity to sell
                            System.out.print("Enter valid quantity to sell: ");
                            quantity = keyboard.nextInt();

                            if (quantity < 0) {

                                System.out.println("Invalid input... try again");

                            }


                        } while (quantity < 0);

                        // if inventory quantity will be less than 0 after processing, proceed
                        if (!item.updateItem(-quantity)) {

                            // error message
                            System.out.println("Not enough stock to sell..");

                            // breaking out of if

                        }
                        break;


                    }


                }

            }
        }


    }

    /**
     * Returns the entire array of inventory objects as a formatted string
     *
     * @return [Returns formatted string]
     */
    @Override
    public String toString() {

        // creating variable
        StringBuilder holder = new StringBuilder("Inventory:\n");

        // looping through entire array until first null value is found
        for (FoodItem item : inventory) {

            if (item == null) {

                break;

            } else {

                // adding string to holder object
                holder.append(item);

            }


        }

        return holder.toString();
    }

    /**
     * Save to file.
     *
     * @param scanner the scanner
     */
    public void saveToFile(Scanner scanner) {
        try {
            System.out.println("Enter file name to save Inventory to: "); //getting save file name
            String file = scanner.next(); // file object
            FileWriter myWriter = new FileWriter(file); // writer object
            for (FoodItem food : inventory) { // enhanced for loop to write all objects in inventory into a file
                myWriter.write(food.outputItem());
            }
            myWriter.close(); // closing file
            System.out.println("Successfully wrote to the file."); //success
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Method to search for an item inside an arraylist.
     *
     * @param keyboard the scanner to scan
     */
    public void searchItem(Scanner keyboard) {
        System.out.println("Enter the code for the item: "); // searching for code
        int target = keyboard.nextInt(); // target number
        if (target < 0) { // if target is less than 0 it returns straight away
            System.out.println("This item code is invalid. Please enter a correct item code.");

        } else {
            try {
                FoodItem food = binarySearchRecursive(inventory, target, 0, inventory.size()); // doing the search
                System.out.println(food.toString()); // outputting it
            } catch (IndexOutOfBoundsException e) { // if not found
                System.out.println("The item code you entered does not exist.");// if not found
            } catch (InputMismatchException e) {// if not found
                System.out.println("Please enter a valid code.");// if not found
            } catch (NullPointerException e) {// if not found
                System.out.println("Not found..");// if not found
            }
        }
    }

    /**
     * Recursive binary search to search for an item.
     *
     * @param inventory the array of to research.
     * @param target    the target number im looking for.
     * @param low       the lowest number in arraylist.
     * @param high      the highest number in the array list.
     */

    private FoodItem binarySearchRecursive(ArrayList<FoodItem> inventory, int target, int low, int high) throws IndexOutOfBoundsException {
        if (low > high) { //if there were no items found
            return null;
        } else { //continue
            int mid = (low + high) / 2; // mid = (low + high) /2
            if (target == inventory.get(mid).getItemCode()) {
                return inventory.get(mid); //if it equals the middle number then return it.
            } else if (target > inventory.get(mid).getItemCode()) { // else if target is higher than the number then get the second half.
                return binarySearchRecursive(inventory, target, mid + 1, high);
            } else {
                return binarySearchRecursive(inventory, target, low, mid - 1); // if target is less than the number then get the first half
            }
        }
    }

    /**
     * Read from file.
     *
     * @param scanner the scanner
     * @throws FileNotFoundException the file not found exception
     */
    public void readFromFile(Scanner scanner) throws FileNotFoundException {
        System.out.println("Enter file name to read Inventory from: ");
        String f = scanner.nextLine();
        File file = new File(f);    //creates a new file instance
        //constructs a string buffer with no characters
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) { //while there is more lines in the file
            boolean success = addItem(scanner, true); //add items
            if (!success) return; //if there was a failure in reading the items quit.
        }
    }
}
