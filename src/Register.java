
// Title: Register.java
// Author: Kevin Nard
// Register class represents a register that can make change:
//      private static final Denomination hundred_note - hundred note record
//      private static final Denomination fifty_note - fifty note record
//      private static final Denomination twenty_note - twenty note record
//      private static final Denomination ten_note - ten note record
//      private static final Denomination five_note - five note record
//      private static final Denomination one_note - one note record
//      private static final Denomination quarter - quarter record
//      private static final Denomination dime - dime record
//      private static final Denomination nickel - nickel record
//      private static final Denomination penny - penny record
//      private static final ArrayList<Denomination> denomination_array - array of denomination records
//      public Purse makeChange(double amt) - returns a Purse with change
//      public static void main(String[] args) - creates a Register and tests Purse methods

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Register {

    // Denomination records
    private static final Denomination hundred_note = new Denomination("Hundred-Dollar Note", 100.00, Form.NOTE, "img/hundred_note.png");
    private static final Denomination fifty_note = new Denomination("Fifty-Dollar Note", 50.00, Form.NOTE, "img/fifty_note.png");
    private static final Denomination twenty_note = new Denomination("Twenty-Dollar Note", 20.00, Form.NOTE, "img/twenty_note.png");
    private static final Denomination ten_note = new Denomination("Ten-Dollar Note", 10.00, Form.NOTE, "img/ten_note.png");
    private static final Denomination five_note = new Denomination("Five-Dollar Note", 5.00, Form.NOTE, "img/five_note.png");
    private static final Denomination one_note = new Denomination("One-Dollar Note", 1.00, Form.NOTE, "img/one_note.png");
    private static final Denomination quarter = new Denomination("Quarter", 0.25, Form.COIN, "img/quarter.png");
    private static final Denomination dime = new Denomination("Dime", 0.10, Form.COIN, "img/dime.png");
    private static final Denomination nickel = new Denomination("Nickel", 0.05, Form.COIN, "img/nickel.png");
    private static final Denomination penny = new Denomination("Penny", 0.01, Form.COIN, "img/penny.png");

    // Array of denominations for use in loops
    private static final ArrayList<Denomination> denomination_array = new ArrayList<>(Arrays.asList(
            hundred_note,
            fifty_note,
            twenty_note,
            ten_note,
            five_note,
            one_note,
            quarter,
            dime,
            nickel,
            penny
    ));

    // Takes an amount and makes a Purse object filled with change
    public Purse makeChange(double amt) {

        Purse return_purse = new Purse();
        double ticker = amt + 0.005;

        // Loop through set of denominations and add to purse
        for (Denomination denomination : denomination_array) {
            if ((int) (ticker / denomination.amt()) > 0)
                return_purse.add(denomination, (int) (ticker / denomination.amt()));

            ticker -= (int) (ticker / denomination.amt()) * denomination.amt();
        }

        return return_purse;
    }

    // Creates Register object and tests Purse methods
    public static void main(String[] args) {

        boolean validated = false;
        double input_value = 0.0;

        System.out.println("\nEnter the amount of change you wish to make:");

        // Input validation loop
        while (!validated) {
            Scanner input = new Scanner(System.in);

            // Restart loop if user fails to enter a double
            if (!input.hasNextDouble()) {
                System.out.println("ERROR: Please enter a dollar amount!");
                continue;
            }

            // Assign input_value and round
            input_value = input.nextDouble();
            input_value = Math.round(input_value * 100.0) / 100.0;

            validated = true;
        }

        // Create Register and make some change
        Register myRegister = new Register();
        Purse myPurse = myRegister.makeChange(input_value);

        // Output Purse contents to console
        System.out.println("\nChange:");
        System.out.println(myPurse.toString());
    }
}
