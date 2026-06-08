/**
 * Task is a class that has constructors neccessary for the operation
 * of the subsequent classes in this homework as each device and child
 * of device is able to use a reference Task and tasks.
 *
 * @author Devin Fromond
 * @version 1.0.0
 * @since 10/19/2022
 */

public final class Task {

    //variables
    public final String name;
    public final int cpuCost;

    /**
     * The constructor checks for invalid inputs and corrects them.
     * @param name which is public and final and cannot be null
     * @param cpuCost which is public and final and cannot be less than 8
     */
    public Task(String name, int cpuCost) {

        if (name == null) {
            name = "GEN_TASK";
        }
        this.name = name;

        if (cpuCost < 8) {
            cpuCost = 8;
        }
        this.cpuCost = cpuCost;
    }

    /**
     * The method takes in an object and sees if the variables related to
     * the object are equal to the object's variables it is being compared
     * to.
     * @param object which is a general object
     * @return boolean depending on if the two objects are equal
     * @override equals()
     */
    public boolean equals(Object object) {
        Task task = (Task) object;
        if (task.name == name && task.cpuCost == cpuCost) {
            return true;
        }
        return false;
    }

    /**
     * The method prints all relevant data of the task.
     * The method takes in no arguements.
     * @return String of the characteristics of the Task object
     * @override toString()
     */
    public String toString() {
        return name + " has CPU cost of " + cpuCost;
    }
}