package animation;

import general.Task;

/**
 * The class handles with the "show high scores" task.
 *
 * @version 7.6.2018.
 * @author David Regev.
 */
public class ShowHiScoresTask implements Task<Void> {
    private AnimationRunner runner;
    private Animation highScoresAnimation;

    /**
     * Constructor.
     *
     * @param runner - the gameLevel to run.
     * @param highScoresAnimation - the high score table presentation.
     */
    public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation) {
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
    }

    @Override
    public Void run() {
        this.runner.run(this.highScoresAnimation);
        return null;
    }
}
