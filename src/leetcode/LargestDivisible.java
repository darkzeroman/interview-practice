package leetcode;

import java.util.*;

class LargestDivisible {
    public static void main(String[] args) {
        System.out.println(new LargestDivisible().largestDivisibleSubset(new int[]{1, 2, 4, 8, 16}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        boolean hasOne = nums.length > 0 && nums[0] == 1 || nums.length > 1 && nums[1] == 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1 || nums[i] == 0) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            while (true) {
                int tmpInt = (int) Math.pow(tmp.get(tmp.size() - 1), .5);
                if (tmpInt == 0 || tmpInt == 1) {
                    break;
                }
                if (!set.contains(tmpInt)) {
                    break;
                }
                tmp.add(tmpInt);
                set.remove(tmpInt);
            }
            if (result.size() < tmp.size()) {
                result = tmp;
            }
        }

        if (hasOne) {
            result.add(1);
        }
        return result;
    }
}