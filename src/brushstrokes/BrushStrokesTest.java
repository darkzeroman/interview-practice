package brushstrokes;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrushStrokesTest {

	@Test
	public void test() {
		assertEquals(4, CopyOfBrushStrokes.minNumErrors("BBBB", 0, 0));
		assertEquals(0, CopyOfBrushStrokes.minNumErrors("BBBB", 0, 1));
		assertEquals(4, CopyOfBrushStrokes.minNumErrors("BBBB", 0, 2));

		assertEquals(4, CopyOfBrushStrokes.minNumErrors("WWWW", 0, 0));
		assertEquals(4, CopyOfBrushStrokes.minNumErrors("WWWW", 0, 1));
		assertEquals(0, CopyOfBrushStrokes.minNumErrors("WWWW", 0, 2));

		assertEquals(2, CopyOfBrushStrokes.minNumErrors("BBWW", 1, 0));
		assertEquals(0, CopyOfBrushStrokes.minNumErrors("BBWW", 1, 1));
		assertEquals(2, CopyOfBrushStrokes.minNumErrors("BBWW", 1, 2));

		assertEquals(2, CopyOfBrushStrokes.minNumErrors("WWBB", 1, 0));
		assertEquals(2, CopyOfBrushStrokes.minNumErrors("WWBB", 1, 1));
		assertEquals(0, CopyOfBrushStrokes.minNumErrors("WWBB", 1, 2));

		assertEquals(1, CopyOfBrushStrokes.minNumErrors("WBWW", 1, 0));
		assertEquals(2, CopyOfBrushStrokes.minNumErrors("WBWWB", 1, 0));
		assertEquals(3, CopyOfBrushStrokes.minNumErrors("WBWWWBB", 1, 0));
		assertEquals(1, CopyOfBrushStrokes.minNumErrors("WBWWWBB", 2, 0));

		assertEquals(2, CopyOfBrushStrokes.minNumErrors("WW-BB", 1, 0));
		assertEquals(0, CopyOfBrushStrokes.minNumErrors("WW-BB", 2, 0));

		assertEquals(4, CopyOfBrushStrokes.minNumErrors("WWWW-WBWB-BBBB", 2, 0));
		assertEquals(2, CopyOfBrushStrokes.minNumErrors("WWWW-WBWB-BBBB", 3, 0));

	}
}
