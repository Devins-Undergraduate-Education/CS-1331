public class Attraction implements Admittable, Comparable<Attraction> {

    private final String name;
    private long sumRatings = 0;
    private int numRatings = 0;
    private final double admissionFee;
    private Group[] visitors;

    public Attraction(String name, double admissionFee) {

        if (name == null || name.isEmpty()) {
            name = "No name";
        }
        if (admissionFee < 0) {
            admissionFee = 0;
        }

        this.name = name;
        this.admissionFee = admissionFee;
    }

    public Attraction(String name) {
        this(name, 5.25);
    }

    public Group[] resizeVisitors(Group[] visitor) {
        Group[] returnedGroup = new Group[visitor.length * 2];
        for (int i = 0; i < visitor.length; i++) {
            returnedGroup[i] = visitor[i];
        }
        return returnedGroup;
    }

    public void admit(String[] people) {
        visitors = new Group[5];
        int temp = people.length;
        for (int k = 0; k < people.length / 5; k++) {
            Group group;
            String[] test = new String[5];
            for (int i = 0; i < 5; i++) {
                test[i] = people[k * 5 + i];
            }
            group = new Group(test);
            visitors[k] = group;
            temp -= 5;
            if (temp >= 25) {
                visitors = resizeVisitors(visitors);
            }
        }
    }

    public void rateAndExit(int index, int rating) {
        if (visitors == null || index < 0 || index >= visitors.length || visitors[index] == null) {
            System.out.println("Could not update rating. Index invalid.");
        } else {
            visitors[index] = null;
            numRatings++;
            if (rating > 10) {
                rating = 10;
            } else if (rating < 1) {
                rating = 1;
            }
            sumRatings += rating;
            for (int i = index; i < visitors.length - 1; i++) {
                visitors[i] = visitors[i + 1];
            }
            visitors[visitors.length - 1] = null;
        }
    }

    public double averageRating() {
        if (numRatings == 0) {
            return 0;
        }
        return Math.round(sumRatings / numRatings * 100.00) / 100.00;
    }

    public void printVisitors() {
        if (visitors != null) {
            int counter = 1;
            System.out.println(toString());
            for (int i = 0; i < visitors.length; i++) {
                if (visitors[i] == null) {
                    break;
                }
                System.out.print("Group " + counter + ": ");
                System.out.println(visitors[i].toString());
                counter++;
            }
        }
    }

    @Override
    public String toString() {
        return name + "/" + averageRating() + "/" + admissionFee;
    }

    public int compareTo(Attraction attraction) {
        if (attraction == null) {
            return -1;
        } else if (this.averageRating() != attraction.averageRating()) {
            if (this.averageRating() > attraction.averageRating()) {
                return -1;
            } else {
                return 1;
            }
        } else if (attraction.admissionFee == this.admissionFee) {
            return 0;
        } else if (this.admissionFee > attraction.admissionFee) {
            return 1;
        }
        return -1;
    }
}