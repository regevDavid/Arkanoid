package animation;

import biuoop.DrawSurface;
import listeners.Counter;
import sprites.SpriteCollection;

import java.awt.Color;

/**
 * The last screen in the game.
 */
public class EndGame implements Animation {
    private boolean shouldStop;
    private boolean winLose;
    private Counter score;
    private SpriteCollection gameScreen;

    /**
     * constructor.
     *
     * @param winLose - indicates if the player won or lost the game.
     * @param score - the score to be printed.
     * @param gameScreen - the last background in the game.
     */
    public EndGame(boolean winLose, Counter score, SpriteCollection gameScreen) {
        this.shouldStop = false;
        this.winLose = winLose;
        this.score = score;
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
        gameScreen.drawAllOn(d);
        if (winLose) {
            d.setColor(Color.YELLOW);
            d.drawText(250, d.getHeight() / 2 - 40, "You Win!", 60);
            d.drawText(190, d.getHeight() / 2 + 40, "Your score is " + this.score.getValue(), 60);
        } else {
            d.setColor(Color.BLUE);
            d.drawText(250, d.getHeight() / 2 - 40, "Game Over.", 60);
            d.drawText(250, d.getHeight() / 2 + 40, "Your score is " + this.score.getValue(), 60);
        }
    }

    /**
     * The method creates the logic of the game.
     *
     * @return - true if the game should stop, false if not.
     */
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}
