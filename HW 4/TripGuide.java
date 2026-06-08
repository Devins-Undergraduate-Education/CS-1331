public class TripGuide {
    public static void main(String[] args) {

        Attraction att1 = new Attraction("att1", 1.1);
        Attraction att2 = new Attraction("att2", 1.2);

        Museum mus1 = new Museum("mus1", 1.3, 100);
        Museum mus2 = new Museum("mus2", 1.4, 5);

        Attraction att3 = new Attraction("att2", 1.5);
        Museum mus3 = new Museum("mus2", 1.6, 5);

        String[] people1 = new String[]{"a", "b", "c", "d"};
        String[] people2 = new String[]{"a", "b", "c", "d", "e"};
        String[] people3 = new String[]{"a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a", "b"};
        String[] people4 = new String[]{"a", "b", "c", "d", "e", "a", "b", "c",
            "d", "e", "a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a", "b", "c", "d", "e"};

        att1.admit(people1);
        att1.admit(people2);
        att1.admit(people3);
        att1.printVisitors();
        att1.admit(people4);
        att1.printVisitors();

        att2.admit(people1);
        att2.printVisitors();
        att2.admit(people2);
        att2.admit(people3);
        att2.printVisitors();
        att2.admit(people4);

        att3.printVisitors();
        att3.admit(people1);
        att3.printVisitors();
        att3.admit(people2);
        att3.admit(people3);
        att3.admit(people4);

        att1.rateAndExit(0, 4);
        att2.rateAndExit(0, 4);

        att3.rateAndExit(2, 3);
        att1.rateAndExit(2, 1);

        mus1.rateAndExit(0, 0);
        mus2.rateAndExit(0, 0);

        mus1.compareTo(mus3);

        att1.toString();
        att1.printVisitors();
        att2.toString();
        att2.printVisitors();
        att3.toString();
        att3.printVisitors();
        mus1.toString();
        mus1.printVisitors();
        mus2.toString();
        mus2.printVisitors();
    }
}