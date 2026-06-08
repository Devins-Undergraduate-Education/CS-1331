/**
 * The class represents a child of POI which has characteristics from POIs.
 * @author Devin Fromond
 * @version 1.0.0
 * @since 11/2/2022
 */
public class Accomplice extends PersonOfInterest {

    private boolean canCode;

    /**
     * Getter method to get canCode.
     * @return boolean which returns the value of canCode
     */
    public boolean getCanCode() {
        return canCode;
    }

    /**
     * Constructor which takes in all values.
     * @param hairColor see super's constructor
     * @param proximity see super's constructor
     * @param rubberDuck see super's constructor
     * @param canCode which can be T/F
     */
    public Accomplice(Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }

    @Override
    public String toString() {
        if (canCode) {
            return "Possible Accomplice: " + super.toString() + " They do have the ability to hack doorbells.";
        }
        return "Possible Accomplice: " + super.toString() + " They do not have the ability to hack doorbells.";
    }

    /**
     * This method compares the two Suspect objects.
     * @param o which is an object
     * @return boolean which represents if the two objects are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Accomplice) {
            Accomplice object = (Accomplice) o;
            if (super.equals(object) && this.canCode == object.canCode) {
                return true;
            }
        }
        return false;
    }
}