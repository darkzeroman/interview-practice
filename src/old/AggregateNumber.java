package old;

public class AggregateNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {

        boolean ans = isAggregateNumber("112112224");
        System.out.println(ans);
    }

    static boolean isValid(String a, String b, String c) {
        int first = Integer.parseInt(a);
        int second = Integer.parseInt(b);
        int third = Integer.parseInt(c);

        return (first + second == third);
    }

    static boolean isAggregateNumber(String str) {
        if (str.length() == 0)
            return true;
        if (str.length() < 2)
            return false;
        for (int i = 1; i <= str.length() / 2; i++)
            for (int j = i + 1; j < str.length(); j++) {
                int maxDigs = j + Math.max(i, j - 1);
                for (int k = maxDigs; (k <= maxDigs + 1) && (k <= str.length()); k++) {
                    if (isValid(str.substring(0, i), str.substring(i, j), str.substring(j, k))) {
                        System.out.println(String.format("%s, %s, %s", str.substring(0, i), str.substring(i, j),
                                str.substring(j, k)));
                        if (isAggregateNumber(str.substring(k)))
                            return true;
                    }
                }
            }

        return false;
    }
}
