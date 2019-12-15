package medium;

public class Leet503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len * 2; j++) {
                if (nums[i] < nums[j % len]) {
                    res[i] = nums[j % len];
                    break;
                }
                res[i] = -1;
            }
        }
        return res;
    }
}
