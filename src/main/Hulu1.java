package main;

import java.util.Scanner;

public class Hulu1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			boolean no = true;
			int m = in.nextInt();
			int n = in.nextInt();
			for (int i = m; i <= n; i++) {
				int sum = 0;
				int digits = i;
				while (digits > 0) {
					sum += Math.pow(digits % 10, 3);
					digits /= 10;
				}
				if (sum == i) {
					System.out.print(sum + " ");
					no = false;
				}
			}
			if (no) {
				System.out.println("no");
			}
		}
	}
}