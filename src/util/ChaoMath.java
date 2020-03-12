package util;

public class ChaoMath {
    public static int getRandom(int max) {
        int res = (int) (Math.random() * Integer.MAX_VALUE % max);
        return res;
    }

    public static int getRandom(int min, int max) {
        if (min > max) {
            return -1;
        }
        int res = (int) (Math.random() * Integer.MAX_VALUE % max);
        return res;
    }
}
