package medium;

import java.util.*;

public class Leet210A {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] order = new int[numCourses];

        for (int[] pair : prerequisites) {
            int dst = pair[0];
            int src = pair[1];
            List<Integer> list = adjMap.getOrDefault(src, new ArrayList<>());
            list.add(dst);
            adjMap.put(src, list);
            inDegree[dst]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjMap.getOrDefault(node, new ArrayList<>())) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
            order[idx++] = node;
        }

        if (idx == numCourses) {
            return order;
        }
        return new int[0];
    }
}
