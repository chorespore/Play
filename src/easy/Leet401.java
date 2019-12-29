package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet401 {
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        int[] digits = new int[10];
        helper(digits, 0, num);
        return res;
    }

    public void helper(int[] digits, int cur, int num) {
        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            int hours = 0, minutes = 0;
            for (int i = 0; i < 4; i++) {
                hours = hours * 2 + digits[i];
            }
            for (int i = 4; i < 10; i++) {
                minutes = minutes * 2 + digits[i];
            }
            if (minutes < 10) {

            }
            if (hours < 12 && minutes < 60) {
                sb.append(hours).append(":");
                if (minutes < 10) {
                    sb.append("0");
                }
                sb.append(minutes);
                res.add(sb.toString());
            }
        } else if (cur < digits.length) {
            helper(digits, cur + 1, num);
            int[] tmp = Arrays.copyOf(digits, digits.length);
            tmp[cur] = 1;
            helper(tmp, cur + 1, num - 1);
        }
    }
}
