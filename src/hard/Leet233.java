package hard;

public class Leet233 {
    public int countDigitOne(int n) {
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            int t = i;
            while (t > 0) {
                if (t % 10 == 1) {
                    cnt++;
                }
                t = t / 10;
            }
        }
        return cnt;
    }
}
