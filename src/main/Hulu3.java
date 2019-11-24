package main;

import java.util.*;

public class Hulu3 {
    private static boolean isPossible = true;
    private static int[] inDegree;
    private static int[] order;
    private static Map<Integer, List<Integer>> adjMap = new HashMap<>();
    private static List<Integer> indep = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        inDegree = new int[m + 1];
        order = new int[m];
        for (int i = 0; i < k; i++) {
            int dst = in.nextInt();
            int src = in.nextInt();
            List<Integer> list = adjMap.getOrDefault(src, new ArrayList<>());
            list.add(dst);
            adjMap.put(src, list);
            inDegree[dst]++;
        }

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                indep.add(i);
            }
        }

        int idx = 0;
        int days = 0;
        while (!indep.isEmpty()) {
            System.out.println(indep);
            List<Integer> neighbors = new ArrayList<>();
            for (int i = 0; i < n && !indep.isEmpty(); i++) {
                int node = indep.remove(0);
                order[idx++] = node;
                neighbors.addAll(adjMap.getOrDefault(node, new ArrayList<>()));
            }
            for (int neighbor : neighbors) {
                if (--inDegree[neighbor] == 0) {
                    indep.add(neighbor);
                    indep.sort(Comparator.comparingInt(num -> num));
                }
            }
            days++;
        }

        if (idx == m) {
            System.out.println(days);
        } else {
            System.out.println("E");
        }
    }

}
