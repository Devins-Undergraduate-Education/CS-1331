/**
 * The Brawler program gives heros the ability to
 * use their catchphase and determines their power scaling
 * if a catchphrase is present.
 *
 * @author Devin Fromond
 * @version 1.0
 * @since 2022-10-12
 */

public class Brawler extends SuperheroRecruit {

    //variable declaration
    private Catchphrase catchphrase;

    /**
     * Takes in all variables and ensures default values using super().
     * The following defaults are assuming after the super call.
     * @param name which cannot be null
     * @param speed which must be positive
     * @param strength which must be positive
     * @param intelligence which must be positive
     * @param catchphrase which contains catchphrase and stat increase
     */
    public Brawler(String name, int speed, double strength, int intelligence, Catchphrase catchphrase) {
        super(name, speed, strength, intelligence);
        this.catchphrase = catchphrase;
    }

    /**
     * Takes in only two variables.
     * The following defaults are assuming after the super call.
     * @param name which must not be null
     * @param speed which must be positive
     */
    public Brawler(String name, int speed) {
        super(name, speed);
    }

    /**
     * Deep copy constructor.
     * @param brawler which consists of either a brawler with or without a catchphrase
     */
    public Brawler(Brawler brawler) {
        super((SuperheroRecruit) brawler);
        this.catchphrase = brawler.catchphrase;
    }

    /**
     * Method which determines the power scaling using SuperheroRecruit's
     * power scaling method.
     * @return double which is the power scaling if the brawler has a catchphrase
     */
    public double powerScaling() {
        if (catchphrase == null || catchphrase.getCatchphrase() == null) {
            return super.powerScaling();
        } else {
            return super.powerScaling() * (catchphrase.getStatIncrease() + 1);
        }
    }

    /**
     * Method which prints all attributes of the brawler or hero.
     */
    public void statChange() {
        if (catchphrase != null && catchphrase.getCatchphrase() != null) {
            System.out.println("Catchphrase: " + catchphrase.getCatchphrase());
            System.out.println("Origional Speed and Strength: " + getSpeed() + " and " + getStrength());
            System.out.println("Stat Increase: " + catchphrase.getStatIncrease() + "%");
            System.out.printf("Final Power Scaling %.2f", powerScaling());
        } else {
            System.out.println("null");
            System.out.println("Origional Speed and Strength: " + getSpeed() + " and " + getStrength());
            System.out.println("Stat Increase: 0%");
            System.out.printf("Final Power Scaling %.2f", super.powerScaling());
        }
    }
}