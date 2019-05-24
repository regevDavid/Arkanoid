package animation;
import biuoop.DrawSurface;

/**
 * The interface creates animation gui and game logic.
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public interface Animation {
    /**
     * The method handles the gui and frame-management.
     * @param d - the surface to draw on.
     * @param dt - speed balance.
     */
    void doOneFrame(DrawSurface d, double dt);

    /**
     * The method creates the logic of the game.
     *
     * @return - true if the game should stop, false if not.
     */
    boolean shouldStop();
}
