import edu.princeton.cs.algs4.MinPQ;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class BinaryTrie implements Serializable {
    private Node root;

    public BinaryTrie(Map<Character, Integer> frequencyTable) {
        MinPQ<Node> pq = new MinPQ<>();
        for (Character c : frequencyTable.keySet()) {
            pq.insert(new Node(c, frequencyTable.get(c), null, null));
        }
        while (pq.size() > 1) {
            Node n1 = pq.delMin();
            Node n2 = pq.delMin();
            Node newNode = new Node('\0', n1.freq + n2.freq, n1, n2);
            pq.insert(newNode);
        }
        root = pq.delMin();
    }

    public Match longestPrefixMatch(BitSequence querySequence) {
        Node curr = root;
        Node child = null;
        BitSequence bitSequence = new BitSequence();
        for (int i = 0; i < querySequence.length(); i++) {
            int b = querySequence.bitAt(i);
            if (b == 0) {
                child = curr.left;
            } else if (b == 1) {
                child = curr.right;
            }
            if (child == null) {
                return new Match(bitSequence, curr.ch);
            }
            curr = child;
            bitSequence = bitSequence.appended(b);
        }
        return new Match(bitSequence, curr.ch);
    }

    public Map<Character, BitSequence> buildLookupTable() {
        Map<Character, BitSequence> res = new HashMap<>();
        helperBuildLookupTable(root, res, new BitSequence());
        return res;
    }

    private void helperBuildLookupTable(Node node, Map res, BitSequence bitSequence) {
        if (node.left != null) {
            helperBuildLookupTable(node.left, res, bitSequence.appended(0));
        }
        if (node.right != null) {
            helperBuildLookupTable(node.right, res, bitSequence.appended(1));
        }
        if (node.ch != '\0') {
            res.put(node.ch, bitSequence);
        }
    }


    private class Node implements Comparable<Node>, Serializable {
        private final char ch;
        private final int freq;
        private final Node left, right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int compareTo(Node o) {
            return this.freq - o.freq;
        }

        public char getChar() {
            return this.ch;
        }
    }

}

