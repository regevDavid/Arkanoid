package general;

import geometry.Point;
import sprites.Collidable;

/**
 * The class handles with the collision point of the ball and the collidable.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public class CollisionInfo {
    private Point point;
    private Collidable collisionObject;

    /**
     * Constructor of CollisionInfo.
     * @param point - potential collision line.
     * @param collisionObject - collision object.
     */
    public CollisionInfo(Point point, Collidable collisionObject) {
        this.point = point;
        this.collisionObject = collisionObject;
    }

    /**
     * The function returns the point at which the collision occurs.
     *
     * @return - the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * The function returns the collidable object involved in the collision.
     *
     * @return - the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}