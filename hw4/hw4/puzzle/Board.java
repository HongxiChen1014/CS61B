package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

import static java.lang.Math.abs;

public class Board implements WorldState {
    private int N;
    private int[][] tiles;
    private int[][] goal;
    private static final int BLANK = 0;

    /**
     * Constructs a board from an N-by-N array of tiles where
     * tiles[i][j] = tile at row i, column j
     */
    public Board(int[][] tiles) {
        this.N = tiles[0].length;
        this.tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.tiles[i][j] = tiles[i][j];
            }
        }
        goal = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                goal[i][j] = i * N + j + 1;
            }
        }
        goal[N - 1][N - 1] = 0;
    }

    //Returns value of tile at row i, column j (or 0 if blank)
    public int tileAt(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        return tiles[i][j];
    }

    //Returns the board size N
    public int size() {
        return N;
    }

    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbs = new Queue<>();
        //find blank
        int blankX = -1;
        int blankY = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tileAt(i, j) == BLANK) {
                    blankX = i;
                    blankY = j;
                    break;
                }
            }
        }
        // create new board
        int[][] newBoard = new int[size()][size()];
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                newBoard[i][j] = tileAt(i, j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (abs(i - blankX) + abs(j - blankY) == 1) {
                    newBoard[blankX][blankY] = tiles[i][j];
                    newBoard[i][j] = BLANK;
                    neighbs.enqueue(new Board(newBoard));
                    newBoard[i][j] = newBoard[blankX][blankY];
                    newBoard[blankX][blankY] = BLANK;
                }
            }
        }
        return neighbs;
    }

    public int hamming() {
        int estimate = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tiles[i][j] != BLANK && tiles[i][j] != goal[i][j]) {
                    estimate += 1;
                }
            }
        }
        return estimate;
    }

    public int manhattan() {
        int estimate = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tileAt(i, j) != BLANK && tileAt(i, j) != goal[i][j]) {
                    int goalX = (tileAt(i, j) - 1) / N;
                    int goalY = (tileAt(i, j) - 1) % N;
                    estimate += abs(goalX - i) + abs(goalY - j);
                }
            }
        }
        return estimate;
    }

    /**
     * Estimated distance to goal. This method should
     * simply return the results of manhattan() when submitted to
     * Gradescope.
     */
    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    //Returns true if this board's tile values are the same position as y's
    public boolean equals(Object y) {
        if (y == null) {
            return false;
        }
        if (y.getClass() == this.getClass()) {
            Board b = (Board) y;
            if (b.size() != this.size()) {
                return false;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (b.tileAt(i, j) != tileAt(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int ret = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); i++) {
                ret = ret * 31 + tileAt(i, j);
            }
        }
        return ret;
    }

    /**
     * Returns the string representation of the board. This
     * method is provided in the skeleton
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
