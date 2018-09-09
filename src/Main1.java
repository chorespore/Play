import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            double sum = 0;
            double root = n;
            for (int i = 0; i < m; i++) {
                sum += root;
                root = Math.sqrt(root);
            }
            System.out.println(String.format("%.2f", sum));
        }

    }
}
