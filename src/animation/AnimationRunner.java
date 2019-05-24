package animation;
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * The class runs the loop of the GameLevel.
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * counstructor.
     * @param gui - the gui of the software.
     * @param framesPerSecond - movement frames per second.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * getter.
     *
     * @return - frames per second.
     */
    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * The function runs the loop animation of the GameLevel.
     *
     * @param animation - set of gui and logic of the game.
     */
    public void run(Animation animation) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int millisecondsPerFrame = 1000 / this.getFramesPerSecond();
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d, 1.0 / this.framesPerSecond);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
