package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import general.Menu;
import general.Selection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class handles the animation of the menu.
 *
 * @param <T> - the return type of the class.
 * @author David Regev.
 * @version 7.6.2018.
 */
public class MenuAnimation<T> implements Menu<T> {
    private boolean shouldStop = false;
    private List<Selection<T>> selections;
    private List<T> tasks;
    private T status = null;
    private KeyboardSensor keyboard;
    private List<String> keys;
    private List<String> messages;
    private boolean isPressed = true;

    /**
     * Constructor.
     *
     * @param keyboard - the keyboard associated to the menu.
     */
    public MenuAnimation(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
        this.selections = new ArrayList<Selection<T>>();
        this.keys = new ArrayList<String>();
        this.messages = new ArrayList<String>();
        this.tasks = new ArrayList<T>();
    }

    /**
     * The function adds an option-to-select to the menu.
     *
     * @param key1       - key to wait for.
     * @param message1   - line to print.
     * @param returnVal1 - what to return.
     */
    @Override
    public void addSelection(String key1, String message1, T returnVal1) {
        this.selections.add(new Selection<T>(key1, message1, returnVal1));
        this.keys.add(key1);
        this.messages.add(message1);
        this.tasks.add(returnVal1);
    }

    /**
     * The function returns the chosen option.
     *
     * @return - an option.
     */
    @Override
    public T getStatus() {
        return this.status;
    }

    /**
     * The method handles the gui and frame-management.
     *
     * @param d  - the surface to draw on.
     * @param dt - speed balance.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(50, 80, "ARKANOID", 50);
        int y;

        y = 150;
        d.setColor(Color.BLACK);
        for (int i = 0; i < this.tasks.size(); i++) {
            d.drawText(80, y, "(" + this.keys.get(i) + ")", 30);
            d.drawText(180, y, this.messages.get(i), 30);
            y += 70;
        }
        for (int j = 0; j < this.keys.size(); j++) {
            // check if the user choose from the sub menu and run the sub menu
            if (this.keyboard.isPressed(this.keys.get(j)) && (!this.isPressed)) {
                this.status = this.tasks.get(j);
                this.shouldStop = true;
            } else {
                // didn't choose anything
                this.isPressed = false;
            }
        }
    }

    /**
     * The method creates the logic of the game.
     *
     * @return - true if the game should stop, false if not.
     */
    @Override
    public boolean shouldStop() {
        if (shouldStop) {
            shouldStop = false;
            return true;
        }
        return false;
    }
}