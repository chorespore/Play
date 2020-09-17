package main;

public class PuyangFormat {
    public static void main(String[] args) {
        String[][] info = {
                {"CFWH", "字符串型", "500", "查封文号"},
                {"发证机关名称", "字符串型", "108", "河南省"},
                {"NAME（中文名称）", "字符串型", "4000", ""}
        };

        for (String[] item : info) {
            String title = item[0];
            String regexEn = "^[a-zA-Z]+$";
            String regexEnZh = "^[a-zA-Z]+[（\\(][^a-zA-Z]+[\\)）]$";

            if (title.matches(regexEn)) {
                System.out.println("ALL EN: " + title);
            } else if (title.matches(regexEnZh)) {
                int cutpoint = title.indexOf("（");
                String name = title.substring(0, cutpoint++);
                String remark = title.substring(cutpoint, title.length() - 1);
                System.out.println(name + "----" + remark);
            } else {
                System.out.println("ALL ZH: " + title);
            }
        }
    }
}
