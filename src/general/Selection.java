package general;

/**
 * The class handles with a specific selection.
 *
 * @param <T> - return type of the class.
 */
public class Selection<T> {
    private String key;
    private String message;
    private T returnVal;

    /**
     * Constructor.
     *
     * @param key - key to wait for.
     * @param message - line to print.
     * @param returnVal - what to return.
     */
    public Selection(String key, String message, T returnVal) {
        this.key = key;
        this.message = message;
        this.returnVal = returnVal;
    }

    /**
     * getter.
     *
     * @return - the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * getter.
     *
     * @return - the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * getter.
     *
     * @return - the value.
     */
    public T getReturnVal() {
        return returnVal;
    }
}