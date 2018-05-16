package leetcode;

public class MinRotateArray {
    public static void main(String[] args) {
        System.out.println(new MinRotateArray().findMin(new int[]{1}));
    }


    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int idx = l + (r - l) / 2;

            if (nums[idx + 1] < nums[idx]) {
                return nums[idx + 1];
            }

            if (idx == 0) {
                return nums[idx];
            }

            if (nums[idx] < nums[idx - 1]) {
                return nums[idx];
            }

            if (nums[l] < nums[idx] && nums[idx] < nums[r]) {
                return nums[l];
            }

            if (nums[l] < nums[idx]) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        return -1;
    }
}
