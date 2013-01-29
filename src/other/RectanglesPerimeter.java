package other;
import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RectanglesPerimeter {
	enum type {
		FROM_OPENED_RECTS, FROM_UNOPENED_RECTS, BOTH
	};

	public static void main(String[] args) {
		test();
	}

	static PriorityQueue<Rectangle> unopenedRects = new PriorityQueue<Rectangle>();

	// rectangles that are currently open, next step is to deal with them ending
	static PriorityQueue<Rectangle> openedRects = new PriorityQueue<Rectangle>(
			11, new OpenedComparator());

	static PriorityQueue<Rectangle> maxHeightRects = new PriorityQueue<Rectangle>(
			11, new MaxHeightComparator());

	public static int perimeter(PriorityQueue<Rectangle> unopenedRectsInput) {
		unopenedRects = unopenedRectsInput;
		int sum = 0;
		Point diff = new Point();
		Point last = new Point();

		while (openedRects.size() > 0 || unopenedRects.size() > 0) {
			Rectangle nextRect;
			diff.move(0, 0);

			switch (next()) {
			case FROM_UNOPENED_RECTS:
				nextRect = unopenedRects.poll();
				openedRects.add(nextRect);
				maxHeightRects.add(nextRect);

				diff.x = nextRect.x - last.x;
				diff.y = maxHeightRects.peek().height - last.y;
				break;
			case BOTH: // adding and removing, when a rectangle ends and another
						// begins at the same point
				Rectangle addRect = unopenedRects.poll();
				maxHeightRects.add(addRect);
				openedRects.add(addRect);

				Rectangle removeRect = openedRects.poll();
				maxHeightRects.remove(removeRect);
				openedRects.remove(removeRect);

				diff.x = removeRect.endX - last.x;
				diff.y = maxHeightRects.peek().height - last.y;
				break;

			case FROM_OPENED_RECTS:
				nextRect = openedRects.poll();
				maxHeightRects.remove(nextRect);
				diff.x = nextRect.endX - last.x;

				// drop down if no more rectangles
				diff.y = last.y;
				if (maxHeightRects.size() > 0)
					diff.y = maxHeightRects.peek().height - last.y;
				break;

			}
			sum += diff.x + Math.abs(diff.y);
			// System.out.println(sum);
			last.translate(diff.x, diff.y);

		}
		System.out.println("Final: " + sum);
		return sum;
	}

	public static type next() {
		if (unopenedRects.size() == 0)
			return type.FROM_OPENED_RECTS;
		if (openedRects.size() == 0)
			return type.FROM_UNOPENED_RECTS;
		if (unopenedRects.peek().x < openedRects.peek().endX)
			return type.FROM_UNOPENED_RECTS;
		if (unopenedRects.peek().x == openedRects.peek().endX)
			return type.BOTH;
		else
			return type.FROM_OPENED_RECTS;

	}

	public static void test() {
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

class Rectangle implements Comparable<Rectangle> {
	int x, width, height, endX;

	public Rectangle(int x, int width, int height) {
		this.x = x;
		this.width = width;
		this.height = height;
		// ending x-coordinate of rectangle
		this.endX = this.x + this.width;
	}

	@Override
	public String toString() {
		return "Rectangle: " + this.x + " " + this.width + " " + this.height;
	}

	@Override
	// compares starting positions
	public int compareTo(Rectangle o) {
		return this.x - o.x;
	}
}

class OpenedComparator implements Comparator<Rectangle> {
	public int compare(Rectangle o1, Rectangle o2) {
		return o1.endX - o2.endX;
	}
}

class MaxHeightComparator implements Comparator<Rectangle> {
	public int compare(Rectangle o1, Rectangle o2) {
		return o2.height - o1.height;
	}

}