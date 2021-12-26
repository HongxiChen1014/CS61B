package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Daisy
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Returns the value mapped to by KEY in the subtree rooted in P.
     * or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        int compare = p.key.compareTo(key);
        if (compare == 0) {
            return p.value;
        } else if (compare < 0) {
            return getHelper(key, p.right);
        } else {
            return getHelper(key, p.left);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /**
     * Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
     * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            size += 1;
            return new Node(key, value);
        }
        int compare = p.key.compareTo(key);
        if (compare == 0) {
            p.value = value;
        } else if (compare > 0) {
            p.left = putHelper(key, value, p.left);
        } else {
            p.right = putHelper(key, value, p.right);
        }
        return p;
    }

    /**
     * Inserts the key KEY
     * If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    private void keySet(Set<K> set, Node n) {
        if (n != null) {
            set.add(n.key);
            keySet(set, n.left);
            keySet(set, n.right);
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> newSet = new HashSet<>();
        keySet(newSet, root);
        return newSet;
    }

    /**
     * Removes KEY from the tree if present
     * returns VALUE removed,
     * null on failed removal.
     */
    private V remove(K key, Node n) {
        if (n == null || key == null) {
            return null;
        }
        int compare = n.key.compareTo(key);
        if (compare == 0) {
            //delete nodes with no child
            if (n.left == null && n.right == null) {
                V removeValue = n.value;
                n = null;
                return removeValue;
            }
            //delete nodes with one child
            if (n.left == null) {
                V removeValue = n.value;
                n = n.right;
                return removeValue;
            }
            if (n.right == null) {
                V removeValue = n.value;
                n = n.left;
                return removeValue;
            }
            //delete nodes with two child

        }
        if (compare > 0) {
            return remove(key, n.left);
        } else {
            return remove(key, n.right);
        }

    }

    @Override
    public V remove(K key) {
        V containsKey = get(key);
        if (containsKey != null) {
            return remove(key, root);
        }
        return null;
    }

    /**
     * Removes the key-value entry for the specified key only if it is
     * currently mapped to the specified value.  Returns the VALUE removed,
     * null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        V containsKey = get(key);
        if (containsKey == value) {
            return remove(key, root);
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
