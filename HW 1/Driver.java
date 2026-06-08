public class Driver {
    public static void main(String[] args) {
        Dairy d1 = new Dairy("apples", 3, 4.99, 1);
        Dairy d2 = new Dairy("oranges", 1);
        Dairy d3 = new Dairy();

        Dairy[] dairyArray = new Dairy[] {d1, d2, d3};

        Bakery b1 = new Bakery("bread", 4, 2.99);
        Bakery b2 = new Bakery("gluten bread", 2, 1.99);
        Bakery b3 = new Bakery("pizza bread", 7, 10.99);

        Bakery[] bakeryArray = new Bakery[] {b1, b2, b3};

        ShoppingCart cartty = new ShoppingCart(dairyArray, bakeryArray);

        cartty.addDairyItemAtIndex(1, d1);
        cartty.removeBakeryItemAtIndex(1);
        cartty.updateDairyQuantity("apples", 2);

        cartty.displayItems();
    }
}
