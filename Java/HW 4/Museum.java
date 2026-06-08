public class Museum extends Attraction {

    private final int maxCapacity;
    private int occupancy = 0;

    public Museum(String name, double admissionFee, int maxCapacity) {
        super(name, admissionFee);
        if (maxCapacity < 25) {
            maxCapacity = 25;
        }
        this.maxCapacity = maxCapacity;
    }

    public Museum(String name) {
        this(name, 5.25, 25);
    }

    public void admit(String[] people) {
        if (occupancy + people.length > maxCapacity) {
            System.out.println("Museum has reached maxium capacity. Please visit another time!");
        } else {
            super.admit(people);
            occupancy += people.length;
        }
    }

    public void rateAndExit(int index, int rating) {
        super.rateAndExit(index, rating);
        occupancy -= 5;
    }

    public double percentOccupancy() {
        return Math.round(occupancy / maxCapacity * 100.00) / 100.00;
    }

    @Override
    public String toString() {
        return "Museum: " + super.toString() + "/" + percentOccupancy() + "%";
    }
}