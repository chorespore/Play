package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet81 {
    public boolean search(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        return set.contains(target);
    }

/*    public boolean search(int[] nums, int target) {
        for (int i : nums) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }*/
}
