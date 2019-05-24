package backgrounds;

import biuoop.DrawSurface;
import levels.GameLevel;
import sprites.Sprite;

import java.awt.image.BufferedImage;

/**
 * The class handles with the option that the background is an image.
 *
 * @version 9.6.2018.
 * @author David Regev.
 */
public class BackgroundImage implements Sprite {
    private BufferedImage image;

    /**
     * Constructor.
     *
     * @param image - the image to the background.
     */
    public BackgroundImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawImage(0, 17, this.image);
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