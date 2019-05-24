package highscores;


import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import java.util.List;

/**
 * The class handles with the high scores table.
 */
public class HighScoresTable {
    private int tableSize;
    private List<ScoreInfo> highScores;

    /**
     * Create an empty high-scores table with the specified size.
     * The size means that the table holds up to size top scores.
     *
     * @param size - size of the table.
     */
    public HighScoresTable(int size) {
        this.tableSize = size;
        this.highScores = new ArrayList<>(size);
    }


    /**
     * Add a high-score.
     *
     * @param score - the score to add.
     */
    public void add(ScoreInfo score) {
        if (getRank(score.getScore()) != -1) {
            this.highScores.add(getRank(score.getScore()) - 1, score);
        }
        if (this.highScores.size() > this.tableSize) {
            this.highScores.remove(this.highScores.size() - 1);
        }
    }

    /**
     * getter.
     *
     * @return - the size of the table.
     */
    public int size() {
        return this.tableSize;
    }


    /**
     * Return the current high scores.
     * The list is sorted such that the highest
     * scores come first.
     *
     * @return - the high score.
     */
    public List<ScoreInfo> getHighScores() {
        return this.highScores;
    }


    /**
     * return the rank of the current score: where will it
     * be on the list if added?
     * Rank 1 means the score will be highest on the list.
     * Rank `size` means the score will be lowest.
     * Rank > `size` means the score is too low and will not
     * be added to the list.
     *
     * @param score - the score we want to add to the list.
     * @return - if we can add it, return the rank of the score.
     * if the score is to low, return -1.
     */
    public int getRank(int score) {
        if (tableSize < 1) {
            return -1;
        }
        for (int i = 0; i < this.highScores.size(); i++) {
            if (score > this.highScores.get(i).getScore()) {
                return i + 1;
            }
        }
        return this.highScores.size() + 1;
    }


    /**
     * Clears the table.
     */
    public void clear() {
        this.highScores.clear();
    }

    /**
     * The function checks if to insert the score to the high score table.
     *
     * @param score - the score to check.
     * @return - true if we need to insert, else - false.
     */
    public Boolean isHigher(int score) {
        int rank = this.getRank(score);
        if (rank < this.tableSize) {
            return true;
        }
        return false;

    }

    /**
     * Tester.
     */
    public void printTable() {
        int i = 1;
        for (ScoreInfo currScore : this.highScores) {
            System.out.println("Rank(" + i + ") - name: " + currScore.getName() + " score: " + currScore.getScore());
            i++;
        }
    }

    /**
     * @param filename the name of the file
     * @throws IOException an exception
     *                     load table data from file
     */
    public void load(File filename) throws IOException {
        clear();
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(filename));
            this.highScores.addAll((List<ScoreInfo>) stream.readObject());
        } catch (Exception e) {
            System.out.println(" Something went wrong while reading !");
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    /**
     * @param fileName the name of the file
     * @throws IOException an exception
     *                     Save table data to the specified file.
     */
    public void save(File fileName) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(getHighScores());
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    /**
     * @param filename the file we want to load from
     * @return Read a table from file and return it.
     * If the file does not exist, or there is a problem with
     * reading it, an empty table is returned.
     */
    public static HighScoresTable loadFromFile(File filename) {
        HighScoresTable table = new HighScoresTable(5);
        try {
            table.load(filename);
        } catch (IOException e) {
            System.out.println(" Something went wrong while writing !");
        }
        return table;
    }
}