package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int[] edgeCopy;
    private boolean findCycle = false;

    public MazeCycles(Maze m) {
        super(m);
    }


    @Override
    public void solve() {
        edgeCopy = new int[maze.V()];
        Stack<Integer> fringe = new Stack<>();
        // start from 0
        fringe.push(0);
        while (!fringe.isEmpty()) {
            if (findCycle) {
                break;
            }
            int v = fringe.pop();
            marked[v] = true;
            announce();
            for (int w : maze.adj(v)) {
                if (marked[w] && edgeCopy[v] != w) {
                    edgeCopy[w] = v;
                    drawCycle(w);
                    findCycle = true;
                    break;
                } else if (!marked[w]) {
                    edgeCopy[w] = v;
                    fringe.push(w);
                }
            }
        }
    }


    // Helper methods go here
    private void drawCycle(int start) {
        int vertex = start;
        while (true) {
            edgeTo[vertex] = edgeCopy[vertex];
            vertex = edgeCopy[vertex];
            if (vertex == start) {
                break;
            }
        }
        announce();
    }
}

