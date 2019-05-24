package sprites;

import listeners.HitListener;

/**
 * The interface notifies the hits of the ball to the blocs for,
 * either removing a block or start a new game when the user "dies".
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public interface HitNotifier {
    /**
     * The function adds a listener to hit events.
     *
     * @param hl - the listener to add.
     */
    void addHitListener(HitListener hl);

    /**
     * The function removes a listener from the listener hit list.
     *
     * @param hl - the listener to remove.
     */
    void removeHitListener(HitListener hl);
}
