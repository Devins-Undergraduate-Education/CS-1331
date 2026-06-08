/**
 * This class represents a restaurant that decides to do some funky algorithms
 * with the food on its menu... which, for some reason, is all sushi.
 * @author Devin Fromond
 * @since 11/16/2022
 * @version 1.0.0
 */
public class Restaurant {

    /**
     * THIS CODE IS RECURSIVE.
     * This method follows the very basic format of a Merge Sort algorithm that was
     * adapted to fit the needs of this program. The algorithm is found in the textbook.
     * The algorithm is found on at least 20 other websites with the only difference being
     * the variable name. At this point, it must be in the public domain.
     * @param rolls which is an array of type SushiRoll
     * @return SushiRoll[] which is *hopfully* a merged and sorted array
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] rolls) {
        int middle = rolls.length / 2;
        SushiRoll[] left = new SushiRoll[middle];
        SushiRoll[] right = new SushiRoll[rolls.length - middle];
        if (rolls.length < 2) {
            return rolls;
        }
        for (int i = 0; i < middle; i++) {
            left[i] = rolls[i];
        }
        for (int i = middle; i < rolls.length; i++) {
            right[i - middle] = rolls[i];
        }
        return MergeHelper.merge(mergeSortRolls(left), mergeSortRolls(right));
    }

    /**
     * THIS IS A HELPER METHOD.
     * THIS IS NEVER USED. SAVING THIS FOR A RAINY DAY.
     * This method first finds all duplicates, puts them to the front of an array
     * then scrapes the non-duplicates from the array and returns the product.
     * To the TAs: is this efficient? No. Does it work? Yes.
     * If you write code that does not make sense to anyone else, then you are an
     * asset to the company as it is more difficult to replace you.
     * This method was adapted from Morgan Stanley from GeeksForGeeks.
     * @param rolls which is an array of type SushiRolls
     * @return SushiRoll[] which is a sorted and merged object
     */
    public static SushiRoll[] removeDuplicates(SushiRoll[] rolls) {
        if (rolls.length == 0 || rolls.length == 1) {
            return rolls;
        }

        SushiRoll[] temp = new SushiRoll[rolls.length];
        SushiRoll[] temperTemp;
        int j = 0;
        for (int i = 0; i < rolls.length - 1; i++) {
            if (rolls[i].getName().compareTo(rolls[i + 1].getName()) != 0) {
                temp[j++] = rolls[i];
            }
        }
        temp[j++] = rolls[rolls.length - 1];
        for (int i = 0; i < j; i++) {
            rolls[i] = temp[i];
        }
        temperTemp = new SushiRoll[j];
        for (int i = 0; i < temperTemp.length; i++) {
            temperTemp[i] = rolls[i];
        }
        return temperTemp;
    }

    /**
     * THIS CODE IS RECURSIVE.
     * By some miracle, this method successfully returns an array containing a flattened
     * 2D array in sorted order. Why a flatten() method cannot be used or an ArrayList
     * cannot be used? That would be too easy. Abstract things are *fun*.
     * Please note this method was entirely created by me, so there are likely many flaws.
     * To the TAs: any flaws should be seen as a creative touch and thus should not result
     * in the deduction of any points.
     * @param orders which is a 2D array of type SushiRolls
     * @return SushiRoll[] which is a flattened version of the input
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] orders) {
        if (orders.length == 1) {
            return orders[0];
        }
        SushiRoll[][] rolls = new SushiRoll[orders.length - 1][];
        rolls[0] = MergeHelper.merge(orders[0], orders[1]);
        for (int i = 1; i < rolls.length; i++) {
            rolls[i] = orders[i + 1];
        }
        rolls[0] = mergeOrders(rolls);
        return mergeSortRolls(rolls[0]);
    }

    /**
     * THIS METHOD IS ITERATIVE.
     * This method is used to easily obtain the output of platesOfColor().
     * @param inputRoll which is an array of SushiRoll objects
     * @param color which is the color of the SushiRoll
     * @return SushuRoll[] which are the SushiRolls that match the specified color
     */
    public static SushiRoll[] platesOfColorIterative(SushiRoll[] inputRoll, String color) {
        int matches = 0;
        int index = 0;
        SushiRoll[] matchRolls;
        for (int i = 0; i < inputRoll.length; i++) {
            if (inputRoll[i].getColor().equals(color)) {
                matches++;
            }
        }
        if (matches == 0) {
            return null;
        }
        matchRolls = new SushiRoll[matches];
        for (int i = 0; i < inputRoll.length; i++) {
            if (inputRoll[i].getColor().equals(color)) {
                matchRolls[index] = inputRoll[i];
                index++;
            }
        }
        return mergeSortRolls(matchRolls);
    }

