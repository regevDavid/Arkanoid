package animation;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The class handles the opportunity that the player wants to pause.
 *
 * @version 15.05.2018.
 * @author David Regev.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * The method handles the gui and frame-management.
     *
     * @param d - the surface to draw on.
     * @param dt - speed balance.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        String msg = "Press space to continue";
        d.setColor(Color.BLACK);
        d.drawText(199, 500, msg, 32);
        d.setColor(Color.decode("#1788d0"));
        d.drawText(200, 501, msg, 32);
        d.setColor(Color.BLACK);
        d.drawText(202, 502, msg, 32);
    }
    /**
     * The method creates the logic of the game.
     *
     * @return - true if the game should stop, false if not.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
