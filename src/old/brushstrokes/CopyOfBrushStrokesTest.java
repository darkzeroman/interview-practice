package old.brushstrokes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CopyOfBrushStrokesTest {

    @Test
    public void test() {
        assertEquals(4, BrushStrokesDP.minNumErrors("BBBB", 0, 0));
        assertEquals(0, BrushStrokesDP.minNumErrors("BBBB", 0, 1));
        assertEquals(4, BrushStrokesDP.minNumErrors("BBBB", 0, 2));

        assertEquals(4, BrushStrokesDP.minNumErrors("WWWW", 0, 0));
        assertEquals(4, BrushStrokesDP.minNumErrors("WWWW", 0, 1));
        assertEquals(0, BrushStrokesDP.minNumErrors("WWWW", 0, 2));

        assertEquals(2, BrushStrokesDP.minNumErrors("BBWW", 1, 0));
        assertEquals(0, BrushStrokesDP.minNumErrors("BBWW", 1, 1));
        assertEquals(2, BrushStrokesDP.minNumErrors("BBWW", 1, 2));

        assertEquals(2, BrushStrokesDP.minNumErrors("WWBB", 1, 0));
        assertEquals(2, BrushStrokesDP.minNumErrors("WWBB", 1, 1));
        assertEquals(0, BrushStrokesDP.minNumErrors("WWBB", 1, 2));

        assertEquals(1, BrushStrokesDP.minNumErrors("WBWW", 1, 0));
        assertEquals(2, BrushStrokesDP.minNumErrors("WBWWB", 1, 0));
        assertEquals(3, BrushStrokesDP.minNumErrors("WBWWWBB", 1, 0));
        assertEquals(1, BrushStrokesDP.minNumErrors("WBWWWBB", 2, 0));

        assertEquals(2, BrushStrokesDP.minNumErrors("WW-BB", 1, 0));
        assertEquals(0, BrushStrokesDP.minNumErrors("WW-BB", 2, 0));

        assertEquals(4, BrushStrokesDP.minNumErrors("WWWW-WBWB-BBBB", 2, 0));
        assertEquals(2, BrushStrokesDP.minNumErrors("WWWW-WBWB-BBBB", 3, 0));

    }
}
