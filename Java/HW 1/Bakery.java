public class Bakery {

    //variable declaration
    private String product;
    private int quantity;
    private double cost;

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

    //constructors
    public Bakery(String product, int quantity, double cost) {
        setProduct(product);
        setQuantity(quantity);
        setCost(cost);
    }
}