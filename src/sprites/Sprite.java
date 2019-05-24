package sprites;
import biuoop.DrawSurface;
import levels.GameLevel;

/**
 * The interface organizes all the sprites in the game.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public interface Sprite {
    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    void drawOn(DrawSurface d);

    /**
     * The function adds a sprite to a game.
     *
     * @param g - the game to add the sprite to.
     */
    void addToGame(GameLevel g);

    /**
     * The function removes a sprite from a game.
     *
     * @param g - the game to remove the sprite from.
     */
    void removeFromGame(GameLevel g);

    /**
     * The function notifies the sprites that time has passed.
     *
     * @param dt - speed balance.
     */
    void timePassed(double dt);
}
