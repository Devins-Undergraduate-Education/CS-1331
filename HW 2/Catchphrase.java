/**
 * The Catchphrase program gives heros the ability to
 * have two attributes: a catchphrase and an associated
 * stat increase due to the catchphrase.
 *
 * @author Devin Fromond
 * @version 1.0
 * @since 2022-10-12
 */

public class Catchphrase {

    //variable declaration
    private final String catchphrase;
    private final double statIncrease;

    /**
     * Used to get statIncrease, a private final double variable.
     * @return statIncrease - the percantage a hero's stats are increased by
     */
    public double getStatIncrease() {
        return statIncrease;
    }

    /**
     * Used to get catchphrase, a private final String variable.
     * @return catchphrase - the hero's famous line
     */
    public String getCatchphrase() {
        return catchphrase;
    }

    /**
     * A constructor which takes in all Catchphrase variables.
     * @param catchphrase which can be null
     * @param statIncrease which must be between 0 and 20
     */
    public Catchphrase(String catchphrase, double statIncrease) {
        if (statIncrease >= 0 || statIncrease > 20) {
            statIncrease = 15.0;
        }
        this.catchphrase = catchphrase;
        this.statIncrease = statIncrease;
    }

    /**
     * A constructor which takes in no arguments and
     * assigns catchphrase and statIncrease.
     */
    public Catchphrase() {
        this("I can do this all day", 15.0);
    }

    /**
     * A method to print out the variables of the Catchphrase class
     * in the context of the hero or brawler.
     * @return String which represents the catchphrase and the percentage the stats were increased by
     */
    public String toString() {
        return catchphrase + "! Stats are increased by " + statIncrease + "%.";
    }
}