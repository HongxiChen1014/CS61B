import edu.princeton.cs.algs4.Queue;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // find the longest length
        int max = Integer.MIN_VALUE;
        String[] toSort = new String[asciis.length];
        int i = 0;
        for (String s : asciis) {
            max = max > s.length() ? max : s.length();
            toSort[i++] = s;
        }
        i = 0;
        while (i != max) {
            Queue<String>[] q = new Queue[256];
            for (int t = 0; t < 256; t++) {
                q[t] = new Queue<>();
            }
            for (String s : toSort) {
                int index = max - i - 1;
                if (index >= s.length()) {
                    q[0].enqueue(s);
                    continue;
                }
                //System.out.println(s.length() + " " + index);
                q[(int) s.charAt(index)].enqueue(s);
            }
            int k = 0;
            for (int m = 0; m < 256; m++) {
                while (!q[m].isEmpty()) {
                    toSort[k++] = q[m].dequeue();
                }
            }
            i++;
        }
        return toSort;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     *
     * @param asciis Input array of Strings
     * @param index  The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        return;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start  int for where to start sorting in this method (includes String at start)
     * @param end    int for where to end sorting in this method (does not include String at end)
     * @param index  the index of the character the method is currently sorting on
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }

    public static void main(String[] args) {
        String[] toSort = new String[5];
        toSort[0] = "vsrls";
        toSort[1] = "dfgjo";
        toSort[2] = "gkamv";
        toSort[3] = "dffxvb";
        toSort[4] = "fvsgaco";
        String[] sorted = sort(toSort);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
