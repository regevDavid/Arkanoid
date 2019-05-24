package animation;

import biuoop.DrawSurface;
import highscores.HighScoresTable;
import highscores.ScoreInfo;

import java.awt.Color;
import java.util.List;

/**
 * The class presents the high scores table.
 *
 * @version - 5.6.2018.
 * @author - David Regev.
 */
public class HighScoresAnimation implements Animation {
    private boolean shouldStop;
    private HighScoresTable table;
    private List<ScoreInfo> highScores;
    private String endKey;

    /**
     * Constructor.
     *
     * @param table - the high scores table to print.
     * @param endKey - the waiting-to-press key.
     */
    public HighScoresAnimation(HighScoresTable table, String endKey) {
        this.shouldStop = false;
        this.table = table;
        if (!(table == null)) {
            this.highScores = table.getHighScores();
        }
        this.endKey = endKey;
    }

    /**
     * The method handles the gui and frame-management.
     *
     * @param d  - the surface to draw on.
     * @param dt - the balance factor of the speed.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());


        d.setColor(Color.BLACK);
        d.drawText(51, 50, "High Scores", 32);
        d.drawText(49, 50, "High Scores", 32);
        d.drawText(50, 51, "High Scores", 32);
        d.drawText(50, 49, "High Scores", 32);
        d.setColor(Color.YELLOW);
        d.drawText(50, 50, "High Scores", 32);

        d.setColor(Color.BLACK);
        d.drawText(101, 120, "Player Name", 24);
        d.drawText(99, 120, "Player Name", 24);
        d.drawText(100, 121, "Player Name", 24);
        d.drawText(100, 119, "Player Name", 24);
        d.setColor(Color.GREEN);
        d.drawText(100, 120, "Player Name", 24);

        d.setColor(Color.BLACK);
        d.drawText(451, 120, "Score", 24);
        d.drawText(449, 120, "Score", 24);
        d.drawText(450, 121, "Score", 24);
        d.drawText(450, 119, "Score", 24);
        d.setColor(Color.GREEN);
        d.drawText(450, 120, "Score", 24);

        d.setColor(Color.BLACK);
        d.drawLine(100, 130, 700, 130);
        d.setColor(Color.GREEN);
        d.drawLine(100, 131, 700, 131);
        d.setColor(Color.BLACK);
        d.drawLine(100, 132, 700, 132);


        d.setColor(Color.BLACK);
        for (int i = 0; i < table.getHighScores().size(); i++) {
            ScoreInfo player = table.getHighScores().get(i);
            int nameX = 100;
            int scoreX = 450;
            int entryY = 170 + i * 40;

            d.setColor(Color.BLACK);
            d.drawText(nameX + 1, entryY, player.getName(), 24);
            d.drawText(nameX - 1, entryY, player.getName(), 24);
            d.drawText(nameX, entryY + 1, player.getName(), 24);
            d.drawText(nameX, entryY - 1, player.getName(), 24);
            d.setColor(Color.ORANGE);
            d.drawText(nameX, entryY, player.getName(), 24);


            d.setColor(Color.BLACK);
            d.drawText(scoreX + 1, entryY, "" + player.getScore(), 24);
            d.drawText(scoreX - 1, entryY, "" + player.getScore(), 24);
            d.drawText(scoreX, entryY + 1, "" + player.getScore(), 24);
            d.drawText(scoreX, entryY - 1, "" + player.getScore(), 24);

            d.setColor(Color.ORANGE);
            d.drawText(scoreX, entryY, "" + player.getScore(), 24);
        }

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
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}
