//import statements
import java.util.Scanner;
import java.util.Random;

public class PokemonBattle {
    public static void main (String[] args) {

        //Declarations and initializations
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        String rivalPokemon, FriendlyPokemon; 
        double rivalPokemonHealth = 20.00*random.nextDouble() + 40.00;
        //Truncates to two decimals
        rivalPokemonHealth = Math.round(rivalPokemonHealth * 100.00) / 100.00;
        double damage = 0;
        double prizeMoney = 0;
        int attackNumber = 0;
        
        //Takes as input Pokemon name and trims whitespace
        System.out.print("Enter your Pokemon's nickname: ");
        FriendlyPokemon = scan.nextLine();
        FriendlyPokemon = FriendlyPokemon.trim();
        System.out.print("Enter your rival Pokemon's nickname: ");
        rivalPokemon = scan.nextLine();
        rivalPokemon = rivalPokemon.trim();

        //Complete print statement
        System.out.printf("Your rival has chosen %s to fight, which has %.2f health.%n", rivalPokemon, rivalPokemonHealth);

        do {
            //Obtains an attack move from AttackType.java and casts it to a string to allow for .equals() boolean checking
            String attack = (AttackType.values()[random.nextInt(3)]).toString();
            attackNumber++;

            //Completes the moveset SCRATCH and ensures two decimal place rounding
            if (attack.equals("SCRATCH")) {
                damage = ((random.nextInt(3) + 1) * (5.00*random.nextDouble() + 1));
                damage = Math.round(damage * 100.00) / 100.00;
                rivalPokemonHealth = rivalPokemonHealth - damage;
                rivalPokemonHealth = Math.round(rivalPokemonHealth * 100.00) / 100.00;
            }
            
            //Completes the moveset SURF and ensures two decimal place rounding
            else if (attack.equals("SURF")) {
                damage = (9.00*random.nextDouble() + 2);
                damage = Math.round(damage * 100.00) / 100.00;
                rivalPokemonHealth = rivalPokemonHealth - damage; 
                rivalPokemonHealth = Math.round(rivalPokemonHealth * 100.00) / 100.00;

            }

            //Completes the moveset TACKLE and ensures two decimal place rounding
            else if (attack.equals("TACKLE")) {
                damage = (2.00*random.nextDouble() + 7);
                damage = Math.round(damage * 100.00) / 100.00;
                rivalPokemonHealth = rivalPokemonHealth - damage;
                rivalPokemonHealth = Math.round(rivalPokemonHealth * 100.00) / 100.00;

            }

            //Complete print statement using Math.max() to ensure health is not printed as negative
            System.out.printf("%s used %s and did %.2f damage. Your rival has %.2f health remaining.%n", FriendlyPokemon, attack, damage, Math.max(rivalPokemonHealth, 0.00));
        } while(rivalPokemonHealth >= 0); //Ensures moves are only completed when Pokemon are alive
        
        //Complete print statements and issue prize money
        System.out.println(rivalPokemon + " fainted after " + attackNumber + " turns!");
        prizeMoney = 1200.00*random.nextDouble() * -1 + 2400.00;
        prizeMoney = Math.round(prizeMoney * 100.00) / 100.00;
        System.out.printf("You have earned $%.2f!", prizeMoney);
    }
}
