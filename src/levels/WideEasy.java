//package levels;
//import backgrounds.WideEasyBackground;
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
// * The class is the second level of the game.
// *
// * @version 17.05.2018.
// * @author David Regev.
// */
//public class WideEasy implements LevelInformation {
//    private static final int FRAMES_PER_SECOND = 60;
//    private WideEasyBackground background;
//
//    /**
//     * constructor.
//     */
//    public WideEasy() {
//        this.background = new WideEasyBackground();
//    }
//
//    /**
//     * The function returns the number of balls in the level.
//     *
//     * @return - number of level.
//     */
//    @Override
//    public int numberOfBalls() {
//        return 10;
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
//        int dAngle = 5;
//        for (int i = 0; i < 10; i++) {
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
//        return 400;
//    }
//
//    /**
//     * The function holds the name of the level.
//     *
//     * @return - name of the level.
//     */
//    @Override
//    public String levelName() {
//        return "Wide Easy";
//    }
//
//    /**
//     * The function holds the sprite of the background of the level.
//     *
//     * @return - sprite - the background.
//     */
//    @Override
//    public Sprite getBackground() {
//        Sprite backg = new WideEasyBackground();
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
//        Block block = new Block(new Point(10, 250), 50, 35, Color.red, 1);
//        blocks.add(block);
//        block = new Block(new Point(60, 250), 50, 35, Color.red, 1);
//        blocks.add(block);
//        block = new Block(new Point(110, 250), 50, 35, Color.orange, 1);
//        blocks.add(block);
//        block = new Block(new Point(160, 250), 50, 35, Color.orange, 1);
//        blocks.add(block);
//        block = new Block(new Point(210, 250), 50, 35, Color.yellow, 1);
//        blocks.add(block);
//        block = new Block(new Point(260, 250), 50, 35, Color.yellow, 1);
//        blocks.add(block);
//        block = new Block(new Point(310, 250), 50, 35, Color.green, 1);
//        blocks.add(block);
//        block = new Block(new Point(360, 250), 50, 35, Color.green, 1);
//        blocks.add(block);
//        block = new Block(new Point(410, 250), 50, 35, Color.green, 1);
//        blocks.add(block);
//        block = new Block(new Point(460, 250), 50, 35, Color.pink, 1);
//        blocks.add(block);
//        block = new Block(new Point(510, 250), 50, 35, Color.pink, 1);
//        blocks.add(block);
//        block = new Block(new Point(560, 250), 50, 35, Color.blue, 1);
//        blocks.add(block);
//        block = new Block(new Point(610, 250), 50, 35, Color.blue, 1);
//        blocks.add(block);
//        block = new Block(new Point(660, 250), 50, 35, Color.cyan, 1);
//        blocks.add(block);
//        block = new Block(new Point(710, 250), 50, 35, Color.cyan, 1);
//        blocks.add(block);
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
//        return 15;
//    }
//}