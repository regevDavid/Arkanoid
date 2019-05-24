package general;

import animation.AnimationRunner;
import animation.MenuAnimation;
import animation.Animation;
import animation.KeyPressStoppableAnimation;
import animation.HighScoresAnimation;
import biuoop.DialogManager;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import highscores.HighScoresTable;
import levels.LevelInformation;
import reader.LevelSpecificationReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.Reader;
import java.io.LineNumberReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The class handles the menu and sub-menu.
 *
 * @author - David Regev.
 * @version - 15.6.2018.
 */
public class MenuScreen {
    private List<LevelInformation> levels;
    private GUI gui;
    private AnimationRunner animationRunner;
    private DialogManager dialogManager;
    private KeyboardSensor keyboard;

    /**
     * Constructor.
     */
    public MenuScreen() {
        this.gui = new GUI("Menu", 800, 600);
        this.animationRunner = new AnimationRunner(gui, 60);
        this.dialogManager = gui.getDialogManager();
        this.keyboard = gui.getKeyboardSensor();
    }

    /**
     * The function runs the menu screen in the game.
     *
     * @param args - set levels for the game.
     */
    public void runMenu(String[] args) {
        GameFlow game = new GameFlow(this.gui);
        Menu<Task> menu = new MenuAnimation<Task>(this.keyboard);

        Task<Void> playGame = new Task<Void>() {
            @Override
            public Void run() {
                subMenu(game, args);
                return null;
            }
        };
        Task<Void> showHighScores = new Task<Void>() {
            @Override
            public Void run() {
                showScoresTable();
                runMenu(args);
                return null;
            }
        };
        Task<Void> quitGame = new Task<Void>() {
            @Override
            public Void run() {
                gui.close();
                System.exit(0);
                return null;
            }
        };

        // the parameters to addSelection are:
        // key to wait for, line to print, what to return
        menu.addSelection("p", "Play game", playGame);
        menu.addSelection("h", "High Scores", showHighScores);
        menu.addSelection("q", "Quit", quitGame);
        while (true) {
            animationRunner.run(menu);
            Task<Void> task = menu.getStatus();
            task.run();
        }
    }

    /**
     * The function runs the sub menu of the play option.
     *
     * @param args - the set levels.
     * @param game - the game for running the levels.
     */
    public void subMenu(GameFlow game, String[] args) {
        LevelSpecificationReader levelsReader = new LevelSpecificationReader();
        Map<String, String> levelOptions = new TreeMap<>();
        Map<String, String> levelPaths = new TreeMap<>();
        BufferedReader levelSetsFile = null;

        try {
            levelSetsFile = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().
                    getResourceAsStream(args[0])));
        } catch (Exception e) {
            InputStream is = ClassLoader.getSystemClassLoader().
                    getResourceAsStream("deafault_sets.txt");
            levelSetsFile = new BufferedReader(new InputStreamReader(is));
        }
        try {
            LineNumberReader lineReader = new LineNumberReader(levelSetsFile);
            String line = lineReader.readLine();
            String c = null;
            String levelName;
            while (line != null) {
                if (lineReader.getLineNumber() % 2 == 1) {
                    String[] parts = line.split(":");
                    c = parts[0];
                    levelName = parts[1];
                    levelOptions.put(c, levelName);
                } else {
                    levelPaths.put(c, line);
                }
                line = lineReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu<Task<Void>> menu = new MenuAnimation<Task<Void>>(keyboard);
        List<LevelInformation> stageLevels = new ArrayList<LevelInformation>();
        for (String string : levelOptions.keySet()) {
            menu.addSelection(string, levelOptions.get(string), new Task<Void>() {
                @Override
                public Void run() {
                    String path = levelPaths.get(string);
                    File levelsDefinition = new File(path);
                    InputStream inputStream;
                    Reader reader = null;
                    try {
                        if (levelsDefinition != null) {
                            inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
                            reader = new InputStreamReader(inputStream);
                        }
                    } catch (Exception e) {
                        System.err.println("file isn't readable");
                        e.printStackTrace();
                    }
                    List<LevelInformation> levelInformations = new ArrayList<LevelInformation>();
                    levelInformations = LevelSpecificationReader.fromReader(reader);
                    for (LevelInformation level : levelInformations) {
                        stageLevels.add(level);
                    }
                    game.runLevels(stageLevels);
                    return null;
                }
            });
        }

        animationRunner.run(menu);
        // wait for user selection
        Task<Void> runTask = menu.getStatus();
        runTask.run();
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
