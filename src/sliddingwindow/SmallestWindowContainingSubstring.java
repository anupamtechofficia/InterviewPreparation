package sliddingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

    public static String smallestWindowContainingSubstring(String input, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        int startIndex = 0;
        int endIndex = 0;
        int matched = 0;
        int rs =0, re  = 0;
        int min = input.length();
        while (endIndex < input.length()) {
            if (patternMap.containsKey(input.charAt(endIndex))) {
                patternMap.put(input.charAt(endIndex), patternMap.get(input.charAt(endIndex)) - 1);
                if (patternMap.get(input.charAt(endIndex)) == 0) {
                    matched++;
                }
            }
            while (startIndex < endIndex && patternMap.getOrDefault(input.charAt(startIndex), -1) < 0) {
                if (patternMap.getOrDefault(input.charAt(startIndex), 0) < 0) {
                    patternMap.put(input.charAt(startIndex), patternMap.get(input.charAt(startIndex)) + 1);
                }
                startIndex++;
            }
            if (matched == patternMap.size() && min > (endIndex-startIndex+1)) {
                min = endIndex-startIndex+1;
                rs = startIndex;
                re = endIndex;
            }
            endIndex++;
        }

        return input.substring(rs, re+1);
    }

    public static void main(String[] args) {

        System.out.println(smallestWindowContainingSubstring("aabdec", "abc"));
        System.out.println(smallestWindowContainingSubstring("abdabca", "abc"));
        System.out.println(smallestWindowContainingSubstring("adcad", "abc"));
    }
}
