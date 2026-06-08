import java.util.ArrayList;

/**
 * Which combines all of the classes and serves as the main method.
 * @author Devin Fromond
 * @version 1.0.0
 * @since 11/2/2022
 */
public class PoliceStation {

    private String name;
    private ArrayList<Suspect> suspects;
    private ArrayList<Accomplice> accomplices;

    /**
     * This constructor constructs a police station under which the classes will fall under.
     * @param name which is the name of the suspect
     */
    public PoliceStation(String name) {
        this.name = name;
        suspects = new ArrayList<Suspect>();
        accomplices = new ArrayList<Accomplice>();
    }

    /**
     * Adds the POI to the corresponding arrayList.
     * @param poi which is of type Suspect or Accomplice
     */
    public void addPersonOfInterest(PersonOfInterest poi) {
        if (poi instanceof Suspect) {
            suspects.add((Suspect) poi);
        } else if (poi instanceof Accomplice) {
            accomplices.add((Accomplice) poi);
        }
    }

    /**
     * Sorts the suspects or accomplices index based off of the characteristics.
     */
    public void sortSuspects() {
        int minIndex;
        Suspect temp;
        for (int i = 0; i < suspects.size(); i++) {
            minIndex = i;
            for (int j = i + 1; j < suspects.size(); j++) {
                if (suspects.get(j).compareTo(suspects.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            temp = suspects.get(i);
            suspects.set(i, suspects.get(minIndex));
            suspects.set(minIndex, temp);
        }
    }

    /**
     * Removes the duplicates in the suspects array.
     * @return ArrayList which is the arraylist which contains the duplicates.
     */
    public ArrayList removeDuplicates() {
        ArrayList<Suspect> dupeSuspects = new ArrayList<Suspect>();
        sortSuspects();
        Suspect temp;
        for (int i = 0; i < suspects.size() - 1; i++) {
            if (suspects.get(i).compareTo(suspects.get(i + 1)) == 0) {
                temp = suspects.get(i);
                suspects.remove(i + 1);
                if (dupeSuspects.size() == 0) {
                    dupeSuspects.add(suspects.get(i));
                } else if (temp.compareTo(dupeSuspects.get(dupeSuspects.size() - 1)) != 0) {
                    dupeSuspects.add(suspects.get(i));
                }
                i--;
            }
        }
        return dupeSuspects;
    }

    /**
     * Cycles through the suspects array and searches for a match.
     * @param suspect which is of type Suspect
     * @return Suspect which, if found, returns the suspect found
     */
    public Suspect findSuspect(Suspect suspect) {
        removeDuplicates();
        int left = 0;
        int right = suspects.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (suspect.compareTo(suspects.get(mid)) == 0) {
                return suspects.get(mid);
            }
            if (suspect.compareTo(suspects.get(mid)) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    /**
     * Finds the mastermind which is a suspect with an accomplice.
     * @param suspect which is of type Suspect
     * @return Accomplice which is the mastermind of the stolen ducks
     */
    public Accomplice findMastermind(Suspect suspect) {
        for (int i = 0; i < accomplices.size(); i++) {
            if (accomplices.get(i).getCanCode() && accomplices.get(i).getRubberDuck().equals(suspect.getRubberDuck())) {
                return accomplices.get(i);
            }
        }
        return null;
    }

    /**
     * Runs the methods and tests the methods.
     * @param args which runs the file
     */
    public static void main(String[] args) {
        Suspect suspect1 = new Suspect(Color.BROWN, 3, null, 0);
        Suspect suspect2 = new Suspect(Color.DARKGRAY, 3, null, 0);
        Suspect suspect3 = new Suspect(Color.MAGENTA, 3, null, 0);
        PoliceStation ps1 = new PoliceStation("NAME");
        ps1.addPersonOfInterest(suspect3);
        ps1.addPersonOfInterest(suspect1);
        ps1.addPersonOfInterest(suspect2);
        System.out.println(suspect1.compareTo(suspect2));
        System.out.println(suspect1.compareTo(suspect3));
        System.out.println(suspect3.compareTo(suspect2));
        for (int i = 0; i < ps1.suspects.size(); i++) {
            System.out.println(ps1.suspects.get(i));
        }
        ps1.sortSuspects();
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < ps1.suspects.size(); i++) {
            System.out.println(ps1.suspects.get(i));
        }
    }
}