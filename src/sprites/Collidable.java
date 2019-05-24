package sprites;


import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

/**
 * The interface organizes all the collidable objects in the GameLevel.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public interface Collidable {
    /**
     * The function returns the"collision shape" of the object.
     * @return - Rectangle.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity, notifying the listeners about the hit.
     *
     * @param collisionPoint - the point on the shape the ball hits.
     * @param currentVelocity - the velocity of the ball when it hits the shape.
     * @param hitter - the ball hitted the block
     * @return - the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter);
}