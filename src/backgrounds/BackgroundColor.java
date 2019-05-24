package backgrounds;

import biuoop.DrawSurface;
import levels.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The class handles with the option that the background is a color.
 *
 * @version 9.6.2018.
 * @author David Regev.
 */
public class BackgroundColor implements Sprite {
    private Color color;

    /**
     * Constructor.
     *
     * @param color - the color.
     */
    public BackgroundColor(Color color) {
        this.color = color;
    }

    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
    }

    /**
     * The function adds a sprite to a game.
     *
     * @param g - the game to add the sprite to.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * The function removes a sprite from a game.
     *
     * @param g - the game to remove the sprite from.
     */
    @Override
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * The function notifies the sprites that time has passed.
     *
     * @param dt - speed balance.
     */
    @Override
    public void timePassed(double dt) {

    }
}