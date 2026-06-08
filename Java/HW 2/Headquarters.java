/**
 * The Headquarters program runs all appliciable methods and
 * constructors found in the four other programs.
 *
 * @author Devin Fromond
 * @version 1.0
 * @since 2022-10-12
 */

public class Headquarters {

    /**
     * The lines below construct, initialize, and run various methods
     * and constructors from other classes as well as prints them out.
     * @param args String of whatever this does. I do not think this is needed or correct.
     */
    public static void main(String[] args) {

        SuperheroRecruit batman = new SuperheroRecruit("Batman", 100, 200, 300);
        SuperheroRecruit flash = new SuperheroRecruit("Flash", 300);

        FlyingHero superman = new FlyingHero("Superman", 400, 800, 50, 900);
        FlyingHero wonderwoman = new FlyingHero("wonderwoman");

        Brawler brawler1 = new Brawler(null, 0);
        Brawler brawler2 = new Brawler("robin", 40);
        Brawler brawler3 = new Brawler(null, 0, 0, 0, null);

        Catchphrase phrase1 = new Catchphrase(null, 17);

        System.out.println("--SUPERHERO RECRUIT OBJECTS--");
        System.out.println(batman.powerScaling());
        System.out.println(superman.powerScaling());
        System.out.println(brawler3.powerScaling());
        System.out.println("");

        System.out.println("--FLYING HERO OBJECTS--");
        System.out.println(flash.toString());
        System.out.println(wonderwoman.toString());
        System.out.println(brawler3.toString());
        System.out.println("");

        System.out.println("--CATCHPHRASE OBJECTS--");
        System.out.println(phrase1.toString());
        System.out.println("");

        System.out.println("--BRAWLER OBJECTS--");
        brawler1.statChange();
        brawler2.statChange();
        System.out.println("");

        System.out.println("\n--DEEP COPY TEST--");
        System.out.println("//SUPERHERO RECRUIT//");
        SuperheroRecruit soupCopy = new SuperheroRecruit(batman);
        System.out.println(soupCopy.toString());
        System.out.println("");
        System.out.println("//BRAWLER//");
        Brawler brawlCopy = new Brawler(brawler3);
        brawlCopy.statChange();
        System.out.println("");
    }
}