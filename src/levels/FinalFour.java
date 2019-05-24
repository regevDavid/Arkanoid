//package levels;
//import backgrounds.FinalFourBackground;
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
// * The class is the final level of the game.
// *
// * @author David Regev.
// * @version 17.05.2018.
// */
//public class FinalFour implements LevelInformation {
//    private static final int FRAMES_PER_SECOND = 60;
//    private static final int BLOCKS_IN_LINE = 15;
//    private static final int BLOCK_WIDTH = 50;
//    private static final int BLOCK_START_X = -30;
//    private static final int BLOCK_START_Y = 150;
//    private static final int BLOCK_HEIGHT = 30;
//
//    /**
//     * The function returns the number of balls in the level.
//     *
//     * @return - number of level.
//     */
//    @Override
//    public int numberOfBalls() {
//        return 3;
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
//        for (int i = 0; i < 3; i++) {
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
//        return 10 * FRAMES_PER_SECOND;
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
//        return "Final Four";
//    }
//
//    /**
//     * The function holds the sprite of the background of the level.
//     *
//     * @return - sprite - the background.
//     */
//    @Override
//    public Sprite getBackground() {
//        Sprite backg = new FinalFourBackground();
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
//        for (int j = 0; j < 7; j++) {
//            Color color = Color.getHSBColor(10 * j, 50 * j, 100 * j);
//            for (int i = 1; i <= (BLOCKS_IN_LINE); i++) {
//                block = new Block(new Point(BLOCK_START_X + i * BLOCK_WIDTH, BLOCK_START_Y + j * BLOCK_HEIGHT),
//                        BLOCK_WIDTH, BLOCK_HEIGHT, color, 1);
//                blocks.add(block);
//            }
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
//        return 105;
//    }
//}
