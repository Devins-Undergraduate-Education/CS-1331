public class ShoppingCart {

    //variable declaration
    private Dairy[] dairyItems;
    private Bakery[] bakeryItems;

    //constructors
    public ShoppingCart(Dairy[] dairyItems, Bakery[] bakeryItems) {
        this.dairyItems = dairyItems;
        this.bakeryItems = bakeryItems;
    }

    public ShoppingCart() {
        //Bakery[] bakeryItems = new Bakery[2];
        //bakeryItems[0] = new Bakery("Bread", 1, 5.99);
        //Dairy[] dairyItems = new Dairy[4];
    }

    //methods
    public Dairy addDairyItemAtIndex(int index, Dairy parameterDairy) {
        if (index > dairyItems.length - 1 || parameterDairy == null) {
            System.out.println("Cannot add Dairy item!");
            return null;
        } else if (dairyItems[index] == null) {
            dairyItems[index] = parameterDairy;
            System.out.println(parameterDairy.getProduct() + " was added here.");
            return null;
        } else {
            Dairy presentProduct = dairyItems[index];
            System.out.println("There was " + presentProduct.getProduct() + " here before.");
            dairyItems[index] = parameterDairy;
            return presentProduct;
        }
    }

    public Bakery removeBakeryItemAtIndex(int index) {
        if (bakeryItems[index] == null) {
            System.out.println("No Bakery item exists at this index!");
            return null;
        } else if (bakeryItems.length - 1  < index) {
            System.out.println("Invalid index entered.");
            return null;
        } else {
            Bakery toBeRemoved = bakeryItems[index];
            System.out.println(toBeRemoved.getProduct() + " was removed from the cart.");
            bakeryItems[index] = null;
            return toBeRemoved;
        }
    }

    public void updateDairyQuantity(String productName, int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Invalid quantity entered.");
        } else {
            for (int i = 0; i < dairyItems.length; i++) {
                if (dairyItems[i].getProduct().toLowerCase().equals(productName.toLowerCase())) {
                    int oldQuantity = dairyItems[i].getQuantity();
                    dairyItems[i].setQuantity(newQuantity);
                    System.out.println("Quantity of " + productName + " was updated from "
                        + oldQuantity + " to " + newQuantity + ".");
                } else {
                    System.out.println("No such Dairy item exists in the cart!");
                }
            }
        }
    }

    public void displayItems() {
        for (int i = 0; i < dairyItems.length; i++) {
            if (dairyItems[i] == null) {
                System.out.println("null");
            } else {
                System.out.print("Dairy Product: " + dairyItems[i].getProduct() + " ");
                System.out.print("Quantity: " + dairyItems[i].getQuantity() + " ");
                System.out.printf("Cost: %.2f\n", dairyItems[i].getCost());
            }
        }
        for (int i = 0; i < bakeryItems.length; i++) {
            if (bakeryItems[i] == null) {
                System.out.println("null");
            } else {
                System.out.print("Bakery Product: " + bakeryItems[i].getProduct() + " ");
                System.out.print("Quantity: " + bakeryItems[i].getQuantity() + " ");
                System.out.printf("Cost: %.2f\n", bakeryItems[i].getCost());
            }
        }
    }
}