package hard;

public class Leet84 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, (j - i + 1) * min);
            }
        }
        return max;
    }
}
