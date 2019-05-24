package sprites;
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import levels.GameLevel;

import java.awt.Color;

/**
 * The class handles the paddle in the game.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public class Paddle implements Sprite, Collidable {
    private static final int BORDER_WIDTH = 10;
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;
    private DrawSurface d;
    private double velocity;
    private java.awt.Color color;

    /**
     * Constructor of the paddle.
     *
     * @param upperLeft - the upper left point of the paddle.
     * @param width - the width of the paddle.
     * @param height - the height of the paddle.
     * @param keyboard - the keyboard the paddle will respond.
     * @param velocity - the velocity of the paddle movement.
     * @param d - the surface to draw the paddle on.
     */
    public Paddle(Point upperLeft, double width, double height, biuoop.KeyboardSensor keyboard, double velocity,
                  DrawSurface d) {
        this.paddle = new Rectangle(upperLeft, width, height);
        this.keyboard = keyboard;
        this.velocity = velocity;
        this.d = d;
        this.color = Color.green;
    }

    /**
     * The function moves the paddle to the right.
     *
     * @param dt - speed balance.
     */
    public void moveRight(double dt) {
        if (this.paddle.getUpperLeft().getX() + velocity * dt + this.paddle.getWidth() < d.getWidth() - BORDER_WIDTH) {
            this.paddle.getUpperLeft().setX(this.paddle.getUpperLeft().getX() + velocity * dt);
        }
    }

    /**
     * The function moves the paddle to the left.
     *
     * @param dt - speed balance.
     */
    public void moveLeft(double dt) {
        if (this.paddle.getUpperLeft().getX() - velocity * dt > BORDER_WIDTH) {
            this.paddle.getUpperLeft().setX(this.paddle.getUpperLeft().getX() - velocity * dt);
        }

    }

    /**
     * The function adds the paddle to the sprites and collidables of the game.
     *
     * @param g - the game to add the paddle to.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * The function removes a sprite from a game.
     *
     * @param g - the game to remove the sprite from.
     */
    @Override
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }

    // Sprite.
    /**
     * The function notifies the paddle that time has passed.
     *
     * @param dt - speed balance.
     */
    public void timePassed(double dt) {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) {
            moveLeft(dt);
        } else if (keyboard.isPressed(keyboard.RIGHT_KEY)) {
            moveRight(dt);
        }
    }

    /**
     * The function draws the paddle on the screen.
     *
     * @param surface - the screen to draw the paddle on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }

    // Collidable.
    @Override
    /**
     * The function returns the"collision shape" of the object.
     * @return - Rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity, notifying the listeners about the hit.
     *
     * @param collisionPoint  - the point on the shape the ball hits.
     * @param oldVelocity - the velocity of the ball when it hits the shape.
     * @param hitter          - the ball hitted the block
     * @return - the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    @Override
    public Velocity hit(Point collisionPoint, Velocity oldVelocity, Ball hitter) {
        double partLenght = this.paddle.getWidth() / 5;
        double x = collisionPoint.getX() - this.paddle.getUpperLeft().getX();
        for (int i = 0; i < 5; ++i) {
            if (i * partLenght <= x && x <= (i + 1) * partLenght) {
                switch (i + 1) {
                    case 1:
                        oldVelocity.setAngle(210);
                        break;
                    case 2:
                        oldVelocity.setAngle(240);
                        break;
                    case 3:
                        oldVelocity.setDy(-oldVelocity.getDy());
                        break;
                    case 4:
                        oldVelocity.setAngle(300);
                        break;
                    case 5:
                        oldVelocity.setAngle(330);
                        break;
                    default:
                        break;
                }
            }
        }
        return oldVelocity;
    }
}
