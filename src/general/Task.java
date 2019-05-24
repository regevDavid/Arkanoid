package general;

/**
 * The interface tells the menu in advance what we would like
 * to happen when a selection is made.
 *
 * @param <T> - the return type expected from the task.
 */
public interface Task<T> {
    /**
     * The function runs the task.
     *
     * @return - a generic value.
     */
    T run();
}
