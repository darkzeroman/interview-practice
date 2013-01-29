package other;
import java.util.*;

public class SolutionCompare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, K;
		// System.out.println("N:-");
		N = sc.nextInt();
		// System.out.println("K:-");
		K = sc.nextInt();
		StringBuffer start = new StringBuffer();
		for (int i = 0; i < N; i++)
			start.append(sc.next()).append(" ");
		StringBuffer end = new StringBuffer();
		for (int i = 0; i < N; i++)
			end.append(sc.next()).append(" ");
		String prev = null;
		LinkedList<String> result = movesTrack(start.toString().trim(), end
				.toString().trim(), N, K);
		System.out.println(result.size() - 1);
		for (String s : result) {
			if (prev != null)
				System.out.println(SolutionCompare.deltaMove(s, prev));
			prev = s;
		}
	}

	public static LinkedList<String> movesTrack(String start, String end,
			int N, int K) {
		Queue<String> actionQ = new LinkedList<String>();
		Set<String> visitedSet = new HashSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String, String>();
		actionQ.add(start);
		visitedSet.add(start);

		while (!actionQ.isEmpty()) {
			String source = actionQ.poll();
			for (String next : SolutionCompare.getNextMoves(source, N, K)) {
				if (next.equals(end)) {
					LinkedList<String> list = new LinkedList<String>();
					list.add(next);
					while (source != null) {
						list.add(0, source);
						source = backtrackMap.get(source);
					}
					return list;
				}
				if (!visitedSet.contains(next)) {
					actionQ.add(next);
					visitedSet.add(next);
					backtrackMap.put(next, source);
				}
			}
		}
		return null;
	}

	public static Set<String> getNextMoves(String pos, int N, int K) {
		Set<String> moves = new TreeSet<String>();
		String[] discPositions = pos.split(" ");
		for (int disc = 1; disc <= N; disc++) {
			int peg = Integer.parseInt(discPositions[disc - 1]);
			if (SolutionCompare.topOfPeg(discPositions, peg) == disc) {
				for (int targetPeg = 1; targetPeg <= K; targetPeg++) {
					int targetTop = SolutionCompare.topOfPeg(discPositions, targetPeg);
					if (targetPeg != peg & (targetTop > disc || targetTop == 0)) {
						String state = pos;
						moves.add(state.replaceFirst(discPositions[disc - 1],
								String.valueOf(targetPeg)));
					}
				}
			}
		}
		return moves;
	}

	public static int topOfPeg(String[] discPositions, int peg) {
		for (int i = 1; i <= discPositions.length; i++)
			if (Integer.parseInt(discPositions[i - 1]) == peg)
				return i;
		return 0;
	}

	public static String deltaMove(String curr, String prev) {
		String[] start = prev.split(" ");
		String[] end = curr.split(" ");
		for (int i = 1; i <= start.length; i++)
			if (!start[i - 1].equals(end[i - 1]))
				return (start[i - 1] + " " + end[i - 1]);
		return null;
	}
}