package geometry;

/**
 * The program class creates the velocity of the ball.
 * the velocity determined by either the change on x and y axes
 * or by the speed and angle of the ball.
 *
 * @author David Regev.
 * @version 24.4.2018.
 */
public class Velocity {
    private double dx;
    private double dy;

    // the change on the x and y axes.

    /**
     * Setter.
     *
     * @param dy1 - the new dy.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }

    /**
     * Setter.
     *
     * @param angle - the new angle.
     */
    public void setAngle(int angle) {
        double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        Velocity velocity = fromAngleAndSpeed(angle, speed);
        this.dx = velocity.getDx();
        this.dy = velocity.getDy();
    }



    /**
     * Constructor of velocity by the change on x and y axes.
     *
     * @param x - new change on x axis.
     * @param y - new change on y axis.
     */
    public Velocity(double x, double y) {
        this.dx = x;
        this.dy = y;
    }

    /**
     * The function returns the change on the x axis.
     *
     * @return - the dx value.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * The function returns the change on the y axis.
     *
     * @return - the dy value.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * The function gets an angle and speed of a ball and calculates the velocity of it.
     * The calculation derives from trigonometrical principals.
     *
     * @param angle - the angle of the ball's movement.
     * @param speed - the speed of the ball.
     * @return - the velocity of the ball.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // calculation to extract dx and dy from speed and angle.
        double dy = Math.sin(Math.toRadians(angle)) * speed;
        double dx = Math.cos(Math.toRadians(angle)) * speed;
        // return of the velocity.
        return new Velocity(dx, dy);
    }

    /**
     * The function gets a point, and changes the location of the center of the ball.
     * The function returns the new location of the center of the ball.
     *
     * @param p  - the original center of the ball.
     * @param dt - speed balance.
     * @return - the new center of the ball.
     */
    public Point applyToPoint(Point p, double dt) {
        return new Point((p.getX() + this.dx * dt), p.getY() + this.dy * dt);
    }
}
