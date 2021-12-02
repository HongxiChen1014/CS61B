import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author daisy
 * @description
 * @create 2021-12-02-12:57
 */
public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
        assertFalse(offByN.equalChars('f', 'h'));
    }
}
