package sprites;
import biuoop.DrawSurface;
import general.CollisionInfo;
import general.GameEnvironment;
import geometry.Line;
import geometry.Point;
import geometry.Velocity;
import levels.GameLevel;

/**
 * The class creates objects of balls.
 * the frame boundaries of the movement area are members of the ball.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */

public class Ball implements Sprite {
    // constants for ball measures.
    // velocity
    private static final int DX = 3;
    private static final int DY = 3;
    // center and radius of the ball.
    private Point center;
    private int radius;
    private GameEnvironment screen;
    // the color for the ball to be drawn with.
    private java.awt.Color color;
    private Velocity velocity;

    // constructors
    /**
     * The function creates a ball.
     *
     * @param center - point, the center of the ball.
     * @param r - radius of the ball.
     * @param color - the color of the ball.
     * @param screen - the screen the ball will be draw on.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment screen) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.setVelocity(DX, DY);
        this.screen = screen;
    }

    /**
     * The function sets the velocity of the ball.
     *
     * @param v - new velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * The function sets the velocity of the ball by the change on dx and dy.
     *
     * @param dx - new dx change value.
     * @param dy - new dy change value.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * The function returns the x value of the center point of the ball.
     *
     * @return - x value.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * The function returns the y value of the center point of the ball.
     *
     * @return - y value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * The function returns the radius value of the ball.
     *
     * @return - the radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * The function returns the color of the ball.
     *
     * @return - the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * The function returns the velocity of the ball.
     *
     * @return - the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * The function draws the ball on a given surface.
     *
     * @param surface - the surface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        // draw the ball.
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    @Override
    /**
     * The function adds the ball to the sprites of the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * The function removes a sprite from a game.
     *
     * @param g - the game to remove the sprite from.
     */
    @Override
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * The function notifies the block that time has passed.
     *
     * @param dt - speed balance.
     */
    public void timePassed(double dt) {
        this.moveOneStep(dt);
    }

    /**
     * The function changes the center point of the ball,
     * making the ball look like moving on the screen.
     *
     * @param dt - speed balance.
     */
    public void moveOneStep(double dt) {
        Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center, dt));
        CollisionInfo collisionInfo = screen.getClosestCollision(trajectory);
        // check if there is an intersection with border, if it doesn't,
        // it will make the step and finish the function.
        if (collisionInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center, dt);
            return;
        }
        Collidable collidable = collisionInfo.collisionObject();
        if (collidable.getCollisionRectangle().isInRectangle(collisionInfo.collisionPoint())) {
            this.setVelocity(-this.getVelocity().getDx(), -this.getVelocity().getDy());
            this.center = this.getVelocity().applyToPoint(this.center, dt);
        }
        this.setVelocity(collidable.hit(collisionInfo.collisionPoint(), this.velocity, this));
        this.center = this.getVelocity().applyToPoint(this.center, dt);
    }
}