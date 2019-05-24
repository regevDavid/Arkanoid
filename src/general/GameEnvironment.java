package general;
import geometry.Line;
import geometry.Point;
import sprites.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The class handles with the objects the ball can collide with.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public class GameEnvironment {
    private List<Collidable> collidablesList;

    /**
     * Constructor.
     */
    public GameEnvironment() {
        this.collidablesList = new ArrayList<>();
    }

    /**
     * The function returns the collidable list.
     *
     * @return - the collidable list.
     */
    public List<Collidable> getCollidablesList() {
        return this.collidablesList;
    }

    /**
     * The function adds the given collidable to the environment.
     *
     * @param c - the object to add to the environment.
     */
    public void addCollidable(Collidable c) {
        this.collidablesList.add(c);
    }

    /**
     * The method emoves a Collidable from the collidable list.
     *
     * @param c - the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.collidablesList.remove(c);
    }

    /**
     * The function checks if the ball moving on a line will collide with a collidable.
     *
     * @param trajectory - the movement line of the ball.
     * @return - if collision occurs - the collision info, else - null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.getCollidablesList().isEmpty()) {
            return null;
        }
        List<Point> collisionPoints = new ArrayList<Point>();
        for (Collidable c : this.collidablesList) {
            collisionPoints.add(trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()));
        }
        // setting the closest block arbitrarily as the first block.
        int index = 0;
        Point closestPoint = collisionPoints.get(0);
        for (Point p : collisionPoints) {
            if (p == null) {
                continue;
            }
            if (closestPoint == null || closestPoint.distance(trajectory.start()) > p.distance(trajectory.start())) {
                closestPoint = p;
                index = collisionPoints.indexOf(p);
            }
        }
        if (closestPoint == null) {
            return null;
        }
        return new CollisionInfo(closestPoint, collidablesList.get(index));
    }
}