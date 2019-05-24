package general;

import animation.AnimationRunner;
import animation.MenuAnimation;
import animation.KeyPressStoppableAnimation;
import animation.EndGame;
import animation.HighScoresAnimation;
import animation.Animation;
import biuoop.DialogManager;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import highscores.HighScoresTable;
import highscores.ScoreInfo;
import levels.GameLevel;
import levels.LevelInformation;
import listeners.Counter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The class is in charge of creating the different levels, and moving from one level to another.
 *
 * @author David Regev.
 * @version 22.05.2018.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboard;
    private GUI gui;
    private File file;
    private HighScoresTable table;

    /**
     * constructor.
     *
     * @param gui - the screen.
     */
    public GameFlow(GUI gui) {
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.animationRunner = new AnimationRunner(this.gui, 60);
        this.table = new HighScoresTable(5);
        this.file = new File("highscores.txt");
    }

    /**
     * The function saves a score to the highscores table.
     *
     * @param score - the score to add.
     */
    private void saveScore(Counter score) {
        table = HighScoresTable.loadFromFile(file);
        if (table.getRank(score.getValue()) - 1 < table.size()) {
            DialogManager dialog = gui.getDialogManager();
            String name = dialog.showQuestionDialog("Name", "What is your name?", "");
            table.add(new ScoreInfo(name, score.getValue()));
            try {
                table.save(new File("highscores.txt"));
            } catch (IOException e) {
                System.out.println(" Something went wrong while reading !");
            }
        }
    }

    /**
     * The function shows the menu screen.
     */
    public void showMenu() {
        Menu<Task<Void>> menu = new MenuAnimation<Task<Void>>(this.keyboard);
        while (true) {
            animationRunner.run(menu);
            // wait for user selection
            Task<Void> task = menu.getStatus();
            task.run();
        }
    }

    /**
     * The function runs the game.
     *
     * @param levels - list of levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter score = new Counter(0);
        Counter numOfLives = new Counter(7);
        GameLevel level = null;

        for (int i = 0; i < levels.size(); i++) {
            level = new GameLevel(levels.get(i), this.animationRunner, this.keyboard, this.gui, score,
                    numOfLives);
            // initial each level.
            level.initialize();

            while (level.getBlocksCounter().getValue() != 0 && numOfLives.getValue() > 0) {
                level.playOneTurn();
            }


            if (numOfLives.getValue() == 0) {
                saveScore(score);
                this.animationRunner.run(new KeyPressStoppableAnimation(KeyboardSensor.SPACE_KEY, this.keyboard,
                        new EndGame(false, score, level.getSprites())));
                showScoresTable();
                return;
            }
        }
        saveScore(score);
        this.animationRunner.run(new KeyPressStoppableAnimation(KeyboardSensor.SPACE_KEY, this.keyboard,
                new EndGame(true, score, level.getSprites())));
        showScoresTable();
    }

    /**
     * The function shows the high scores table.
     */
    private void showScoresTable() {
        HighScoresTable scoresTable = HighScoresTable.loadFromFile(new File("highscores.txt"));
        Animation highScores = new KeyPressStoppableAnimation("space", keyboard,
                new HighScoresAnimation(scoresTable, "space"));
        animationRunner.run(highScores);
    }
}