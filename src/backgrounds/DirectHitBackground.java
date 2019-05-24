package backgrounds;
import biuoop.DrawSurface;
import levels.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The class creates a background for the first level.
 *
 * @version 17.05.2018.
 * @author David Regev.
 */
public class DirectHitBackground implements Sprite {

    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 30, 800, 600);
        d.setColor(Color.blue);
        d.drawCircle(400, 210, 100);
        d.drawCircle(400, 210, 75);
        d.drawCircle(400, 210, 50);
        // draw lines
        d.drawLine(520, 210, 420, 210);
        d.drawLine(280, 210, 380, 210);
        d.drawLine(400, 90, 400, 190);
        d.drawLine(400, 330, 400, 230);
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