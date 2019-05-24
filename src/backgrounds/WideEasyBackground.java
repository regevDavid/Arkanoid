package backgrounds;

import biuoop.DrawSurface;
import levels.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The class creates a background for the second level.
 *
 * @author David Regev.
 * @version 17.05.2018.
 */
public class WideEasyBackground implements Sprite {

    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#7EBBCA"));
        d.fillRectangle(0, 23, d.getWidth(), d.getHeight());

        d.setColor(Color.decode("#efe7b0"));
        d.fillCircle(150, 150, 60);

        int numRays = 100;
        int startX = 25;
        int endX = 800;

        for (int i = 1; i <= numRays; i++) {
            d.drawLine(150, 150, (endX - startX) / numRays * i, 250);
        }

        d.setColor(Color.decode("#ecd749"));
        d.fillCircle(150, 150, 50);

        d.setColor(Color.decode("#ffe118"));
        d.fillCircle(150, 150, 40);
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
