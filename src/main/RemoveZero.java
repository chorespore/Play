package main;

import java.io.*;
import java.util.Arrays;

public class RemoveZero {


    public static void main(String[] args) throws IOException {
        File file = new File("D:\\all_tables.txt");
        FileReader fileReader = new FileReader(file);//读取文件name
        BufferedReader reader = new BufferedReader(fileReader);//缓冲写入，提供了readline函数，可以按行读取。
        String line = null;
        while ((line = reader.readLine()) != null) {
            int len = line.length();
            if (len > 0) {
                char lastChar = line.charAt(len - 1);
                if ('0' < lastChar && lastChar <= '9') {
                    String[] pair = line.split("\\s+");
                    if (pair.length == 2) {
                        System.out.println(pair[0] + "\t" + pair[1]);
                    }
//                    System.out.printf(pair.length + " ");
//                    System.out.println(line);
//                    System.out.println(Arrays.toString(pair));
                }
            }

        }
    }
}
