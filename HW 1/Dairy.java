public class Dairy {

    //variable declaration
    private String product;
    private int quantity;
    private double cost;
    private int daysToExpiration;
    private boolean isConsumable;

    //getters and setters
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDaysToExpiration() {
        return daysToExpiration;
    }
    public void setDaysToExpiration(int daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    public boolean getIsConsumable() {
        return isConsumable;
    }
    public void setIsConsumable(boolean isConsumable) {
        this.isConsumable = isConsumable;
    }

    //helper method
    public boolean determineIfConsumable(int daysUntilExpiration) {
        if (daysUntilExpiration >= 3) {
            setIsConsumable(true);
            System.out.println("Good choice!");
        } else {
            setIsConsumable(false);
            System.out.println("Check the expiration date");
        }
        return getIsConsumable();
    }

    //constructors
    public Dairy(String product, int quantity, double cost, int daysToExpiration) {
        setProduct(product);
        setQuantity(quantity);
        setCost(cost);
        setDaysToExpiration(daysToExpiration);
        setIsConsumable(determineIfConsumable(getDaysToExpiration()));
    }

    public Dairy(String product, int quantity) {
        setProduct(product);
        setQuantity(quantity);
        setCost(5.99);
        setDaysToExpiration(5);
        setIsConsumable(determineIfConsumable(getDaysToExpiration()));
    }

    public Dairy() {
        setProduct("yogurt");
        setQuantity(4);
        setCost(3.99);
        setDaysToExpiration(3);
        setIsConsumable(determineIfConsumable(getDaysToExpiration()));
    }
}