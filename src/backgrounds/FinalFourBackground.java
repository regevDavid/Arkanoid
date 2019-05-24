package backgrounds;
import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import levels.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The class creates a background for the final level.
 *
 * @author David Regev.
 * @version 17.05.2018.
 */
public class FinalFourBackground implements Sprite {

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
        // inner rectangle.
        d.setColor(Color.cyan);
        d.fillRectangle(20, 70, 750, 600);
        // draw the building.
        d.setColor(Color.pink);
        d.fillRectangle(270, 420, 110, 190);
        // first floor windows.
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 5; i++) {
                d.setColor(Color.white);
                d.fillRectangle(280 + i * 20, 590 - j * 15, 10, 10);
            }
        }
        // draw grass in front of the building.
        // second cluster.
        Line l;
        for (int i = 0; i < 100; i++) {
            l = new Line(new Point(390 + i * 10, 595), new Point(380 + i * 10, 600));
            l.drawLine(l, d, Color.green.darker());
        }
        for (int i = 0; i < 100; i++) {
            l = new Line(new Point(390 + i * 10, 595), new Point(395 + i * 10, 600));
            l.drawLine(l, d, Color.green.darker());
        }
        // draw the bulb of the clouds.
        // first cluster.
        d.setColor(Color.lightGray);
        d.fillCircle(140, 330, 40);
        d.setColor(Color.lightGray);
        d.fillCircle(170, 310, 35);
        d.setColor(Color.gray.brighter());
        d.fillCircle(200, 350, 30);
        d.setColor(Color.gray.brighter());
        d.fillCircle(220, 360, 40);
        d.setColor(Color.gray.brighter());
        d.fillCircle(210, 320, 25);
        // second cluster.
        d.setColor(Color.lightGray);
        d.fillCircle(540, 430, 40);
        d.setColor(Color.lightGray);
        d.fillCircle(570, 410, 35);
        d.setColor(Color.gray.brighter());
        d.fillCircle(600, 450, 30);
        d.setColor(Color.gray.brighter());
        d.fillCircle(620, 460, 40);
        d.setColor(Color.gray.brighter());
        d.fillCircle(610, 420, 25);
        // draw the rain.
        // first cluster.
        for (int i = 0; i < 10; i++) {
            l = new Line(new Point(150 + i * 8, 330), new Point(110 + i * 10, 600));
            l.drawLine(l, d, Color.gray);
        }
        // second cluster.
        for (int i = 0; i < 10; i++) {
            l = new Line(new Point(550 + i * 8, 430), new Point(510 + i * 10, 600));
            l.drawLine(l, d, Color.gray);
        }
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
