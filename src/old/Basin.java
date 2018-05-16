package old;

import java.util.*;

/**
 * http://www.careercup.com/question?id=15380670
 */
public class Basin {

    final static Hashtable<Point, ArrayList<Point>> edges = new Hashtable<Point, ArrayList<Point>>();
    final static int[][] offsets = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int S;
    static int[][] farm;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        S = scanner.nextInt();
        farm = new int[S][S];
        for (int y = 0; y < S; y++)
            for (int x = 0; x < S; x++) {
                farm[y][x] = scanner.nextInt();
                edges.put(new Point(x, y), new ArrayList<Point>());
            }
        generateAdjList();
        classifyBasins();
    }

    public static void classifyBasins() {
        HashSet<Point> markers = new HashSet<Point>();
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        for (int y = 0; y < S; y++)
            for (int x = 0; x < S; x++) {
                Point currPoint = new Point(x, y);
                if (!markers.contains(currPoint)) {
                    sizes.add(doBFS(markers, currPoint));
                }
            }

        Collections.sort(sizes);
        Collections.reverse(sizes);
        System.out.println(sizes.toString());

    }

    public static int doBFS(HashSet<Point> visited, Point source) {

        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(source);
        int numSeenNodes = 0;

        while (queue.size() > 0) {
            Point currPoint = queue.pollFirst();
            numSeenNodes++;
            visited.add(currPoint);
            ArrayList<Point> neighbors = edges.get(currPoint);
            for (Point neighbor : neighbors) {
                if (visited.contains(neighbor) == false) {
                    queue.add(neighbor);
                }
            }
        }

        return numSeenNodes;

    }

    public static void generateAdjList() {

        for (int y = 0; y < S; y++)
            for (int x = 0; x < S; x++) {
                Point source = new Point(x, y);
                Point minNeighbor = findMinNeighbor(source);
                if (!minNeighbor.equals(source)) {
                    edges.get(source).add(minNeighbor);
                    edges.get(minNeighbor).add(source);
                }
            }
    }

    public static Point findMinNeighbor(Point source) {
        int[] minNeighbor = new int[]{source.x, source.y};
        int min = get(source);
        for (int[] offset : offsets) {
            int newMin = get(source.x + offset[0], source.y + offset[1]);

            if (newMin < min) {
                min = newMin;
                minNeighbor[0] = source.x + offset[0];
                minNeighbor[1] = source.y + offset[1];
            }
        }
        return new Point(minNeighbor[0], minNeighbor[1]);

    }

    public static int get(int x, int y) {
        if (x >= S || x < 0 || y >= S || y < 0)
            return Integer.MAX_VALUE;
        else
            return farm[y][x];
    }

    public static int get(Point point) {
        return get(point.x, point.y);
    }
}

@SuppressWarnings("serial")
class Point extends java.awt.Point {
    Point(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}
