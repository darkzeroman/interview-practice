package old;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Facebook Hacker 2013 Problem 1
 */
public class FBHackerProblem1 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                printAnswer(i, br.readLine());
            }
        } catch (Exception e) {

        }
    }

    public static void printAnswer(int n, String str) {
        long ans = calculate(str);
        System.out.println(String.format("Case #%d: %d", n + 1, ans));
    }

    public static long calculate(String str) {
        str = removeNonLetters(str).toLowerCase();

        if (str.length() == 0)
            return 0;

        int[] bucketCount = bucketCountLetters(str);
        Arrays.sort(bucketCount);
        long sum = 0;
        for (int i = 0; i < bucketCount.length; i++) {
            sum += bucketCount[i] * (i + 1);
        }

        return sum;
    }

    public static String removeNonLetters(String str) {
        return str.replaceAll("[^A-Za-z0-9]", "");
    }

    public static int[] bucketCountLetters(String str) {
        int[] ret = new int[26];
        char[] buff = str.toCharArray();
        for (int i = 0; i < buff.length; i++) {
            ret[charToInt(buff[i])]++;
        }

        return ret;

    }

    public static int charToInt(char ch) {
        return Character.getNumericValue(ch) - 10;
    }

    @Test
    public void charTest() {

        assertEquals(FBHackerProblem1.charToInt('a'), 0);
        assertEquals(FBHackerProblem1.charToInt('z'), 25);
        assertEquals(FBHackerProblem1.charToInt('Z'), 25);

    }

    @Test
    public void printAnswerTest() {
        assertEquals(FBHackerProblem1.calculate("ABbCcc"), 152);

        assertEquals(FBHackerProblem1.calculate("Good luck in the Facebook Hacker Cup this year!"), 754);

        assertEquals(FBHackerProblem1.calculate("Ignore punctuation, please :)"), 491);

        assertEquals(FBHackerProblem1.calculate("Sometimes test cases are hard to make up."), 729);

        assertEquals(FBHackerProblem1.calculate("So I just go consult Professor Dalves"), 646);

    }
}
