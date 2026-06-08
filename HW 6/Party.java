import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Party contains the main method as well as other methods that form the
 * playing of the game.
 * @author Devin Fromond
 * @since 11/08/2022
 * @version 1.0.0
 */
public class Party {

    /**
     * Processes a file and creates objects depending on which class the object is.
     * @param fileName which is the name of a file
     * @return ArrayList which represents PartyMember objects read from the file
     * @throws FileNotFoundException which may occur if the fileName input is not found
     */
    public static ArrayList<PartyMember> recruitParty(String fileName) throws FileNotFoundException {
        ArrayList<PartyMember> list = new ArrayList<PartyMember>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            list.add(processInfo(scanner.nextLine()));
        }
        scanner.close();
        return list;
    }

    /**
     * Processes a String into an object depending on information in the String.
     * @param info which is a string from a file
     * @return PartyMember which can be a Mage or a Warrior
     */
    private static PartyMember processInfo(String info) {
        String[] arrOfInfo = info.split(", |\\: ");
        PartyMember toBeReturned;
        if (arrOfInfo[1].compareTo("Warrior") == 0) {
            toBeReturned = new Warrior(arrOfInfo[3], Integer.parseInt(arrOfInfo[5]),
                Integer.parseInt(arrOfInfo[7]), arrOfInfo[9], Integer.parseInt(arrOfInfo[11]));
            return (Warrior) toBeReturned;
        } else if (arrOfInfo[1].compareTo("Mage") == 0) {
            toBeReturned = new Mage(arrOfInfo[3], Integer.parseInt(arrOfInfo[5]),
                Integer.parseInt(arrOfInfo[7]), Integer.parseInt(arrOfInfo[9]), Integer.parseInt(arrOfInfo[11]));
            return (Mage) toBeReturned;
        }
        throw new InvalidPartyMemberException();
    }

    /**
     * Writes characteristics of an object to a file.
     * @param fileName which is the name of a file
     * @param list which is an ArrayList with the objects in it
     * @return boolean which represents whether the objects were written to the file or not
     */
    public static boolean partyRoster(String fileName, ArrayList<PartyMember> list) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Warrior) {
                    Warrior warrior = (Warrior) list.get(i);
                    writer.println(warrior.toString());
                } else if (list.get(i) instanceof Mage) {
                    Mage mage = (Mage) list.get(i);
                    writer.println(mage.toString());
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Yeah, so... the ArrayList is empty.");
            return false;
        } catch (IOException e) {
            System.out.println("Umm... this file doesn't exist.");
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Process a group and detemrines if they are able to complete a quest.
     * Removes quest from the file if the group is able to complete the quest.
     * @param quest which is a quest's name
     * @param party which is an arraylist of the members of the party
     * @return boolean which represents if the group was able to complete the quest
     * @throws FileNotFoundException which is thrown if the file is not found
     * @throws QuestNotFoundException which is thrown if the quest is not found
     */
    public static boolean getQuest(String quest, ArrayList<PartyMember> party)
        throws FileNotFoundException, QuestNotFoundException {
        File file = new File("quest.csv");
        PrintWriter writer = null;
        Scanner scanner = new Scanner(file);
        ArrayList<String> questElements = new ArrayList<String>();
        boolean notFound = true;
        int iteration = 0;
        String[] questElementsSearched = new String[3];
        while (scanner.hasNextLine()) {
            questElementsSearched = scanner.nextLine().split(", |\\: ");
            for (int i = 0; i < 3; i++) {
                questElements.add(questElementsSearched[i]);
                if (questElementsSearched[0].compareTo(quest) == 0) {
                    notFound = false;
                } else if (notFound) {
                    iteration++;
                }
            }

        }
        scanner.close();
        if (notFound) {
            throw new QuestNotFoundException("Quest not found!");
        } else if (Integer.parseInt(questElements.get(iteration + 1)) > partyQuestLevel(party)) {
            System.out.println("Failure... Your party was defeated. Better Luck Next Time!");
            return false;
        } else if (Integer.parseInt(questElements.get(iteration + 1)) <= partyQuestLevel(party)) {
            System.out.println("Success! Your party gained "
                + questElements.get(iteration + 2) + " coins. This calls for a trip to the Tavern!");
            writer = new PrintWriter("quest.csv");
            for (int i = 0; i < 3; i++) {
                questElements.remove(iteration);
            }
            for (int i = 0; i < questElements.size() / 3; i++) {
                writer.println(questElements.get(i * 3 + 0) + ": " + questElements.get(i * 3 + 1) + ", "
                    + questElements.get(i * 3 + 2));
            }
            writer.close();
            return true;
        }
        return false;
    }

    /**
     * Determines the level of the party that is attempting the quest.
     * @param list which is a party that has members in it
     * @return int which is the level of the party
     */
    private static int partyQuestLevel(ArrayList<PartyMember> list) {
        int totalQuestLevel = 0;
        if (list.isEmpty() || list == null) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                totalQuestLevel += list.get(i).questLevel();
            }
        }
        return totalQuestLevel;
    }

    /**
     * Run the method. Do stuff. Go crazy. YEAH PROGRAMMING!
     * @param ags whcih is essential to run a program
     */
    public static void main(String[] ags) {
        try {
            Mage mage1 = new Mage("Henry", 10, 10, 11, 1);
            Mage mage2 = new Mage("Jerry", 15, 15, 16, 1);
            Mage mage3 = new Mage("Milly", 20, 20, 21, 2);
            Warrior warrior1 = new Warrior("Eleven", 10, 10, "Long Sword", 2);
            Warrior warrior2 = new Warrior("Devin", 15, 15, "Medium Sword", 4);
            Warrior warrior3 = new Warrior("Kevin", 20, 20, "Short Sword", 6);

            ArrayList<PartyMember> list = new ArrayList<PartyMember>();
            list.add(mage1);
            list.add(warrior1);
            list.add(warrior2);
            list.add(mage2);
            list.add(warrior3);
            list.add(mage3);

            partyRoster("TestParty.csv", list);

            Warrior warrior4 = new Warrior("New", 40, 40, "Bomb", 1);

            list.add(warrior4);

            partyRoster("TestParty.csv", list);

            recruitParty("TestParty.csv");

            //getQuest("End Game", list);
            getQuest("Easy W", list);
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (QuestNotFoundException e) {
            System.out.println("Selected Quest Not Found");
        }
    }
}