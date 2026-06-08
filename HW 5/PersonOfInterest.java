/**
 * This class represents the characteristics of someone who is of interest to the case.
 * @author Devin Fromond
 * @version 1.0.0
 * @since 11/2/2022
 */
public class PersonOfInterest {

    private Color hairColor;
    private int proximity;
    private RubberDuck rubberDuck;

    /**
     * This is a getter method to allow rubberDuck to be accessed across classes.
     * @return rubberDuck which represents a RubberDuck object
     */
    public RubberDuck getRubberDuck() {
        return rubberDuck;
    }

    /**
     * This constructor takes in all values and establishes in default values.
     * @param hairColor which represents the hair color of the POI
     * @param proximity which represnets the distance from the scene of the POI
     * @param rubberDuck which represents the rubberDuck the POI has
     */
    public PersonOfInterest(Color hairColor, int proximity, RubberDuck rubberDuck) {

        if (hairColor == null) {
            hairColor = Color.BLACK;
        }
        if (rubberDuck == null) {
            rubberDuck = new RubberDuck(Color.YELLOW, true);
        }

        this.hairColor = hairColor;
        this.proximity = Math.abs(proximity);
        this.rubberDuck = rubberDuck;
    }

    /**
     * This constructor takes in some values and preforms constructor chaining.
     * @param proximity see main constructor
     * @param rubberDuck see main constructor
     */
    public PersonOfInterest(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck);
    }

    @Override
    public String toString() {
        return "A POI with " + hairColor + " hair was last seen " + proximity
            + " miles away holding " + rubberDuck.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PersonOfInterest || o instanceof Suspect || o instanceof Accomplice) {
            PersonOfInterest object = (PersonOfInterest) o;
            if (this.hairColor == object.hairColor && this.proximity == object.proximity
                && this.rubberDuck.equals(object.rubberDuck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method compares two POIs.
     * @param object which can be an object of POI or a child of POI
     * @return int which can be positive, negative, or 0
     */
    public int compareTo(PersonOfInterest object) {
        if (object == null || this.hairColor == null || object.hairColor == null) {
            return -1;
        } else if (this.proximity == object.proximity) {
            return this.hairColor.compareTo(object.hairColor);
        } else if (this.proximity < object.proximity) {
            return -1;
        }
        return 1;
    }
}