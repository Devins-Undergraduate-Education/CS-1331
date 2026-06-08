import java.util.Scanner;

public class Schedule {
    public static String[] generateSchedule(String[] subjectList, int numClasses) {

        //Creates local 'schedule' variable
        String[] schedule = new String[numClasses];

        for (int i = 0; i < schedule.length; i++) {

            if (i % 2 == 0) {
                schedule[i] = subjectList[(int) (Math.random() * 4)];
            }

            if (i % 2 != 0) {
                schedule[i] = subjectList[(int) (Math.random() * 3 + 4)];
            }
        }

        return schedule;
    }

    public static int[] computeDifficulties(String[] schedule, String[] subjectList) {

        int[] test = new int[schedule.length];

        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < subjectList.length; j++) {
                if (schedule[i].equals(subjectList[j])) {
                    test[i] = i + j;
                }
            }
        }

        return test;
    }

    public static void compareDifficulties(String[] schedule1, String[] schedule2, String[] subjectList) {
        int difficulty1 = 0;
        int difficulty2 = 0;

        int[] test1 = computeDifficulties(schedule1, subjectList);
        int[] test2 = computeDifficulties(schedule2, subjectList);


        for (int i = 0; i < test1.length; i++) {
            difficulty1 = test1[i];
        }

        for (int i = 0; i < test2.length; i++) {
            difficulty2 = test2[i];
        }

        if (difficulty1 > difficulty2) {
            System.out.println("The first schedule is harder than the second schedule.");
        } else if (difficulty1 < difficulty2) {
            System.out.println("The second schedule is harder than the first schedule.");
        } else {
            System.out.println("The two schedules are equally difficult.");
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of classes: ");
        int numClasses = Integer.parseInt(scan.nextLine());

        System.out.print("Enter this schedule's owner's name: ");
        String owner = scan.nextLine();

        owner = owner.trim();

        String[] subjectList = {"English", "History", "Math", "CS", "Science", "Engineering", "Lab"};

        String[] schedule1 = generateSchedule(subjectList, numClasses);
        String[] schedule2 = generateSchedule(subjectList, numClasses);

        System.out.println("Schedules created successfully. Here are the details:");
        System.out.println("Owner: " + owner + "\nNumber of Classes: " + numClasses);

        int[] test11 = computeDifficulties(schedule1, subjectList);
        int[] test22 = computeDifficulties(schedule2, subjectList);

        System.out.println("\nSchedule 1:");
        for (int i = 0; i < schedule1.length; i++) {
            System.out.println(schedule1[i] + " " + test11[i]);
        }

        System.out.println("\nSchedule 2:");
        for (int i = 0; i < schedule2.length; i++) {
            System.out.println(schedule2[i] + " " + test22[i]);
        }

        compareDifficulties(schedule1, schedule2, subjectList);
    }
}