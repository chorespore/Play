package main;

import java.util.ArrayList;
import java.util.List;

public class Leet228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int cur = i;
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (cur == i) {
                res.add(String.valueOf(nums[cur]));
            } else {
                res.add(nums[cur] + "->" + nums[i]);
            }
            i++;
        }
        return res;
    }
}
