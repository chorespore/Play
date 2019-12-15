package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> -distance(points[n])));
        for (int i = 0; i < points.length; i++) {
            heap.add(i);
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[heap.poll()];
        }
        return res;
    }

    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
