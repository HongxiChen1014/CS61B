/**
 * @author daisy
 * @description
 * @create 2021-12-02-11:21
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            d.addLast(ch);
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return helperPalindrome(d);
    }

    private boolean helperPalindrome(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }
        Character first = d.removeFirst();
        Character last = d.removeLast();
        if (!first.equals(last)) {
            return false;
        }
        return helperPalindrome(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return helperPalindrome(d, cc);
    }

    private boolean helperPalindrome(Deque<Character> d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }
        Character first = d.removeFirst();
        Character last = d.removeLast();
        if (!cc.equalChars(first, last)) {
            return false;
        }
        return helperPalindrome(d, cc);
    }
}
