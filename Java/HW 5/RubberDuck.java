/**
 * RubberDuck represents an item that the suspect or accomplice can carry.
 * The Duck's characteristics are defined by a coolor and its hat, if appliciable.
 * @author Devin Fromond
 * @version 1.0.0
 * @since 11/2/2022
 */
public class RubberDuck {

    private final Color color;
    private final boolean hasHat;

    /**
     * The constructor takes in all inputs.
     * @param color represents the color of a duck
     * @param hasHat represents whether the duck is wearing a hat
     */
    public RubberDuck(Color color, boolean hasHat) {
        this.color = color;
        this.hasHat = hasHat;
    }

    /**
     * The constructor takes in one input and constructor chains.
     */
    public RubberDuck() {
        this(Color.YELLOW, true);
    }

    @Override
    public String toString() {
        if (hasHat) {
            return "a " + color + " rubber duck with a hat.";
        }
        return "a " + color + " rubber duck without a hat.";
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == this.getClass()) {
            RubberDuck object = (RubberDuck) o;
            if (this.color == object.color && this.hasHat == object.hasHat) {
                return true;
            }
        }
        return false;
    }
}