package TopK;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static java.util.Map.entry;

public class RearrangeString {

    static String rearrangeString(String strK) {
        Integer result = 0;

        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < strK.length(); i++) {
            count.put(strK.charAt(i), count.getOrDefault(strK.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(count.size(), new Comparator<
                Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.add(entry);
        }
        StringBuilder builder = new StringBuilder("");
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                Map.Entry<Character, Integer> peek1 = pq.poll();
                if (peek1.getValue() > 1) {
                    builder  = new StringBuilder("");
                    return builder.toString();
                } else {
                    builder.append(peek1.getKey());
                }

            } else {
                Map.Entry<Character, Integer> peek1 = pq.poll();
                Map.Entry<Character, Integer> peek2 = pq.poll();
                builder.append(peek1.getKey() + "" + peek2.getKey());
                if (peek1.getValue() > 1) {
                    pq.add(entry(peek1.getKey(), peek1.getValue() - 1));
                }
                if (peek2.getValue() > 1) {
                    pq.add(entry(peek2.getKey(), peek2.getValue() - 1));
                }}

        }
        return builder.toString();

    }


    public static void main(String... s) {
        System.out.println(rearrangeString("aappp"));
        System.out.println(rearrangeString("Programming"));
        System.out.println(rearrangeString("aapa"));
    }
}
