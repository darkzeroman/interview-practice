package other;
import java.awt.Point;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Rectangle3DPerimeter {
	enum type {
		FROM_OPENED_RECTS, FROM_UNOPENED_RECTS, BOTH
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Rectangle3D> unopenedRects = new PriorityQueue<Rectangle3D>();
		unopenedRects.add(new Rectangle3D(0, 0, 5, 2));
		unopenedRects.add(new Rectangle3D(2, -1, 1, 2));
		// unopenedRects.add(new Rectangle3D(4, -1, 1, 2));

		perimeter(unopenedRects);
	}

	static PriorityQueue<Rectangle3D> unopenedRects = new PriorityQueue<Rectangle3D>();
	// rectangles that are currently open, next step is to deal with them ending
	static PriorityQueue<Rectangle3D> openedRects = new PriorityQueue<Rectangle3D>(
			11, new Opened3DComparator());

	public static int perimeter(PriorityQueue<Rectangle3D> unopenedRectsInput) {
		unopenedRects = unopenedRectsInput;
		HashSet<Rectangle3D> set = new HashSet<Rectangle3D>();
		for (Rectangle3D rect : unopenedRectsInput)
			set.add(rect);
		int sum = 0;
		for (Rectangle3D rect : set) {
			sum = RectanglePerimeter(rect, set);
			System.out.println(sum);
		}

		return sum;
	}

	public static int RectanglePerimeter(Rectangle3D rect,
			HashSet<Rectangle3D> set) {
		int sum = 0;
		int num = 1;

		Point diff = new Point();
		Point last = new Point(rect.x, rect.y);

		unopenedRects.clear();
		for (Rectangle3D curr_rect : set) {
			if (curr_rect != rect)
				unopenedRects.add(curr_rect);
		}

		while ((openedRects.size() > 0 || unopenedRects.size() > 0)
				&& last.x < rect.endX) {
			Rectangle3D nextRect;
			diff.move(0, 0);
			switch (next()) {
			case FROM_UNOPENED_RECTS:
				nextRect = unopenedRects.poll();
				openedRects.add(nextRect);
				if (num == 1)
					sum += nextRect.x - last.x;
				diff.x = nextRect.x - last.x;
				num++;
				break;
			case FROM_OPENED_RECTS:
				nextRect = openedRects.poll();
				if (num == 1)
					sum += nextRect.x + nextRect.width - last.x;
				diff.x = nextRect.x + nextRect.width - last.x;
				num--;
				break;
			}
			last.translate(diff.x, diff.y);
		}
		sum += rect.endX - last.x;
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

}

class Rectangle3D implements Comparable<Rectangle3D> {
	int x, y, width, height, endX, endY;

	public Rectangle3D(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// ending x-coordinate of rectangle
		this.endX = this.x + this.width;
		this.endY = this.y + this.height;
	}

	@Override
	public String toString() {
		return "Rectangle: " + this.x + " " + this.width + " " + this.height;
	}

	@Override
	// compares starting positions
	public int compareTo(Rectangle3D o) {
		return this.x - o.x;
	}
}

class Opened3DComparator implements Comparator<Rectangle3D> {
	public int compare(Rectangle3D o1, Rectangle3D o2) {
		return o1.endX - o2.endX;
	}
}
