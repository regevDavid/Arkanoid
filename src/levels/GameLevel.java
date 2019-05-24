package levels;

import animation.Animation;
import animation.AnimationRunner;
import animation.PauseScreen;
import animation.KeyPressStoppableAnimation;
import animation.CountdownAnimation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import general.GameEnvironment;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import listeners.Counter;
import listeners.HitListener;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import sprites.Sprite;
import sprites.Ball;
import sprites.Block;
import sprites.SpriteCollection;
import sprites.LivesIndicator;
import sprites.ScoreIndicator;
import sprites.Paddle;
import sprites.LevelName;
import sprites.Collidable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class holds the sprites and the collidables and will be in charge of the animation.
 *
 * @author David Regev.
 * @version 24.4.2018.
 */
public class GameLevel implements Animation {
    private static final int TOP = 600;
    private static final int BOTTOM = 20;
    private static final int LEFT = 0;
    private static final int RIGHT = 800;
    private static final int BLOCK_THICKNESS = 10;
    private static final int RADIUS = 7;
    private static final int PADDLE_END_X = 580;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private int numOfBalls;
    private Paddle paddle;
    private GUI gui;
    private DrawSurface drawSurface;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter scoreCounter;
    private Counter livesCounter;
    private ScoreIndicator scoreIndicator;
    private LivesIndicator livesIndicator;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation level;
    private Sprite background;

