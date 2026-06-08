/**
 * QuestNotFoundException represesents an exception that is thrown when
 * the quest being searched for is not found in the quest.csv.
 * @author Devin Fromond
 * @since 11/08/2022
 * @version 1.0.0
 */
public class QuestNotFoundException extends Exception {

    /**
     * Makes a super call to Exception.
     * @param exception which is the string of an error
     */
    public QuestNotFoundException(String exception) {
        super(exception);
    }

    /**
     * Defaults the error message and constructor chains.
     */
    public QuestNotFoundException() {
        this("Selected Quest Not Found");
    }
}
