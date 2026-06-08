/**
 * The Driver class is used to test the code.
 *
 * @author Devin Fromond
 * @version 1.0.0
 * @since 10/19/2022
 */

public class Driver {

    /**
     * The Main method of Java which will ultimately run.
     * @param args a string essential to Java
     */
    public static void main(String[] args) {

        // tasks objects
        Task task1 = new Task(null, 1);
        Task task2 = new Task("BINGO", 120);
        Task task3 = new Task("GEN_TASK", 8);

        System.out.println("----TASK CHECKS----");
        System.out.println(task1.equals(task2) + " --------------- false?");
        System.out.println(task1.equals(task3) + " --------------- true?");

        //cellphone objects
        CellPhone iPhone1 = new CellPhone(8675309, 64, 10);
        CellPhone iPhone2 = new CellPhone(8675309, 64);
        CellPhone iPhone3 = new CellPhone(1738, 64);

        System.out.println("----CELLPHONE CHECKS----");
        System.out.println(iPhone1.equals(iPhone2));
        System.out.println(iPhone1.toString());
        System.out.println(iPhone1.canAddTask(task3));
        System.out.println(iPhone1.toString());
        System.out.println(iPhone1.processTask(task3));
        System.out.println(iPhone1.toString());
        System.out.println(iPhone1.addTask(task3));
        System.out.println(iPhone1.toString());
        System.out.println(iPhone1.processTask(task3));
        System.out.println(iPhone3.toString());
        System.out.println(iPhone1.equals(iPhone2));

        //laptop objects
        Laptop dell1 = new Laptop(101, 100, 10, true);
        Laptop dell2 = new Laptop(101, 128, 8, false);

        System.out.println("----LAPTOP CHECKS---");
        System.out.println(dell1.toString());
        System.out.println(dell1.bufferSlotsRequired(100));
        System.out.println(dell1.canAddTask(task2));
        System.out.println(dell1.addTask(task2));
        System.out.println(dell1.toString());
        System.out.println(dell1.equals(dell2));
    }
}
