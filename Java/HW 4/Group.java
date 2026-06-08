public class Group {

    private final String[] people;

    public Group(String[] people) {
        this.people = people;
        if (people == null) {
            people = new String[0];
        } else {
            for (int i = 0; i < people.length; i++) {
                this.people[i] = people[i];
            }
        }
    }

    public int size() {
        return people.length;
    }

    public String toString() {
        String toBeReturned = "";
        for (int i = 0; i < people.length; i++) {
            if (i != people.length - 1) {
                toBeReturned = toBeReturned + people[i] + "/";
            } else {
                toBeReturned = toBeReturned + people[i];
            }
        }
        return toBeReturned;
    }
}
