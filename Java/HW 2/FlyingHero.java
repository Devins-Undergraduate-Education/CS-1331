/**
 * The FlyingHero program is a child class
 * of SuperheroRecruit and adds attributes
 * to flying heros.
 *
 * @author Devin Fromond
 * @version 1.0
 * @since 2022-10-12
 */

public class FlyingHero extends SuperheroRecruit {

    //variable declaration
    private double altitude;

    /**
     * Used to get altitude.
     * @return altitude, which must be between 10 and 100
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Used to set altitude.
     * @param altitude which must be between 10 and 100
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * Constructor that takes in all variables
     * and ensures that altitude is in the correct
     * range.
     * @param name which must not be null
     * @param speed which must be positive
     * @param strength which must be positive
     * @param intelligence which must be positive
     * @param altitude which must be between 10 and 100
     */
    public FlyingHero(String name, int speed, double strength, int intelligence, double altitude) {
        super(name, speed, strength, intelligence);
        if (altitude > 100 || altitude < 10) {
            altitude = 50;
        }
        setAltitude(altitude);
    }

    /**
     * Constructor which only takes in name and speed
     * and sets altitude to 50.
     * @param name which must not be null
     * @param speed which must be positive
     */
    public FlyingHero(String name, int speed) {
        super(name, speed);
        setAltitude(50);
    }

    /**
     * Constructor which only takes in name and
     * sets speed to 20 and altitude to 50.
     * @param name is a String
     */
    public FlyingHero(String name) {
        super(name, 20);
        setAltitude(50);
    }

    /**
     * A deep copy constructor which copies all values
     * inside of flyinghero.
     * @param flyinghero is an object
     */
    public FlyingHero(FlyingHero flyinghero) {
        super(flyinghero);
        this.altitude = flyinghero.getAltitude();
    }

    /**
     * Used to return a Flying Hero's power scaling
     * which uses the powerScaling method from the
     * SuperheroRecruit class.
     * @return double which is the appropriate powerscaling given altitude
     */
    public double powerScaling() {
        return super.powerScaling() + getAltitude();
    }

    /**
     * Used to return a string that gives the details
     * regarding all characteristics of a certian
     * Flying Hero.
     * @return String which is the FlyingHero's characteristics
     */
    public String toString() {
        String toBeReturned = String.format("%s can fly %s feet in the air! ", getName(), getAltitude())
            + String.format("%s has %s IQ, runs at %s miles per hour,", getName(), getIntelligence(), getSpeed())
            + String.format(" and can lift %s pounds. ", getStrength())
            + String.format("The Power Scaling is %.2f.", powerScaling());
        return toBeReturned;
    }
}