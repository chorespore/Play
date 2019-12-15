package main;

public class FetchBalls {
    public static void main(String[] args) {
        int res = fetch(10);
        System.out.println(res);
    }

    public static int fetch(int n) {
        if (n <= 2) {
            return n;
        }
        return fetch(n - 1) + fetch(n - 2);
    }
}
