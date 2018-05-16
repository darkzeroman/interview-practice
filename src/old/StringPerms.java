package old;

/**
 * Generating all permutations for a string
 */
public class StringPerms {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "ABC";
        recCall(new boolean[input.length()], input, new StringBuffer());
    }

    public static void recCall(boolean[] bools, String input, StringBuffer sb) {
        if (sb.length() == input.length()) {
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!bools[i]) {
                bools[i] = true;
                sb.append(input.charAt(i));
                recCall(bools, input, sb);
                bools[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
