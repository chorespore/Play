package hard;

public class Leet552 {
    int cnt = 0;

    public int checkRecord(int n) {
        helper(n, 0, 0);
        return cnt;
    }

    void helper(int n, int A, int L) {
        if (n == 0 && A < 2 && L < 3) {
            cnt++;
            return;
        }

        if (n > 0 && A < 2 && L < 3) {
            helper(n - 1, A, L);
            helper(n - 1, A + 1, L);
            helper(n - 1, A, L + 1);
        }
    }
}
