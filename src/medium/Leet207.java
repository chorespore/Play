package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet207 {
    int WHIET = 0;
    int GREY = 1;
    int BLACK = 2;
    boolean isPossible = true;
    Map<Integer, Integer> color = new HashMap<>();
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    void dfs(int node) {
        if (!isPossible) {
            return;
        }

        color.put(node, GREY);
        for (int neighbor : adjMap.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbor) == WHIET) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GREY) {
                isPossible = false;
            }
        }

        color.put(node, BLACK);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHIET);
        }
        for (int[] pair : prerequisites) {
            int dst = pair[0];
            int src = pair[1];
            List<Integer> list = adjMap.getOrDefault(src, new ArrayList<>());
            list.add(dst);
            adjMap.put(src, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHIET) {
                dfs(i);
            }
        }

        return isPossible;
    }
}
