package lab14;

import lab14lib.Generator;

/**
 * @author daisy
 * @description
 * @create 2022-01-26-20:37
 */
public class SawToothGenerator implements Generator {
    private int state;
    private int period;

    public SawToothGenerator(int period) {
        this.state = -1;
        this.period = period;
    }

    public double next() {
        state = (state + 1);
        double up = state % period;
        return normalize(up);
    }

    private double normalize(double num) {
        return (double) num * 2 / period - 1;
    }
}
