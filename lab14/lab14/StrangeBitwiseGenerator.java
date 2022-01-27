package lab14;

import lab14lib.Generator;

/**
 * @author daisy
 * @description
 * @create 2022-01-26-22:07
 */
public class StrangeBitwiseGenerator implements Generator {
    private int state;
    private int period;

    public StrangeBitwiseGenerator(int period) {
        this.state = -1;
        this.period = period;
    }

    public double next() {
        state = (state + 1);
        int weirdState = state & (state >>> 3) % period;
        return normalize(weirdState);
    }

    private double normalize(double num) {
        return (double) num * 2 / period - 1;
    }
}
