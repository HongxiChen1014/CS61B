/**
 * @author daisy
 * @description
 * @create 2021-12-02-11:28
 */
public class OffByN implements CharacterComparator {
    int n;

    public OffByN(int N) {
        this.n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int ans = Math.abs(x - y);
        if (ans == n) {
            return true;
        }
        return false;
    }
}
