
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

public class Register {

    // Denomination records
    private static final Denomination hundred_note = new Denomination("Hundred Note", 100.00, Form.NOTE, "img/hundred_note.png");
    private static final Denomination fifty_note = new Denomination("Fifty Note", 50.00, Form.NOTE, "img/fifty_note.png");
    private static final Denomination twenty_note = new Denomination("Twenty Note", 20.00, Form.NOTE, "img/twenty_note.png");
    private static final Denomination ten_note = new Denomination("Ten Note", 10.00, Form.NOTE, "img/ten_note.png");
    private static final Denomination five_note = new Denomination("Five Note", 5.00, Form.NOTE, "img/five_note.png");
    private static final Denomination one_note = new Denomination("One Note", 1.00, Form.NOTE, "img/one_note.png");
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
        double ticker = amt;

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

        // Create Register and make some change
        Register myRegister = new Register();
        Purse myPurse = myRegister.makeChange(20.96);

        // Test Purse methods and output
        System.out.println("\nChange:");
        System.out.println(myPurse.toString());
        System.out.println("Total:");
        System.out.println(myPurse.getValue());
        System.out.printf("\nRemoving $%.2f\n\n", myPurse.remove(twenty_note, 1));
        System.out.println("Change:");
        System.out.println(myPurse.toString());
        System.out.println("Total:");
        System.out.println(myPurse.getValue());
        System.out.println();
    }
}
