package backgrounds;
import biuoop.DrawSurface;
import levels.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The class creates a background for the third level.
 *
 * @author David Regev.
 * @version 17.05.2018.
 */
public class Green3Background implements Sprite {

    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        // draw the rectangles.
        d.setColor(Color.gray);
        d.fillRectangle(0, 30, 800, 600);
        d.setColor(Color.green.darker().darker());
        d.fillRectangle(30, 50, 740, 600);
        // draw the building.
        d.setColor(Color.black);
        d.fillRectangle(70, 420, 110, 190);
        // first part of the antena.
        d.fillRectangle(90, 320, 70, 290);
        // second part of the antena.
        d.fillRectangle(115, 220, 20, 390);
        // first floor windows.
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 5; i++) {
                d.setColor(Color.white);
                d.fillRectangle(80 + i * 20, 590 - j * 15, 10, 10);
            }
        }
        // draw the bulb on the antena.
        d.setColor(Color.orange.darker());
        d.fillCircle(125, 195, 25);
        d.setColor(Color.orange.darker());
        d.fillCircle(125, 195, 20);
        d.setColor(Color.yellow);
        d.fillCircle(125, 195, 15);
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