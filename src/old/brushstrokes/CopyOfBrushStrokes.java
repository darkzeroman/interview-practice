package old.brushstrokes;

/**
 *
 */

public class CopyOfBrushStrokes {
    static String currString;

    public static int minNumErrors(String str, int numStrokes, int currStroke) {
        char newCurrStroke;
        if (currStroke == 1)
            newCurrStroke = 'B';
        else if (currStroke == 2)
            newCurrStroke = 'W';
        else
            newCurrStroke = 'N';
        return minNumErrors(str, numStrokes, newCurrStroke);
    }

    public static int minNumErrors(String str, int numStrokes, char currStroke) {
        currString = str;
        return recCall(0, currStroke, numStrokes);
    }

    public static int recCall(int index, char currStroke, int numStrokesLeft) {

        if (numStrokesLeft == -1)
            return currString.length() - index + 1;
        if (index == currString.length())
            return 0;

        if (currString.charAt(index) == '-')
            return recCall(index + 1, 'N', numStrokesLeft);

        int currMin = Integer.MAX_VALUE;
        if (currStroke != 'N') {
            // continue stroke
            int temp = err(index, currStroke)
                    + recCall(index + 1, currStroke, numStrokesLeft);
            currMin = Math.min(currMin, temp);
            // new stroke
            char switchedStroke = switchStroke(currStroke);
            temp = err(index, switchedStroke)
                    + recCall(index + 1, switchedStroke, numStrokesLeft - 1);
            currMin = Math.min(currMin, temp);
        } else {
            // switch to stroke 'B'
            int temp = err(index, 'B')
                    + recCall(index + 1, 'B', numStrokesLeft - 1);
            currMin = Math.min(temp, currMin);
            // switch to stroke 'W'
            temp = err(index, 'W')
                    + recCall(index + 1, 'W', numStrokesLeft - 1);
            currMin = Math.min(temp, currMin);
        }
        // no stroke
        int temp = 1 + recCall(index + 1, 'N', numStrokesLeft);
        currMin = Math.min(temp, currMin);

        return currMin;

    }

    public static char switchStroke(int currStroke) {
        return currStroke == 'B' ? 'W' : 'B';
    }

    public static int err(int index, char currStroke) {
        if (currString.charAt(index) == currStroke)
            return 0;
        else
            return 1;

    }
}
