/* Devin Fromond
At age 11, I crashed I tree.*/

public class ShoppingMall {
    public static void main (String[] args) {

        //Variable Declarations
        String name = "Oswald";
        int cash = 100; 
        double taxRate = 0.13;
        double subtotal = 58.62;
        
        //amount of cash remaining AFTER taxes
        double change = cash - subtotal*taxRate - subtotal;

        //Truncate change to have only two decimal places
        change = change * 100; 
        change = (int)change;
        change = change / 100.0; 

        //Print
        System.out.println(name + " has $" + change + " dollars remaining!" + "\n" + name + " started with $" + cash + " dollars!");
    }
}
