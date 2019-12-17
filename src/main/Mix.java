package main;

import java.util.*;

class Mix {

    static String[] dict = {"1", "2", "12", "22"};
    static Map<String, List<String>> map = new HashMap<>();

    static ArrayList<ArrayList<String>> elements = new ArrayList<ArrayList<String>>();
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String[] words = getWords("122");
        System.out.println(Arrays.toString(words));

    }

    public static String[] getWords(String code) {
        map.put("1", Arrays.asList("a", "b"));
        map.put("2", Arrays.asList("c", "d"));
        map.put("12", Arrays.asList("x"));
        map.put("22", Arrays.asList("y"));

        decompose(code, new ArrayList<String>());

        for (ArrayList<String> el : elements) {
            String[] keys = (String[]) el.toArray(new String[el.size()]);
            mix(keys, 0, "");
        }

        return res.toArray(new String[res.size()]);
    }

    public static void mix(String[] keys, int cur, String item) {
        if (cur == keys.length) {
            res.add(item);
        } else {
            for (String key : map.get(keys[cur])) {
                mix(keys, cur + 1, item + key);
            }
        }
    }

    public static void decompose(String code, ArrayList<String> item) {
        if (code.equals("")) {
            elements.add(new ArrayList<String>(item));
        } else {
            for (String d : dict) {
                if (d.length() <= code.length() && d.equals(code.substring(0, d.length()))) {
                    item.add(d);
                    decompose(code.substring(d.length()), item);
                    item.remove(d);
                }
            }
        }
    }
}