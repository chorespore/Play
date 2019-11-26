package medium;

public class Leet33 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            System.out.println(lo + ":" + mid + ":" + hi);
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return -1;
    }
}
