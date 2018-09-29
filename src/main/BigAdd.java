package main;

import java.util.Scanner;

public class BigAdd {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();

		char[] l = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
		char[] s = a.length() > b.length() ? b.toCharArray() : a.toCharArray();

		int diff = l.length - s.length;
		int carry = 0;
		for (int i = l.length - 1; i >= 0; i--) {
			int sum = l[i] - '0' + carry;
			if (i - diff >= 0)
				sum += s[i - diff] - '0';

			l[i] = (char) (sum % 10 + '0');
			carry = sum / 10;
		}

		String res = carry > 0 ? carry + String.valueOf(l) : String.valueOf(l);

		System.out.println(res);

	}

}
