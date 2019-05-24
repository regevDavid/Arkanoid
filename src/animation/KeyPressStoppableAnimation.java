package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The class handles with the "waiting-for-key-press" situations.
 *
 * @author David Regev.
 * @version 6.6.2018.
 */
public class KeyPressStoppableAnimation implements Animation {
    private String endKey;
    private boolean shouldStop;
    private boolean isAlreadyPressed;
    private KeyboardSensor keyboard;
    private Animation animation;

    /**
     * Constructor.
     *
     * @param endKey    - the end pressing button.
     * @param keyboard  - the keyboard to press.
     * @param animation - the animation we run until the press.
     */
    public KeyPressStoppableAnimation(String endKey, KeyboardSensor keyboard, Animation animation) {
        this.endKey = endKey;
        this.isAlreadyPressed = true;
        this.animation = animation;
        this.keyboard = keyboard;
        this.shouldStop = false;
    }

    /**
     * The method handles the gui and frame-management.
     *
     * @param d  - the surface to draw on.
     * @param dt - speed balance.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        this.animation.doOneFrame(d, dt);
        if (this.keyboard.isPressed(this.endKey)) {
            if (!this.isAlreadyPressed) {
                this.shouldStop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * The method creates the logic of the game.
     *
     * @return - true if the game should stop, false if not.
     */
    @Override
    public boolean shouldStop() {
       return this.shouldStop;
    }
}