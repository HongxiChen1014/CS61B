package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author daisy
 * @description
 * @create 2022-01-15-15:55
 */
public class Solver {
    private MinPQ<SearchNode> nodes;
    private int moves;
    private ArrayList<WorldState> solution;

    public Solver(WorldState initial) {
        nodes = new MinPQ<>(new SearchNodeComparator());
        nodes.insert(new SearchNode(initial, 0, null));
        SearchNode x;
        solution = new ArrayList<>();
        while (true) {
            x = nodes.delMin();
            if (x.ws.isGoal()) {
                moves = x.initialToThis;
                break;
            }
            for (WorldState worldState : x.ws.neighbors()) {
                if (x.prev != null && worldState.equals(x.prev.ws)) {
                    continue;
                }
                nodes.insert(new SearchNode(worldState, x.initialToThis + 1, x));
            }
        }
        while (x != null) {
            solution.add(x.ws);
            x = x.prev;
        }
        Collections.reverse(solution);

    }

    public int moves() {
        return moves;
    }

    public Iterable<WorldState> solution() {
        return solution;
    }

    private class SearchNode {
        private WorldState ws;
        int initialToThis;
        SearchNode prev;

        private SearchNode(WorldState ws, int initialToThis, SearchNode prev) {
            this.ws = ws;
            this.initialToThis = initialToThis;
            this.prev = prev;
        }
    }

    private class SearchNodeComparator implements Comparator<SearchNode> {
        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            return o1.ws.estimatedDistanceToGoal() + o1.initialToThis
                    - o2.initialToThis - o2.ws.estimatedDistanceToGoal();
        }
    }
}
