package listeners;
/**
 * a counter counts the number of hits upon a block
 * or the number of remaining blocks in the game.
 * @version 14.05.2018.
 * @author David Regev.
 */
public class Counter {
    private int value;

    /**
     * constructor.
     *
     * @param value - the value of the counter.
     */
    public Counter(int value) {
        this.value = value;
    }

    /**
     * add number to the current count.
     *
     * @param number - current count.
     */
    public void increase(int number) {
        this.value += number;
    }

    /**
     * subtract number from the current count.
     *
     * @param number - current count.
     */
    public void decrease(int number) {
        this.value -= number;
    }

    /**
     * getter.
     *
     * @return - current count.
     */
    public int getValue() {
        return this.value;
    }
}
