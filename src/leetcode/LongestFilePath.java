package leetcode;

import java.util.ArrayList;
import java.util.List;

class LongestFilePath {
    public static void main(String[] args) {
        System.out.println(new LongestFilePath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    public int lengthLongestPath(String input) {
        List<Integer> countByIndex = new ArrayList<>();
        String[] rows = input.split("\n");
        int maxLength = 0;
        for (String row : rows) {
            int numTabs = numTabs(row);

            if (numTabs < countByIndex.size()) {
                countByIndex = countByIndex.subList(0, numTabs);
            }
            countByIndex.add(trimLeftTabs(row).length());

            if (row.contains(".ext")) {
                int len = countByIndex.stream().mapToInt(Integer::intValue).sum() + Math.max(0, countByIndex.size() - 1);
                if (len > maxLength) maxLength = len;
            }
        }
        return maxLength > 0 ? maxLength : -1;
    }

    private int numTabs(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\t' || str.substring(i, Math.min(str.length(), i + 2)).equals("\\t")) {
                count++;
            }
        }
        return count;
    }

    private String trimLeftTabs(String str) {
        return str.replaceFirst("\t*", "");
    }
}