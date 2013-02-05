package all;
import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Test;

public class RectanglesPerimeterTesting {

	@Test
	public void test() {
		PriorityQueue<Rectangle> to_open = new PriorityQueue<Rectangle>();

		assertEquals(0, RectanglesPerimeter.perimeter(to_open));

		to_open.add(new Rectangle(0, 1, 1));
		assertEquals(3, RectanglesPerimeter.perimeter(to_open));

		to_open.clear();
		to_open.add(new Rectangle(0, 5, 1));
		assertEquals(7, RectanglesPerimeter.perimeter(to_open));

		to_open.clear();
		to_open.add(new Rectangle(0, 5, 1));
		to_open.add(new Rectangle(2, 1, 2));
		assertEquals(9, RectanglesPerimeter.perimeter(to_open));

		to_open.clear();
		to_open.add(new Rectangle(0, 1, 1));
		to_open.add(new Rectangle(2, 1, 1));
		assertEquals(7, RectanglesPerimeter.perimeter(to_open));

		to_open.clear();
		to_open.add(new Rectangle(0, 1, 8));
		assertEquals(17, RectanglesPerimeter.perimeter(to_open));
		
		to_open.clear();
		to_open.add(new Rectangle(0, 3, 8));
		to_open.add(new Rectangle(1, 1, 1));

		assertEquals(19, RectanglesPerimeter.perimeter(to_open));
	}
}
