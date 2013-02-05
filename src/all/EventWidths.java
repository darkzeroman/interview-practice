package all;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ListIterator;

public class EventWidths {

	public static void main(String[] args) {
		new EventWidths().testCases();
	}

	public void makeWidths(Event[] inputEvents) {
		ArrayList<Event> openEvents = new ArrayList<Event>();
		ArrayList<Event> currEvents = new ArrayList<Event>();

		int maxNum = 0;
		boolean[] slots = new boolean[inputEvents.length];

		for (Event inputEvent : inputEvents) {
			ListIterator<Event> it = currEvents.listIterator();
			while (it.hasNext()) {
				Event currEvent = it.next();
				if (currEvent.endTime <= inputEvent.startTime) {
					slots[currEvent.colNum] = false;
					openEvents.add(currEvent);
					it.remove();
				}
			}

			if (currEvents.isEmpty() && !openEvents.isEmpty()) {
				for (Event e : openEvents)
					e.totalCols = maxNum;
				openEvents.clear();
				slots = new boolean[inputEvents.length];
				maxNum = 0;

			}

			currEvents.add(inputEvent);
			inputEvent.colNum = nextSlot(slots);
			maxNum = Math.max(maxNum, numTakenSlots(slots));

		}

		openEvents.addAll(currEvents);

		for (Event e : openEvents)
			e.totalCols = maxNum;
	}

	public void testCases() {
		Event firstEvent = new Event(1, 10, "1");
		Event secondEvent = new Event(1, 10, "2");
		Event thirdEvent = new Event(5, 6, "3");
		Event fourthEvent = new Event(11, 15, "4");
		Event fifthEvent = new Event(1, 4, "5");

		Event[] events = new Event[] { firstEvent, secondEvent, thirdEvent,
				fourthEvent, fifthEvent };
		Arrays.sort(events);
		makeWidths(events);

		for (Event event : events)
			System.out.println(event);

		int start = firstEvent.startTime;
		int end = 20;
		for (int i = start; i < end; i++) {
			int[] arr = new int[4];
			int totalCols = 0;
			for (Event event : events)
				if (event.startTime <= i && event.endTime >= i) {
					arr[event.colNum] = Integer.parseInt(event.name);
					totalCols = Math.max(totalCols, event.totalCols);
				}
			if (i >= 10)
				System.out.println(i + ": "
						+ Arrays.toString(Arrays.copyOf(arr, totalCols)));
			else
				System.out.println("0" + i + ": "
						+ Arrays.toString(Arrays.copyOf(arr, totalCols)));

		}

	}

	public static int nextSlot(boolean[] slots) {
		for (int i = 0; i < slots.length; i++)
			if (!slots[i]) {
				slots[i] = true;
				return i;
			}
		System.out.println("Shouldn't be here");
		return -1;
	}

	public static int numTakenSlots(boolean[] slots) {
		int num = 0;
		for (boolean b : slots)
			if (b)
				num++;
		return num;
	}

	class Event implements Comparable<Event> {
		public int startTime;
		public int endTime;
		public String name;
		public int colNum;
		public int totalCols;

		public Event(int startTime, int endTime, String name) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.name = name;
		}

		@Override
		public int compareTo(Event arg0) {
			return this.startTime - arg0.startTime;
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			return sb.append(name).append(": ").append(colNum + 1)
					.append(" out of ").append(totalCols).toString();
		}
	}

	class EndTimeComparator implements Comparator<Event> {

		@Override
		public int compare(Event arg0, Event arg1) {
			return arg1.endTime - arg0.endTime;
		}

	}

}
