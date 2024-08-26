package sliddingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsintoBaskets {

    public static int fruitsIntoBaskets(char[] input, int k){
        int startWindow = 0;
        int endWindow = 0;
        int result = 0;
        Map<Character,Integer> charMap = new HashMap<>();
        while (endWindow < input.length) {
            char character = input[endWindow];
            charMap.put(character, charMap.getOrDefault(character, 0) + 1);
            while (charMap.size()>k) {
                char charToRemove = input[startWindow++];
                charMap.put(charToRemove, charMap.get(charToRemove)-1);
                if(charMap.get(charToRemove) ==0){
                    charMap.remove(charToRemove);
                }
            }
            result = Math.max(result, endWindow - startWindow + 1);
            endWindow++;
        }
        return result;

    }

    public static void main(String[] args) {
        char[] fruitTree = { 'A', 'B', 'C', 'A', 'C'};
        char[] fruitTree1 = { 'A', 'B', 'C', 'B', 'B', 'C'};

        System.out.println(fruitsIntoBaskets(fruitTree1, 2));
        System.out.println(fruitsIntoBaskets(fruitTree, 2));

    }
}
