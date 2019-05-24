//package levels;
//import backgrounds.Green3Background;
//import geometry.Point;
//import geometry.Velocity;
//import sprites.Block;
//import sprites.Sprite;
//
//import java.awt.Color;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * The class is the third level of the game.
// *
// * @version 17.05.2018.
// * @author David Regev.
// */
//public class Green3 implements LevelInformation {
//    private static final int FRAMES_PER_SECOND = 60;
//    private static final int BLOCKS_IN_LINE = 10;
//    private static final int BLOCK_WIDTH = 50;
//    private static final int BLOCK_START_X = 720;
//    private static final int BLOCK_START_Y = 150;
//    private static final int BLOCK_HEIGHT = 30;
//    private Green3Background background;
//
//    /**
//     * constructor.
//     */
//    public Green3() {
//        this.background = new Green3Background();
//    }
//
//    /**
//     * The function returns the number of balls in the level.
//     *
//     * @return - number of level.
//     */
//    @Override
//    public int numberOfBalls() {
//        return 2;
//    }
//
//    /**
//     * The initial velocity of each ball.
//     *
//     * @return - list of velocities.
//     */
//    @Override
//    public List<Velocity> initialBallVelocities() {
//        List<Velocity> list = new ArrayList<Velocity>();
//        int initialAngle = 180;
//        int dAngle = 50;
//        for (int i = 0; i < 2; i++) {
//            if (i % 2 == 0) {
//                list.add(Velocity.fromAngleAndSpeed(initialAngle + dAngle, 5 * FRAMES_PER_SECOND));
//            } else {
//                list.add(Velocity.fromAngleAndSpeed(initialAngle - dAngle, 5 * FRAMES_PER_SECOND));
//            }
//            dAngle += 5;
//        }
//        return list;
//    }
//
//    /**
//     * The function holds the speed of the paddle.
//     *
//     * @return - speed of the paddle.
//     */
//    @Override
//    public int paddleSpeed() {
//        return 5 * FRAMES_PER_SECOND;
//    }
//
//    /**
//     * The function holds the width of the paddle.
//     *
//     * @return - width of the paddle.
//     */
//    @Override
//    public int paddleWidth() {
//        return 100;
//    }
//
//    /**
//     * The function holds the name of the level.
//     *
//     * @return - name of the level.
//     */
//    @Override
//    public String levelName() {
//        return "Green 3";
//    }
//
//    /**
//     * The function holds the sprite of the background of the level.
//     *
//     * @return - sprite - the background.
//     */
//    @Override
//    public Sprite getBackground() {
//        Sprite backg = new Green3Background();
//        return backg;
//    }
//
//    /**
//     * THe method creates the blocks of the level.
//     *
//     * @return - list of the blocks in the level.
//     */
//    @Override
//    public List<Block> blocks() {
//        List<Block> blocks = new ArrayList<Block>();
//        Block block;
//        // first line.
//        int x = BLOCK_START_X;
//        int y = BLOCK_START_Y;
//        for (int i = 1; i <= (BLOCKS_IN_LINE); i++) {
//            block = new Block(new Point(x, y), 50, 30, Color.darkGray, 1);
//            blocks.add(block);
//            x = x - BLOCK_WIDTH;
//        }
//        // second line.
//        x = BLOCK_START_X;
//        y = y + BLOCK_HEIGHT;
//        for (int i = 1; i <= (BLOCKS_IN_LINE - 1); i++) {
//            block = new Block(new Point(x, y), 50, 30, Color.red, 1);
//            blocks.add(block);
//            x = x - BLOCK_WIDTH;
//        }
//        // third line.
//        x = BLOCK_START_X;
//        y = y + BLOCK_HEIGHT;
//        for (int i = 1; i <= (BLOCKS_IN_LINE - 2); i++) {
//            block = new Block(new Point(x, y), 50, 30, Color.yellow, 1);
//            blocks.add(block);
//            x = x - BLOCK_WIDTH;
//        }
//        // fourth line.
//        x = BLOCK_START_X;
//        y = y + BLOCK_HEIGHT;
//        for (int i = 1; i <= (BLOCKS_IN_LINE - 3); i++) {
//            block = new Block(new Point(x, y), 50, 30, Color.blue, 1);
//            blocks.add(block);
//            x = x - BLOCK_WIDTH;
//        }
//        // fifth line.
//        x = BLOCK_START_X;
//        y = y + BLOCK_HEIGHT;
//        for (int i = 1; i <= (BLOCKS_IN_LINE - 4); i++) {
//            block = new Block(new Point(x, y), 50, 30, Color.white, 1);
//            blocks.add(block);
//            x = x - BLOCK_WIDTH;
//        }
//        return blocks;
//    }
//
//    /**
//     * The method returns the number of balls in the level.
//     *
//     * @return - number of balls.
//     */
//    @Override
//    public int numberOfBlocksToRemove() {
//        return 40;
//    }
//}