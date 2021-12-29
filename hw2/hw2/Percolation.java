package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private boolean[][] grids;
    private WeightedQuickUnionUF percolateSet;
    private int openGrids;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        n = N;
        openGrids = 0;
        grids = new boolean[N][N];
        percolateSet = new WeightedQuickUnionUF(N * N + 2);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grids[i][j] = false;
            }
        }
    }


    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!grids[row][col]) {
            openGrids += 1;
            grids[row][col] = true;
            if (row == 0) {
                percolateSet.union(xyToIndex(row, col), n * n);
            }
            if (row == n - 1) {
                percolateSet.union(xyToIndex(row, col), n * n + 1);
            }
            unionAround(row, col);
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return grids[row][col];
    }


    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return percolateSet.connected(n * n, n * n + 1);

    }

    // number of open sites
    public int numberOfOpenSites() {
        return openGrids;
    }


    // does the system percolate?
    public boolean percolates() {
        return percolateSet.connected(n * n, n * n + 1);
    }


    // use for unit testing (not required)
    public static void main(String[] agrs) {
    }

    
    private int xyToIndex(int row, int col) {
        return row * n + col;
    }

    private void unionAround(int row, int col) {
        if (row - 1 >= 0 && isOpen(row - 1, col)) {
            percolateSet.union(xyToIndex(row - 1, col), xyToIndex(row, col));
        }
        if (row + 1 < n && isOpen(row + 1, col)) {
            percolateSet.union(xyToIndex(row + 1, col), xyToIndex(row, col));
        }
        if (col - 1 >= 0 && isOpen(row, col - 1)) {
            percolateSet.union(xyToIndex(row, col - 1), xyToIndex(row, col));
        }
        if (col + 1 < n && isOpen(row, col + 1)) {
            percolateSet.union(xyToIndex(row, col + 1), xyToIndex(row, col));
        }
    }

}