    /**
     * Constructor.
     *
     * @param level        - the level to play.
     * @param runner       - the run class of the game.
     * @param ks           - the keyboard associated to the game.
     * @param gui          - the screen to display the game.
     * @param livesCounter - current number of lives left in the game.
     * @param scoreCounter - current score of the player.
     */
    public GameLevel(LevelInformation level, AnimationRunner runner, KeyboardSensor ks, GUI gui,
                     Counter scoreCounter, Counter livesCounter) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = gui;
        this.drawSurface = this.gui.getDrawSurface();
        this.level = level;
        this.numOfBalls = this.level.numberOfBalls();
        this.blocksCounter = new Counter(this.level.numberOfBlocksToRemove());
        this.ballsCounter = new Counter(0);
        this.scoreCounter = scoreCounter;
        this.livesCounter = livesCounter;
        this.scoreIndicator = new ScoreIndicator(new Counter(0));
        this.livesIndicator = new LivesIndicator(new Counter(7));
        this.runner = runner;
        this.keyboard = ks;
        this.background = this.level.getBackground();
    }

    /**
     * The method sets the paddle on each GameLevel.
     */
    public void setPaddle() {
        this.paddle = new Paddle(new Point(RIGHT / 2 - this.level.paddleWidth() / 2, PADDLE_END_X),
                this.level.paddleWidth(), BLOCK_THICKNESS, this.keyboard, this.level.paddleSpeed(), this.drawSurface);
        this.paddle.addToGame(this);
    }

    /**
     * getter.
     *
     * @return - the sprites of the game.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * getter.
     *
     * @return - the level to play.
     */
    public LevelInformation getLevel() {
        return level;
    }

    /**
     * getter.
     *
     * @return - number of balls left.
     */
    public Counter getBallsCounter() {
        return ballsCounter;
    }

    /**
     * getter.
     *
     * @return - number of blocks left.
     */
    public Counter getBlocksCounter() {
        return blocksCounter;
    }

    /**
     * getter.
     *
     * @return - the score.
     */
    public ScoreIndicator getScoreIndicator() {
        return scoreIndicator;
    }

    /**
     * The function builds the Blocks surrounding the screen.
     */
    public void buildWalls() {
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);
        Block bottomBlock = new Block(new Rectangle(new Point(LEFT, BOTTOM), RIGHT, BLOCK_THICKNESS));
        bottomBlock.setNumOfHits(-1);
        Block leftBlock = new Block(new Rectangle(new Point(LEFT, BOTTOM), BLOCK_THICKNESS, TOP));
        leftBlock.setNumOfHits(-1);
        Block rightBlock = new Block(new Rectangle(new Point(RIGHT - BLOCK_THICKNESS, BOTTOM), BLOCK_THICKNESS, TOP));
        rightBlock.setNumOfHits(-1);
        Block deathZone = new Block(new Rectangle(new Point(LEFT, TOP), RIGHT, BLOCK_THICKNESS));
        deathZone.addToGame(this);
        deathZone.addHitListener(ballRemover);
        leftBlock.addToGame(this);
        rightBlock.addToGame(this);
        bottomBlock.addToGame(this);
    }

    /**
     * The function adds a collidable to the sprite collection.
     *
     * @param c - the collidable to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * The function removes a Collidable from the game's collidable list.
     *
     * @param c - the Collidable to be removed.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * The function adds a sprite to the sprite collection.
     *
     * @param s - the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * The method adds all the sprites to the level.
     *
     * @param list - list of the sprites to add.
     */
    public void addAllSprites(List<Block> list) {
        BlockRemover blockRemover = new BlockRemover(this, this.blocksCounter);
        HitListener scoreTracker = new ScoreTrackingListener(this.scoreCounter);
        List<Block> copyList = new ArrayList<>(list);
        for (Block block : copyList) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTracker);
        }
    }

    /**
     * The function removes a sprite from the game's sprites list.
     *
     * @param s - the sprite to be removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * The method creates a paddle and balls starting from it in each game.
     */
    public void createBallsOnPaddle() {
        // create the paddle.
        setPaddle();
        //addSprite(this.paddle);

        // list of balls' velocities.
        List<Velocity> list = new ArrayList<>(this.level.initialBallVelocities());

        // creating balls.
        for (int i = 0; i < this.numOfBalls; i++) {
            Ball ball = new Ball(new Point(RIGHT / 2, PADDLE_END_X - 5), RADIUS,
                    Color.cyan.darker(), this.environment);
            // setting the ball's velocity.
            // initial angle movement.
            ball.setVelocity(list.get(i));
            ball.addToGame(this);
            this.ballsCounter.increase(1);
        }
        System.out.println("");
    }

    /**
     * The function initialize a new game: creates the blocks, ball and paddle,
     * and add them to the game.
     */
    public void initialize() {
        // create sprites for level name, score and lives remaining.
        ScoreIndicator score = new ScoreIndicator(this.scoreCounter);
        score.addToGame(this);
        LivesIndicator lives = new LivesIndicator(this.livesCounter);
        lives.addToGame(this);
        LevelName levelName = new LevelName(this.level.levelName());
        levelName.addToGame(this);
        // add background to the sprites.
        level.getBackground().addToGame(this);

        // create the borders of the screen.
        buildWalls();
        // create blocks.
        addAllSprites(this.level.blocks());
    }

    /**
     * The function runs one life session.
     */
    public void playOneTurn() {
        // create the paddle and the balls.
        createBallsOnPaddle();
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, this.level));

        this.running = true;
        this.runner.run(this);
        this.paddle.removeFromGame(this);
    }

    /**
     * The method handles the gui and frame-management.
     *
     * @param d  - the surface to draw on.
     * @param dt - speed balance.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        this.background.drawOn(d);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed(dt);
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation("space", this.keyboard, new PauseScreen()));
        }
    }

    /**
     * The method creates the logic of the game.
     *
     * @return - true if the game should stop, false if not.
     */
    @Override
    public boolean shouldStop() {
        if (this.getBlocksCounter().getValue() == 0) {
            this.scoreCounter.increase(100);
            this.running = false;
        }
        if (this.getBallsCounter().getValue() == 0) {
            this.livesCounter.decrease(1);
            this.removeSprite(this.paddle);
            this.removeCollidable(this.paddle);
            this.running = false;
        }
        return !this.running;
    }
}