/**
 * @author daisy
 * @description
 * @create 2021-12-02-11:28
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int ans = Math.abs(x - y);
        if (ans == 1) {
            return true;
        }
        return false;
    }
}
