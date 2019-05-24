package general;

import animation.Animation;

/**
 * The interface will handle adding a menu to the game.
 *
 * @param <T> - the return type expected from the menu.
 * @author David Regev.
 * @version 7.6.2018.
 */
public interface Menu<T> extends Animation {
    /**
     * The function adds an option-to-select to the menu.
     *
     * @param key - key to wait for.
     * @param message - line to print.
     * @param returnVal - what to return.
     */
    void addSelection(String key, String message, T returnVal);

    /**
     * The function returns the chosen option.
     *
     * @return - an option.
     */
    T getStatus();

}
