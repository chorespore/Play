package main;

import medium.Leet210;

import java.util.Arrays;

public class Play {

    public static void main(String[] args) {
        int n = 4;
        int[][] requirment = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        Leet210 solution = new Leet210();
        int[] res = solution.findOrder(n, requirment);
        System.out.println(Arrays.toString(res));

    }

}
