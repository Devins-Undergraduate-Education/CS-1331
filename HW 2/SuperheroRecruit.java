/**
 * The SuperheroRecruit prorgam is the outline
 * by which all superheros will be created under.
 * For a superhero to be a superhero, they must
 * first be recruited; hence, both flying heros and
 * brawlers are children of SuperheroRecruit.
 *
 * @author Devin Fromond
 * @version 1.0
 * @since 2022-10-12
 */

public class SuperheroRecruit {

    //variable declaration
    protected final String name;
    private int speed;
    private final double strength;
    private int intelligence;
    private static int totalRecruits = 10;


    /**
     * Used to get name, a private final String variable.
     * @return name which is a string
    */
    public String getName() {
        return name;
    }

    /**
     * Used to get speed, a private int variable.
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Used to set speed and defaults it if speed is invalid.
     * @param speed which must be positive
     */
    public void setSpeed(int speed) {
        if (speed < 0) {
            speed = 20;
        }
        this.speed = speed;
    }

    /**
     * Used to get strength, a private double variable.
     * @return strength
     */
    public double getStrength() {
        return strength;
    }

    /**
     * Used to get intelligence, a private int variable.
     * @return intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * used to set intelligence and defaults it if intelligence is invalid.
     * @param intelligence which must be positive
     */
    public void setIntelligence(int intelligence) {
        if (intelligence < 0) {
            intelligence = 100;
        }
        this.intelligence = intelligence;
    }

    /**
     * Used to get totalRecruits, a private final int variable.
     * @return totalRecruits
     */
    public int getTotalRecruits() {
        return totalRecruits;
    }

    /**
     * Used to set totalRecruits.
     * @param totalRecruits which must be final
     */
    public void setTotalRecruits(int totalRecruits) {
        this.totalRecruits = totalRecruits;
    }

    /**
     * Constructor that takes in all variables and
     * checks if name or speed are outside of the
     * allowed parameters.
     * @param name which must not be null
     * @param speed which must be positive
     * @param strength which must be positive
     * @param intelligence which must be positive
     */
    public SuperheroRecruit(String name, int speed, double strength, int intelligence) {
        if (name == null) {
            name = "Steve Rogers";
        }
        this.name = name;
        setSpeed(speed);
        if (strength < 0) {
            strength = 220;
        }
        this.strength = strength;
        setIntelligence(intelligence);
    }

    /**
     * constructor that takes in name, speed, and strength
     * and defaults intelligence to 100.
     * @param name which must not be null
     * @param speed which must be positive
     * @param strength which must be positive
     */
    public SuperheroRecruit(String name, int speed, double strength) {
        this(name, speed, strength, 100);
    }

    /**
     * constructor that takes in name and speed and defaults
     * strength and intelligence.
     * @param name which must not be null
     * @param speed which must be positive
     */
    public SuperheroRecruit(String name, int speed) {
        this(name, speed, 220.0, 100);
    }

    /**
     * constructor that copies superherorecruit.
     * @param superherorecruit which must be final
     */
    public SuperheroRecruit(SuperheroRecruit superherorecruit) {
        this.name = superherorecruit.getName();
        setSpeed(superherorecruit.getSpeed());
        this.strength = superherorecruit.getStrength();
        setIntelligence(superherorecruit.getIntelligence());
    }


    /**
     *
     * @return double that represents the powerscaling of the hero
     */
    public double powerScaling() {
        return ((speed + strength + intelligence) / 3);
    }

    /**
     * @return string that represents all information related to the Superhero
     */
    public String toString() {
        String toBeReturned = String.format("%s has %s IQ, ", getName(), getIntelligence())
            + String.format("runs at %s miles per hour,", getSpeed())
            + String.format(" and can lift %s pounds. ", getStrength())
            + String.format("The Power Scaling is %.2f.", powerScaling());
        return toBeReturned;
    }

    /**
     *
     * @param station which must be a string
     * @return string that provides information regarding the status of recruitment
     */
    public String recruit(String station) {
        if (totalRecruits != 0 && powerScaling() > 120) {
            setTotalRecruits(totalRecruits - 1);
            return toString() + " Recruit is enlisted to " + station + ".";
        } else if (totalRecruits <= 0) {
            return "Cannot recruit anyone, there are no slots left!";
        } else if (powerScaling() <= 120) {
            return "Rejected. Take a look at our sidekick program!";
        } else {
            return "An error has occured. See 'recruit' method.";
        }
    }
}