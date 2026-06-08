/**
 * This class extends POI and represents a type of POI.
 * @author Devin Fromond
 * @version 1.0.0
 * @since 11/2/2022
 */
public class Suspect extends PersonOfInterest {

    private int height;

    /**
     * This constructor takes in all parameters.
     * @param hairColor see super's constructor
     * @param proximity see super's constructor
     * @param rubberDuck see super's constructor
     * @param height which represents the height of the Suspect
     */
    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);
        if (height < 150) {
            height = 150;
        }
        this.height = height;
    }

    /**
     * This constructor chains to the above constructor.
     * @param proximity see chained constructor
     * @param rubberDuck see chained constructor
     */
    public Suspect(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck, 160);
    }

    /**
     * This method describes the characteristics of the Suspect.
     * @return String which represents the details of Suspect
     */
    public String toString() {
        return "Possible Suspect: " + super.toString() + " They were observed to be " + height + " cm tall.";
    }

    /**
     * This method compares the two Suspect objects.
     * @param o which is an object
     * @return boolean which represents if the two objects are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Suspect) {
            Suspect object = (Suspect) o;
            if (super.equals(object) && this.height == object.height) {
                return true;
            }
            return false;
        }
        return false;
    }
}