package brushstrokes;

/**
 * 
 */

public class BrushStrokes {

	public static void main(String[] args) {
	}

	static String currString;

	public static int minNumErrors(String str, int numStrokes, int currStroke) {
		currString = str;
		return recCall(0, numStrokes, currStroke);
	}

	public static int recCall(int index, int numStrokesLeft, int currStroke) {

		if (numStrokesLeft == -1)
			return currString.length() - index + 1;
		if (index == currString.length())
			return 0;
		/*
		 * if come across this character, end the current stroke 
		 */
		if (currString.charAt(index) == '-')
			return recCall(index + 1, numStrokesLeft, 0);

		int currMin;
		if (currStroke != 0) {
			// can't switch stroke 0 to 1 or 2, so make sure it's
			// either stroke 1 or 2
			// continuing stroke
			currMin = err(index, currStroke)
					+ recCall(index + 1, numStrokesLeft, currStroke);
			// switch stroke
			int switchedStroke = switchStroke(currStroke);
			int possibleMin = err(index, switchedStroke)
					+ recCall(index + 1, numStrokesLeft - 1, switchedStroke);
			currMin = Math.min(currMin, possibleMin);
		} else {
			// previously was stroke 0, so options are to have stroke 1 or 2
			currMin = err(index, 1) + recCall(index + 1, numStrokesLeft - 1, 1);
			int possibleMin = err(index, 2)
					+ recCall(index + 1, numStrokesLeft - 1, 2);
			currMin = Math.min(currMin, possibleMin);
		}

		// no stroke
		int possibleMin = 1 + recCall(index + 1, numStrokesLeft, 0);
		currMin = Math.min(currMin, possibleMin);
		return currMin;

	}

	/*
	 * compares the char at an index with the current stroke and returns if
	 * there is an error
	 */
	public static int err(int index, int currStroke) {
		char letter = currString.charAt(index);

		if (currStroke == 0)
			return 1;
		else if (currStroke == 1) {
			if (letter == 'B')
				return 0;
			else
				return 1;
		} else if (letter == 'W') // currStroke is 2
			return 0;
		else
			return 1;

	}

	// if 1, return 2, else 1
	public static int switchStroke(int currStroke) {
		return currStroke == 1 ? 2 : 1;
	}
}
