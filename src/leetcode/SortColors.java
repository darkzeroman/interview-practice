package leetcode;

import java.util.Arrays;

class SortColors {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        new SortColors().sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void sortColors(int[] nums) {
        int oneIdx = nums.length - 1, twoIdx = nums.length - 1;

        int i = 0;
        while (i < oneIdx + 1 && i < nums.length) {
            if (nums[i] == 0) {
                i++;
            }
            if (nums[i] == 1) {
                swap(nums, i, oneIdx);
                oneIdx--;
                i++;
            } else {
                swap(nums, i, twoIdx);
                twoIdx--;
                oneIdx = Math.min(oneIdx, twoIdx);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}