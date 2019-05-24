package levels;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.io.Reader;
import java.util.List;

/**
 * The interface holds all the needed information for a level.
 */
public interface LevelInformation {
    /**
     * The function returns the number of balls in the level.
     *
     * @return - number of level.
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return - list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * The function holds the speed of the paddle.
     *
     * @return - speed of the paddle.
     */
    int paddleSpeed();

    /**
     * The function holds the width of the paddle.
     *
     * @return - width of the paddle.
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     * The function holds the name of the level.
     *
     * @return - name of the level.
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     * The function holds the sprite of the background of the level.
     *
     * @return - sprite - the background.
     */
    Sprite getBackground();

    /**
     * The function returns the number of balls in the level.
     *
     * @return - number of level.
     */
    int getNumberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return - list of velocities.
     */
    List<Velocity> getVelocities();

    /**
     * The function holds the speed of the paddle.
     *
     * @return - speed of the paddle.
     */
    int getPaddleSpeed();

    /**
     * The function holds the width of the paddle.
     *
     * @return - width of the paddle.
     */
    int getPaddleWidth();

    /**
     * The function holds the name of the level.
     *
     * @return - name of the level.
     */
    String getLevelName();

    /**
     * Getter.
     *
     * @return - the height of each row of blocks in the level.
     */
    int getRowHeight();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return - the blocks of the game.
     */
    List<Block> blocks();


    /**
     * number of blocks to remove for ending the level.
     *
     * @return - number of blocks.
     */
    int numberOfBlocksToRemove();

    /**
     * Setter.
     *
     * @param file1 - the block definition file.
     */
    void setFile(Reader file1);

    /**
     * Getter.
     *
     * @return - the block definition file.
     */
    Reader getFile();

    /**
     * Setter.
     *
     * @param rowHeight1 - the height of each row in the level.
     */
    void setRowHeight(int rowHeight1);

    /**
     * Setter.
     *
     * @param blocksStartX1 - value of the X-axis start point of the blocks.
     */
    void setBlocksStartX(int blocksStartX1);

    /**
     * Setter.
     *
     * @param blocksStartY1 - value of the Y-axis start point of the blocks.
     */
    void setBlocksStartY(int blocksStartY1);

    /**
     * Getter.
     *
     * @return - x starting point.
     */
    int getBlocksStartX();

    /**
     * Getter.
     *
     * @return - y starting point.
     */
    int getBlocksStartY();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return - the blocks of the game.
     */
    List<Block> getBlocks();

    /**
     * setter.
     *
     * @param velocities1 - list of velocities to the balls in the level.
     */
    void setVelocities(List<Velocity> velocities1);

    /**
     * setter.
     *
     * @param paddleSpeed1 - the speed of the paddle in the level.
     */
    void setPaddleSpeed(int paddleSpeed1);

    /**
     * setter.
     *
     * @param paddleWidth1 - the width of the paddle in the level.
     */
    void setPaddleWidth(int paddleWidth1);

    /**
     * setter.
     *
     * @param levelName1 - the name of the level.
     */
    void setLevelName(String levelName1);

    /**
     * setter.
     *
     * @param background1 - the background of the level.
     */
    void setBackground(Sprite background1);

    /**
     * setter.
     *
     * @param blocks1 - list of the blocks of the level.
     */
    void setBlocks(List<Block> blocks1);

    /**
     * setter.
     *
     * @param numberOfBlocksToRemove1 - number of blocks to remove for passing the level.
     */
    void setNumberOfBlocksToRemove(int numberOfBlocksToRemove1);
}