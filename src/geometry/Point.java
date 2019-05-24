package geometry;
/**
 * The class creates a point object with x and y coordinates, equals and gets the distance of two points.
 *
 * @author David Regev.
 * @version 24.4.2018.
 */
public class Point {
    // x and y values of the point.
    private double x;
    private double y;

    /**
     * constructor of point.
     *
     * @param x - x coordinate of the point.
     * @param y - y coordinate of the point.
     */
    public Point(double x, double y) {
        this.x = Math.round(x);
        this.y = Math.round(y);
    }

    /**
     * constructor of point.
     *
     * @param x - x coordinate of the point.
     * @param y - y coordinate of the point.
     */
    public Point(int x, int y) {
        this.x = Math.round(x);
        this.y = Math.round(y);
    }

    /**
     * the function returns the distance between two points.
     *
     * @param other - point to get distance from.
     * @return - the distance between the points.
     */
    public double distance(Point other) {
        return Math.sqrt((Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)));
    }

    /**
     * the function checks if the points are equal.
     *
     * @param other - point to check with.
     * @return - true if equal, false if not.
     */
    public boolean equals(Point other) {
        return (this.distance(other) == 0);
    }

    /**
     * the function returns the x coordinate of a point.
     *
     * @return - the x coordinate.
     */
    public double getX() {
        return this.x;
    }

    /**
     * the function returns the x coordinate of a point.
     *
     * @return - the x coordinate.
     */
    public double getY() {
        return this.y;
    }

    /**
     * The function sets the x value of the point.
     *
     * @param newX - the new x value of the point.
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * The function checks if a point is on a given line.
     *
     * @param line - check if the point is on that line.
     * @return - if it does - true, else - false.
     */
    public boolean isOnLine(Line line) {
        return (this.getY() == line.getSlope() * this.getX() + line.getN());
    }
}