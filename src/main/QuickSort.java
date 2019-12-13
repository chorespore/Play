package main;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 98, 9, 19};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    public static void helper(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int i, j, t, pivot;

        i = low;
        j = high;
        pivot = nums[low];

        while (i < j) {
            while (nums[j] >= pivot && i < j) {
                j--;
            }
            while (nums[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        nums[low] = nums[i];
        nums[i] = pivot;

        helper(nums, low, i - 1);
        helper(nums, i + 1, high);
    }
}
