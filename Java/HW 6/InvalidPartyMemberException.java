/**
 * InvalidPartyMemberException represents an error that occurs when there is an
 * object not of type Mage or Warrior that is attempted to be passed in.
 * @author Devin Fromond
 * @since 11/08/2022
 * @version 1.0.0
 */
public class InvalidPartyMemberException extends RuntimeException {

    /**
     * Makes a super call to RuntimeException.
     * @param exception which is a string of the error
     */
    public InvalidPartyMemberException(String exception) {
        super(exception);
    }

    /**
     * Defaults the error message and constructor chains.
     */
    public InvalidPartyMemberException() {
        this("Invalid Party member!");
    }
}