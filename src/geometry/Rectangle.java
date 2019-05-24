package geometry;
import biuoop.DrawSurface;

import java.util.List;
import java.util.ArrayList;

/**
 * The class handles the construction and functions on the rectangles in the GameLevel.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     *
     * @param upperLeft - the upper left point of the rectangle.
     * @param width     - the width of the rectangle.
     * @param height    - the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * The function returns the width of the rectangle.
     *
     * @return - width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * The function returns the height of the rectangle.
     *
     * @return - height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * The function returns the upper left point of the rectangle.
     *
     * @return - point - upper left corner of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * The function returns the upper right point of the rectangle.
     *
     * @return - point - upper right corner of the rectangle.
     */
    public Point getUpperRight() {
        return new Point(this.getUpperLeft().getX() + this.getWidth(), this.getUpperLeft().getY());
    }

    /**
     * The function returns the lower right point of the rectangle.
     *
     * @return - point - lower right corner of the rectangle.
     */
    public Point getLowerLeft() {
        return new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.getHeight());
    }

    /**
     * The function returns the lower left point of the rectangle.
     *
     * @return - point - lower left corner of the rectangle.
     */
    public Point getLowerRight() {
        return new Point(this.getUpperRight().getX(), this.getLowerLeft().getY());
    }

    /**
     * The function returns the upper line of the rectangle.
     *
     * @return - point - upper line of the rectangle.
     */
    public Line getUpperLine() {
        return new Line(this.getUpperLeft(), this.getUpperRight());
    }

    /**
     * The function returns the lower line of the rectangle.
     *
     * @return - point - lower line of the rectangle.
     */
    public Line getLowerLine() {
        return new Line(this.getLowerLeft(), this.getLowerRight());
    }

    /**
     * The function returns the right line of the rectangle.
     *
     * @return - point - right line of the rectangle.
     */
    public Line getRightLine() {
        return new Line(this.getUpperRight(), this.getLowerRight());
    }

    /**
     * The function returns the left line of the rectangle.
     *
     * @return - point - left line of the rectangle.
     */
    public Line getLeftLine() {
        return new Line(this.getUpperLeft(), this.getLowerLeft());
    }

    /**
     * The function returns an array of the borders of the screen.
     * @return - array of the borders.
     */
    public Line[] createBorders() {
        Line[] borders = new Line[4];
        // upper border.
        borders[0] = new Line(this.getUpperLeft(), this.getUpperRight());
        // lower border.
        borders[1] = new Line(this.getLowerLeft(), this.getLowerRight());
        // right border.
        borders[2] = new Line(this.getUpperRight(), this.getLowerRight());
        // left border.
        borders[3] = new Line(this.getUpperLeft(), this.getLowerLeft());
        return borders;
    }

    /**
     * The function gets a line and returns a list of intersection points of the line with the rectangle.
     *
     * @param line - the path line of the ball.
     * @return - list of intersection points of the ball and the rectangle.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> l1 = new ArrayList<Point>();
        l1.add(line.intersectionWith(this.getUpperLine()));
        l1.add(line.intersectionWith(this.getLowerLine()));
        l1.add(line.intersectionWith(this.getLeftLine()));
        l1.add(line.intersectionWith(this.getRightLine()));
        return l1;
    }

    /**
     * The function checks if a point is inside of a specific rectangle.
     *
     * @param p - the point to check.
     * @return - if it does - true, else - false.
     */
    public boolean isInRectangle(Point p) {
        return (this.getUpperLeft().getX() < p.getX() && this.getUpperRight().getX() > p.getX()
                && this.getUpperLeft().getY() < p.getY() && this.getLowerLeft().getY() > p.getY());
    }

    /**
     * The function gets a surface and draw the rectangle on it.
     *
     * @param surface - the surface to draw on.
     */
    public void fillOnSurface(DrawSurface surface) {
        surface.fillRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(), (int) this.width,
                (int) this.height);
    }

    /**
     * The function gets a surface and draw the rectangle on it.
     *
     * @param surface - the surface to draw on.
     */
    public void drawOnSurface(DrawSurface surface) {
        surface.drawRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(), (int) this.width,
                (int) this.height);
    }

    /**
     *
     * @param args - input from the user.
     */
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(new Point(1, 1), 3, 8);
       }
}
