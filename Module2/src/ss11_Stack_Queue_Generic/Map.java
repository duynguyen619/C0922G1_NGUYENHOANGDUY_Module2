package ss11_Stack_Queue_Generic;

import java.util.HashMap;
import java.util.Set;

public class Map {
    public static void main(String[] args) {
        String str = "hello words hello words duy";
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        String key;
        Integer value;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            key = s;
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }

        Set<String> set = map.keySet();

        for (String s : set) {
            key = s;
            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
        }
    }
}