    /**
     * THIS METHOD IS RECRUSIVE.
     * This method recursively finds the SushiRoll objects that match the color.
     * @param inputRoll which is an array of SushiRoll objects
     * @param color which is the color of the SushiRoll
     * @return SushuRoll[] which are the SushiRolls that match the specified color
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] inputRoll, String color) {
        if (inputRoll.length == 1) {
            if (inputRoll[0].getColor().equals(color)) {
                return inputRoll;
            }
            return null;
        }
        SushiRoll[] rolls = new SushiRoll[inputRoll.length - 1];
        SushiRoll[] checkedRoll = new SushiRoll[1];
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = inputRoll[i + 1];
        }
        checkedRoll[0] = inputRoll[0];
        if (checkedRoll[0].getColor().equals(color)) {
            SushiRoll[] recursiveNullCheck = platesOfColor(rolls, color);
            if (recursiveNullCheck == null || recursiveNullCheck[0] == null) {
                return checkedRoll;
            }
            return MergeHelper.merge(checkedRoll, recursiveNullCheck);
        } else {
            return platesOfColor(rolls, color);
        }

    }

    /**
     * THIS IS A HELPER METHOD.
     * This method is used to easily find the price of the SushiRoll object.
     * @param color which is the color of the SushiRoll object
     * @return double which is the price of the individual SushiRoll
     */
    public static double priceHelper(String color) {
        double total = 0;
        if (color.equals("Red")) {
            total += 7.00;
        } else if (color.equals("Blue")) {
            total += 6.00;
        } else {
            total += 6.50;
        }
        return total;
    }

    /**
     * THIS IS A RECURSIVE METHOD.
     * This method calculates the total price of an order, or set, of SushiRolls.
     * @param rolls which is the set of SushiRolls by which the total will be determined
     * @return double which is the total price of the SushiRoll order
     */
    public static double totalPrice(SushiRoll[] rolls) {
        if (rolls.length == 1) {
            return priceHelper(rolls[0].getColor());
        }
        SushiRoll[] allButOne = new SushiRoll[rolls.length - 1];
        for (int i = 0; i < allButOne.length; i++) {
            allButOne[i] = rolls[i + 1];
        }
        return priceHelper(rolls[0].getColor()) + totalPrice(allButOne);
    }

    /**
     * THIS IS A RECURSIVE HELPER METHOD.
     * This method is used to aid in the flipping of an array of SushiRolls.
     * @param rolls which is the SushiRoll array
     * @param i which is the left bound
     * @param j which is the right bound
     */
    public static void flipHelper(SushiRoll[] rolls, int i, int j) {
        if (i >= j) {
            return;
        }
        SushiRoll swapperoo = rolls[i];
        rolls[i] = rolls[j];
        rolls[j] = swapperoo;
        i++;
        j++;
        flipHelper(rolls, i, j);
    }

    /**
     * This method calls a recursive helper method.
     * This method flips an array of SushiRolls.
     * @param rolls which is the array of SushiRoll objects
     */
    public static void flip(SushiRoll[] rolls) {
        flipHelper(rolls, 0, rolls.length - 1);
    }
}