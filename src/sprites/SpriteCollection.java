package sprites;
import java.util.ArrayList;
import java.util.List;
import biuoop.DrawSurface;

/**
 * The class holds a list of the sprites in the game.
 *
 * @version 24.4.2018.
 * @author David Regev.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * Constructor.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<Sprite>();
    }

    /**
     * The function adds a sprite to the sprite list.
     *
     * @param s - the sprite to add to the list.
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * The function removes a sprite from the sprites list.
     *
     * @param s - the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }

    /**
     * The function passes the time of all of the sprites.
     *
     * @param dt - speed balance.
     */
    public void notifyAllTimePassed(double dt) {
        List<Sprite> sprites = new ArrayList<Sprite>(spriteList);
        for (Sprite s : sprites) {
            s.timePassed(dt);
        }
    }

    /**
     * The function draws all the sprites on the screen.
     *
     * @param d - the screen to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : spriteList) {
            s.drawOn(d);
        }
    }
}