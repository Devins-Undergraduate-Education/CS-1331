/**
 * CellPhone is a child of Device and contains more relevant data specific to CellPhone objects.
 *
 * @author Devin Fromond
 * @version 1.0.0
 * @since 10/19/2022
 */

public class CellPhone extends Device {

    //variables
    private int tasksCompleted;

    /**
     * The constructor initializes all relevant information rearding CellPhone objects.
     * @param serialNumber SEE DEVICE.JAVA
     * @param cpuCapacity SEE DEVICE.JAVA
     * @param length SEE DEVICE.JAVA
     */
    public CellPhone(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
    }

    /**
     * The constructor initializes all relevant information regarding CellPhone objects using constructor chaining.
     * Initializes length to 10.
     * @param serialNumber SEE DEVICE.JAVA
     * @param cpuCapacity SEE DEVICE.JAVA
     */
    public CellPhone(int serialNumber, int cpuCapacity) {
        this(serialNumber, cpuCapacity, 10);
    }

    /**
     * The method checks if the task is able to be added given the CellPhone's information and the Task's information.
     * @param object an object of type Task
     * @return boolean of whether or not the task is able to be added to the tasks array which contains Task objects
     */
    public boolean canAddTask(Task object) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null && cpuRemaining > object.cpuCost) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method is used to describe if the task is able to be processed.
     * @param object an object of type Task
     * @return boolean of if the Task object is able to be processed
     */
    public boolean processTask(Task object) {
        if (super.processTask(object)) {
            tasksCompleted++;
            System.out.println(tasksCompleted + "PENIS");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method used to add the Task object to the tasks array of type Task.
     * @param object which is a object of type Task
     * @return boolean depending on if the task can be added to tasks, an array of Task objects
     */
    public boolean addTask(Task object) {
        if (canAddTask(object)) {
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i] == null) {
                    tasks[i] = object;
                    cpuRemaining -= object.cpuCost;
                    if (cpuRemaining < 0) {
                        cpuRemaining = 0;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method used compare two CellPhone objects.
     * @param object which should be a CellPhone object
     * @return boolean which describes if the two CellPhone objects are equal
     * @override equals()
     */
    public boolean equals(Object object) {
        CellPhone phone = (CellPhone) object;
        if (super.equals(phone)) {
            return true;
        }
        return false;
    }

    /**
     * Method used to print all relevant data of a CellPhone object.
     * @return String of all characteristics of the CellPhone object
     * @override toString()
     */
    public String toString() {
        return super.toString() + " It has completed " + tasksCompleted + " tasks.";
    }
}