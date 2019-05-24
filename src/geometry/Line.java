package geometry;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * The class creates a line object between two points, finds intersecting points.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public class Line {
    // start and end points of the line.
    private Point start;
    private Point end;

    // constructors.
    /**
     * The function gets two points and creates a line.
     *
     * @param start - point.
     * @param end - point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The function gets 2 x and 2 y coordinates, creates two points,
     * and than creates a line between them.
     *
     * @param x1 - first x coordinate.
     * @param y1 - first y coordinate.
     * @param x2 - second x coordinate.
     * @param y2 - second y coordinate.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));

    }

    /**
     * The function returns the start point of the line.
     *
     * @return - point - the start of the line.
     */
    public Point start() {
        if (this.start == null) {
            return null;
        }
        return this.start;
    }

    /**
     * The function returns the end point of the line.
     *
     * @return - point - the end of the line.
     */
    public Point end() {
        if (this.start == null) {
            return null;
        }
        return this.end;
    }

    /**
     * The function returns the slope of the line.
     *
     * @return - the slope of the line.
     */
    public double getSlope() {
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        // slope formula m = (y2 - y1) / (x2 - x1).
        return (y2 - y1) / (x2 - x1);
    }

    /**
     * The function returns the n value of the line
     * from the formula y = mx + n.
     *
     * @return - n value of the line.
     */
    public double getN() {
        // derives from the formula y = mx + n.
        return this.start.getY() - (this.getSlope() * this.start.getX());
    }

    /**
     * The function finds (if exists) the intersection point of two lines.
     *
     * @param other - line, to check intersection with.
     * @return - if exists - the intersection point, else - null.
     */
    public Point intersectionWith(Line other) {
            if (this.isIntersecting(other)) {
                double intersectionX;
                double intersectionY;
                if (this.start.getX() == this.end.getX()) {
                    double m2 = other.getSlope();
                    double b2 = other.getN();
                    intersectionX = this.start.getX();
                    intersectionY = (intersectionX * m2) + b2;
                } else if (other.start().getX() == other.end().getX()) {
                    double m1 = this.getSlope();
                    double b1 = this.getN();
                    intersectionX = other.start().getX();
                    intersectionY = (intersectionX * m1) + b1;
                } else {
                    double m1 = this.getSlope();
                    double m2 = other.getSlope();
                    double b1 = this.getN();
                    double b2 = other.getN();
                    intersectionX = (b1 - b2) / (m2 - m1);
                    intersectionY = intersectionX * m1 + b1;
                }
                return new Point(intersectionX, intersectionY);
            }
            return null;
        }

    /**
     * The function checks if there is intersection of the line with an other line.
     * @param other - the line to check with.
     * @return - if there is an intersection - true, else - false.
     */
    public boolean isIntersecting(Line other) {
        if (other != null && other.start() != null && other.end() != null && this.start != null && this.end != null) {
            double intersectionX;
            double intersectionY;
            if (this.start.getX() == this.end.getX() && other.start().getX() == other.end().getX()) {
                return false;
            }
            if (this.start.getX() == this.end.getX()) {
                double m2 = other.getSlope();
                double b2 = other.getN();
                intersectionX = this.start.getX();
                intersectionY = (intersectionX * m2) + b2;
            } else if (other.start().getX() == other.end().getX()) {
                double m1 = this.getSlope();
                double b1 = this.getN();
                intersectionX = other.start().getX();
                intersectionY = (intersectionX * m1) + b1;
            } else {
                double m1 = this.getSlope();
                double m2 = other.getSlope();
                if (m1 == m2) {
                    return false;
                }
                double b1 = this.getN();
                double b2 = other.getN();
                intersectionX = (b1 - b2) / (m2 - m1);
                intersectionY = (intersectionX * m1) + b1;
            }
            return (Math.max(this.start.getX(), this.end.getX()) >= intersectionX
                    && Math.min(this.start.getX(), this.end.getX()) <= intersectionX
                    && Math.max(this.start.getY(), this.end.getY()) >= intersectionY
                    && Math.min(this.start.getY(), this.end.getY()) <= intersectionY
                    && Math.max(other.start().getX(), other.end().getX()) >= intersectionX
                    && Math.min(other.start().getX(), other.end().getX()) <= intersectionX
                    && Math.max(other.start().getY(), other.end().getY()) >= intersectionY
                    && Math.min(other.start().getY(), other.end().getY()) <= intersectionY);
        }
        return false;
    }

    /**
     * The function returns a List of intersection points with the specified line.
     *
     * @param rect - line to check intersection with.
     * @return - List of intersection points.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> l1 = rect.intersectionPoints(this);
        Point closestP = l1.get(0);
        for (Point p : l1) {
            if (p == null) {
                continue;
            }
            if (closestP == null || p.distance(this.start()) < closestP.distance(this.start())) {
                closestP = p;
            }
        }
        return closestP;
    }

    /**
     * The function draws line on a surface.
     *
     * @param l - line to be drawn.
     * @param d - surface to draw on.
     * @param color - the color of the line.
     */
    public void drawLine(Line l, DrawSurface d, Color color) {
        d.setColor(color);
        d.drawLine((int) l.start().getX(), (int) l.start().getY(), (int) l.end().getX(), (int) l.end().getY());
    }

    /**
     * The function checks if a point is on line (specific border of a block).
     *
     * @param point - the point to check.
     * @param axis - the direction of the line - vertical or horizontal.
     * @return - if it does - true, else - false.
     */
    public boolean isOn(Point point, String axis) {
        if (axis.equals("x")) {
            return (point.getX() >= Math.min(this.start.getX(), this.end.getX())
                    && point.getX() <= Math.max(this.start.getX(), this.end.getX()));
        } else {
            return (point.getY() >= Math.min(this.start.getY(), this.end.getY())
                    && point.getY() <= Math.max(this.start.getY(), this.end.getY()));
        }
    }
}