/**
 * Device is an abstract class that forms the basis for what a *device* should be.
 * Device can have, and should have, children classes.
 *
 * @author Devin Fromond
 * @version 1.0.0
 * @since 10/19/2022
 */

public abstract class Device {

    //variable declaration
    private final int serialNumber;
    protected final int cpuCapacity;
    protected int cpuRemaining;
    protected Task[] tasks;

    /**
     * The constructor initalizes all relevant variables.
     * @param serialNumber which is a private final int
     * @param cpuCapacity which is a protected final int
     * @param length which is used to create tasks, an array of Task objects
     */
    public Device(int serialNumber, int cpuCapacity, int length) {
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        tasks = new Task[length];
        cpuRemaining = cpuCapacity;
    }

    /**
     * The constructor intiializes all relevant variables and defaults cpuCapacity to 512 using constructor chaining.
     * @param serialNumber which is a private final int
     * @param length which is used to create tasks, an array of Task objects
     */
    public Device(int serialNumber, int length) {
        this(serialNumber, 512, length);
    }

    /**
     * Abstract method to be used in child classes.
     * @param taskObject which is a object of type Task
     * @return boolean depending on if the task can be added to tasks, an array of Task objects
     */
    public abstract boolean canAddTask(Task taskObject);

    /**
     * Abstract method to be used in child classes.
     * @param taskObject which is an object of type Task
     * @return boolean of if the task was added
     */
    public abstract boolean addTask(Task taskObject);

    /**
     * Method used to describe the task being processed.
     * @param taskObject which is an object of type Task
     * @return boolean of if the task was able to be processed
     */
    public boolean processTask(Task taskObject) {
        if (taskObject == null) {
            return false;
        } else {
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i] != null && taskObject.equals(tasks[i])) {
                    tasks[i] = null;
                    System.out.println("Processed: " + taskObject.toString());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method used compare two Device objects.
     * @param object which should be a Device object
     * @return boolean which describes if the two Device objects are equal
     * @override equals()
     */
    public boolean equals(Object object) {
        Device device = (Device) object;
        if (device.serialNumber == serialNumber
            && device.cpuCapacity == cpuCapacity && device.cpuRemaining == cpuRemaining) {
            return true;
        }
        return false;
    }

    /**
     * Method used to print all relevant data of a Device object.
     * @return String of all characteristics of the Device object
     * @override toString()
     */
    public String toString() {
        String temp = "Device with serial number " + serialNumber + " has ";
        return temp + cpuRemaining + " of " + cpuCapacity + " CPU remaining.";
    }
}