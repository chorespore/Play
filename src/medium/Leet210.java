package medium;

import java.util.*;

//拓扑排序
public class Leet210 {
    static int WHITE = 0;
    static int GREY = 1;
    static int BLACK = 2;

    boolean isPossible = true;
    Map<Integer, Integer> color = new HashMap<>();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Stack<Integer> order = new Stack<>();

    void dfs(int node) {
        if (!isPossible) {
            return;
        }

        color.put(node, GREY);

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GREY) {
                isPossible = false;
            }
        }

        color.put(node, BLACK);
        order.push(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }

        for (int[] pair : prerequisites) {
            int dst = pair[0];
            int src = pair[1];
            List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
            list.add(dst);
            adjList.put(src, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        if (isPossible) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = order.pop();
            }
            return res;
        }
        return new int[0];
    }
}