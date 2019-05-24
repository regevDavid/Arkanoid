package sprites;
import biuoop.DrawSurface;

import geometry.Line;
import geometry.Velocity;
import geometry.Point;
import geometry.Rectangle;
import levels.GameLevel;
import listeners.HitListener;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The class creates the blocks in the game.
 *
 * @author David Regev.
 * @version 24.4.2018.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle shape;
    private Color color;
    private Color stroke;
    private Integer numOfHits;
    private List<HitListener> hitListeners = new ArrayList<HitListener>();
    private Map<Integer, Color> colors;
    private Map<Integer, Image> images;

    /**
     * Constructor of the borders of the screen.
     *
     * @param shape - the shape of the block.
     * @param numOfHits - the mximum number of hits of the block.
     * @param stroke - the color of the borders of the block.
     */
    public Block(Rectangle shape, int numOfHits, Color stroke) {
        this.shape = shape;
        this.stroke = stroke;
        this.numOfHits = numOfHits;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Constructor.
     *
     * @param rect - the rectangle.
     */
    public Block(Rectangle rect) {
        this.shape = rect;
        this.numOfHits = -1;
        this.color = Color.white;
    }

    /**
     * Constructor of the blocks and paddle.
     *
     * @param upperLeft - the upper left point of the block.
     * @param width     - the width of the block.
     * @param height    - the height of the block.
     * @param stroke     - the color of the borders of the block.
     * @param numOfHits - the number of hits given to the ball.
     * @param colors - the colors of the block.
     * @param images - the images of the block.
     */
    public Block(Point upperLeft, double width, double height, Color stroke, int numOfHits, Map<Integer, Color> colors,
    Map<Integer, Image> images) {
        this.shape = new Rectangle(upperLeft, width, height);
        this.stroke = stroke;
        this.numOfHits = numOfHits;
        this.hitListeners = new ArrayList<HitListener>();
        this.images = images;
        this.colors = colors;
    }

    /**
     * getter.
     *
     * @return - the hit listeners list of the block.
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
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
     * The function return the number of hits from the ball.
     *
     * @return - num of hits.
     */
    public int getNumOfHits() {
        return this.numOfHits;
    }

    /**
     * The function sets the num of hits of the block.
     *
     * @param n - the new num of hits.
     */
    public void setNumOfHits(int n) {
        this.numOfHits = n;
    }

    /**
     * The function returns the"collision shape" of the object.
     *
     * @return - Rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with,
     * a given velocity.
     *
     * @param collisionPoint  - the point on the shape the ball hits.
     * @param currentVelocity - the velocity of the ball when it hits the shape.
     * @param hitter - the ball hitted the block.
     * @return - the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter) {
        // Arr now will hold the walls of each rectangle.
        Line[] arr = this.shape.createBorders();
        // Arr[0] and arr[1] are the upper and lower borders.
        // If the collision point is on one of them, we will change the dy.
        if (arr[0].isOn(collisionPoint, "y") || arr[1].isOn(collisionPoint, "y")) {
            if (numOfHits > 0) {
                numOfHits--;
            }
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else {
            // Arr[2] and arr[3] are the left and right borders.
            // If the collision point is on one of them we will change the dx.
            if (arr[2].isOn(collisionPoint, "x") || arr[3].isOn(collisionPoint, "x")) {
                if (numOfHits > 0) {
                    numOfHits--;
                }
                this.notifyHit(hitter);
                return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            }
        }
        return null;
    }

    /**
     * The function draws the collidable.
     *
     * @param surface - the surface to draw the collidable on.
     */
    public void drawOn(DrawSurface surface) {
        int fill = 1;
        // booleans to identify if to draw image or color.
        boolean isImageUsed = false;
        boolean isColorUsed = false;
        if (this.images != null) {
            if (this.images.size() > 0) {
                isImageUsed = true;
                fill = this.images.size();
                if (this.images.size() >= this.numOfHits) {
                    fill = this.numOfHits;
                }
            } else if (this.colors != null) {
                if (this.colors.size() > 0) {
                    isColorUsed = true;
                    fill = this.colors.size();
                    if (this.colors.size() >= this.numOfHits) {
                        fill = this.numOfHits;
                    }
                }
            }
            int i1 = (int) getCollisionRectangle().getUpperLeft().getX();
            int i2 = (int) getCollisionRectangle().getUpperLeft().getY();
            int i3 = (int) getCollisionRectangle().getWidth();
            int i4 = (int) getCollisionRectangle().getHeight();
            // draw by color.
            if (isColorUsed) {
                Color c = this.colors.get(fill);
                surface.setColor(c);
                surface.fillRectangle(i1, i2, i3, i4);
            } else if (isImageUsed) {
                // draw by image.
                Image image = this.images.get(fill);
                surface.drawImage((int) this.getCollisionRectangle().getUpperLeft().getX(),
                        (int) this.getCollisionRectangle().getUpperLeft().getY(), image);
            } else {
                // draw by color.
                surface.setColor(color);
                surface.fillRectangle(i1, i2, i3, i4);
            }
            //stroke
            if (this.stroke != null) {
                surface.setColor(this.stroke);
                surface.drawRectangle(i1, i2, i3, i4);
            }
        }
    }

    /**
     * The function notifies the block that time has passed.
     *
     * @param dt - speed balance.
     */
    public void timePassed(double dt) {
    }

    @Override
    /**
     * The function adds the block to the collidables and sprites of the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    @Override
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    /**
     * The function adds a listener to hit events.
     *
     * @param hl - the listener to add.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * The function removes a listener from the listener hit list.
     *
     * @param hl - the listener to remove.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * The method notifies all the listeners about the hit of the ball.
     *
     * @param hitter - the ball hitted the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}