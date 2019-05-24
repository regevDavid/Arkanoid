//package levels;
//import backgrounds.DirectHitBackground;
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
// * The class is the first level of the game.
// *
// * @version 17.05.2018.
// * @author David Regev.
// */
//public class DirectHit implements LevelInformation {
//    private static final int FRAMES_PER_SECOND = 60;
//
//    /**
//     * The function returns the number of balls in the level.
//     *
//     * @return - number of level.
//     */
//    @Override
//    public int numberOfBalls() {
//        return 1;
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
//        list.add(new Velocity(0, -5 * FRAMES_PER_SECOND));
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
//        return "Direct Hit";
//    }
//
//    /**
//     * The function holds the sprite of the background of the level.
//     *
//     * @return - sprite - the background.
//     */
//    @Override
//    public Sprite getBackground() {
//        Sprite backg = new DirectHitBackground();
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
//        blocks.add(new Block(new Point(375, 185), 50, 50, Color.red, 1));
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
//        return 1;
//    }
//}