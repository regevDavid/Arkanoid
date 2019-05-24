import general.MenuScreen;
import highscores.HighScoresTable;

import java.io.File;

/**
 * The class produce a game.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public class Ass6Game {
    private static final int TABLE_SIZE = 5;
    /**
     * Main function - creates a game.
     *
     * @param args - user input.
     */
    public static void main(String[] args) {
        File file = new File("highscores");
        HighScoresTable scoresTable = new HighScoresTable(TABLE_SIZE);
        if (!file.exists()) {
            try {
                scoresTable.save(file);
            } catch (Exception e) {
                System.err.println("Unable to create the high scores table");
            }
        } else {
            try {
                scoresTable = HighScoresTable.loadFromFile(file);
            } catch (Exception e) {
                System.err.println("Unable to load the high scores table");
            }
        }
        MenuScreen menu = new MenuScreen();
        if (args.length > 0) {
            menu.runMenu(args);
        } else {
            String[] str = {"level_sets.txt"};
            menu.runMenu(str);
        }
    }
}
