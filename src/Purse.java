
// Title: Purse.java
// Author: Kevin Nard
// Purse class represents a Purse that can hold notes and coins:
//      public Map<Denomination, Integer> cash - stores denomination/amount pairs
//      public void add(Denomination type, int num) - adds some amount of denomination
//      public double remove(Denomination type, int num) - removes some amount of denomination
//      public double getValue() - gets the value of all the change
//      public String toString() - gets a string representation of all the change

import java.util.HashMap;
import java.util.Map;

public class Purse {

    // Data structure to store denomination/amount pairs
    public Map<Denomination, Integer> cash = new HashMap<>();

    // Add some amount of denomination to the Purse
    public void add(Denomination type, int num) {

        // If cash does not already contain denomination, initialize with 0
        if (!cash.containsKey(type))
            cash.put(type, 0);

        cash.put(type, cash.get(type) + num);
    }

    // Remove some amount of denomination from the Purse
    public double remove(Denomination type, int num) {

        // If cash does not already contain denomination, return 0.0
        if (!cash.containsKey(type))
            return 0.0;

        cash.put(type, cash.get(type) - num);

        // Remove denomination if value is 0
        if (cash.get(type) == 0)
            cash.remove(type);

        return type.amt() * num;
    }

    // Return the total value of change in the Purse
    public double getValue() {

        double sum = 0;

        // Loop through all entries and sum(amt * value)
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sum += entry.getKey().amt() * entry.getValue();
        }

        return sum;
    }

    // Return a String representation of the change in the Purse
    public String toString() {

        String return_string = "";

        // Loop through each denomination and append to return_string if exists
        for (Denomination denomination : Register.DENOMINATION_ARRAY) {

            // Skip if cash does not contain denomination
            if (!cash.containsKey(denomination))
                continue;

            // Formats the string to be added to return_string
            int amt = cash.get(denomination);
            String suffix = amt == 1 ? "" : "s";
            String name = denomination.name();

            // Edge case to display plural "Pennies" properly
            if (name.equals("Penny") && amt != 1)
                name = "Pennie";

            return_string = return_string.concat(amt + " " + name + suffix + "\n");
        }

        // Edge case if Purse is empty
        if (return_string.isEmpty())
            return_string = "Empty Purse\n";

        return return_string;
    }
}
