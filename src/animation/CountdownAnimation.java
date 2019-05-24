package animation;
import biuoop.DrawSurface;
import levels.LevelInformation;
import sprites.SpriteCollection;

import java.awt.Color;

/**
 * The class gives a 3 second break before starting a session of the game.
 *
 * @author David Regev.
 * @version 16.05.2018.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private int countTo;
    private SpriteCollection gameScreen;

    /**
     * constructor.
     *
     * @param numOfSeconds - amount of seconds to wait.
     * @param countFrom    - the starting of the countdown on the screen.
     * @param gameScreen   - the screen to show after the break.
     * @param level - the level associated to the countdown.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, LevelInformation level) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.countTo = countFrom;
        this.gameScreen = gameScreen;
    }

    /**
     * The method handles the gui and frame-management.
     *
     * @param d - the surface to draw on.
     * @param dt - speed balance.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        // Draw all the sprites.
        this.gameScreen.drawAllOn(d);
        //this.levelInformation.getBackground().drawOn(d);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        // Set the color of the count down.
        d.setColor(Color.blue);
        if (this.countTo == 0) {
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, "Go!", 60);
        } else {
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, String.valueOf(countTo), 60);
        }
        // Skip the first waiting.
        if (!(this.countTo == this.countFrom)) {
            sleeper.sleepFor((int) (1000 * numOfSeconds) / (countFrom + 1));
        }
        countTo--;
    }

    /**
     * The method creates the logic of the game.
     *
     * @return - true if the game should stop, false if not.
     */
    @Override
    public boolean shouldStop() {
        if (countTo < -1) {
            return true;
        }
        return false;
    }
}
