package inter;

public class Accend {
    static volatile int n = 9;

    public static void main(String[] args) {

        n++;

        int i = 1;
        int j = i++;
        int k = i + ++i * i++;

        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }
}

/**
 * 0 iconst_1
 * 1 istore_1
 * 2 iload_1
 * 3 iinc 1 by 1
 * 6 istore_2
 * 7 iload_1
 * 8 iinc 1 by 1
 * 11 iload_1
 * 12 iload_1
 * 13 iinc 1 by 1
 * 16 imul
 * 17 iadd
 * 18 istore_3
 */
