package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int n;
    private int t;
    private double[] x;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < T; i++) {
            Percolation perc = pf.make(N);
            while (true) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                }
                if (perc.percolates()) {
                    x[i] = (double) perc.numberOfOpenSites() / (n * n);
                    break;
                }
            }
        }
    }


    // sample mean of percolation threshold
    public double mean() {
        double ret = StdStats.mean(x);
        return ret;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double ret = StdStats.stddev(x);
        return ret;
    }

    //high endpoint of 95% confidence interval
    public double confidenceLow() {
        double ret = mean() - 1.96 * stddev() / Math.sqrt(t);
        return ret;
    }

    // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        double ret = mean() + 1.96 * stddev() / Math.sqrt(t);
        return ret;
    }


}
