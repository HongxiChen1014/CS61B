package lab14;

import lab14lib.Generator;

/**
 * @author daisy
 * @description
 * @create 2022-01-26-21:50
 */
public class AcceleratingSawToothGenerator implements Generator {
    private int state;
    private int period;
    private double factor;

    public AcceleratingSawToothGenerator(int period, double factor) {
        this.state = 0;
        this.period = period;
        this.factor = factor;
    }

    public double next() {
        state = (state + 1);
        double up = state % period;
        if (up == 0) {
            state = 0;
            period = (int) (period * factor);
        }
        return normalize(up);
    }

    private double normalize(double num) {
        return (double) num * 2 / period - 1;
    }
}
