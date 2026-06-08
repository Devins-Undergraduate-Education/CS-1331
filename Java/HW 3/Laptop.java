/**
 * Laptop is a child of Device and contains more relevant data specific to Laptop objects.
 *
 * @author Devin Fromond
 * @version 1.0.0
 * @since 10/19/2022
 */

public class Laptop extends Device {

    //variable declaration
    private boolean overclockable;

    /**
     * The constructor initializes all relevant information rearding Laptop objects.
     * @param serialNumber SEE DEVICE.JAVA
     * @param cpuCapacity SEE DEVICE.JAVA
     * @param length SEE DEVICE.JAVA
     * @param overclockable which is a private boolean if a laptop can have increased stats
     */
    public Laptop(int serialNumber, int cpuCapacity, int length, boolean overclockable) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = overclockable;
    }

    /**
     * The constructor initializes all relevant information regarding Laptop objects using constructor chaining.
     * Initializes overclockable to false as a default state.
     * @param serialNumber SEE DEVICE.JAVA
     * @param cpuCapacity SEE DEVICE.JAVA
     * @param length SEE DEVICE.JAVA
     */
    public Laptop(int serialNumber, int cpuCapacity, int length) {
        this(serialNumber, cpuCapacity, length, false);
    }

    /**
     * A method to determine how much space is required for a task to be added.
     * @param cpuRemaining which represents how much space left the laptop has
     * @return int representing the space needed for a task to be added
     */
    public int bufferSlotsRequired(int cpuRemaining) {
        if (tasks.length <= 4) {
            return 0;
        } else if (cpuRemaining < 128) {
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * The method checks if the task is able to be added given the CellPhone's information and the Task's information.
     * This method takes into account if the Laptop object can be overclocked.
     * @param object an object of type Task
     * @return boolean of whether or not the task is able to be added to the tasks array which contains Task objects
     */
    public boolean canAddTask(Task object) {
        int nullSlots = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                nullSlots++;
            }
        }
        if (nullSlots >= bufferSlotsRequired(cpuRemaining)) {
            if (cpuRemaining >= object.cpuCost) {
                return true;
            } else if (overclockable) {
                if (cpuRemaining + 0.25 * cpuCapacity >= object.cpuCost) {
                    cpuRemaining += 0.25 * cpuCapacity;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method used to add the Task object to the tasks array of type Task.
     * The method takes into account if the Laptop can be overclocked.
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
                    overclockable = false;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method used compare two Laptop objects.
     * @param object which should be a Laptop object
     * @return boolean which describes if the two Laptop objects are equal
     * @override equals()
     */
    public boolean equals(Object object) {
        Laptop lappitytop = (Laptop) object;
        if (super.equals(lappitytop) && lappitytop.overclockable == overclockable) {
            return true;
        }
        return false;
    }

    /**
     * Method used to print all relevant data of a Laptop object.
     * @return String of all characteristics of the Laptop object
     * @override toString()
     */
    public String toString() {
        if (overclockable) {
            return super.toString() + " This laptop does have overclocking.";
        } else {
            return super.toString() + " This laptop does not have overclocking.";
        }
    }
}