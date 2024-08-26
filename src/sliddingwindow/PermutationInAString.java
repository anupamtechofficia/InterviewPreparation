package sliddingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

   public static boolean permutationInAStringFound(String input, String pattern){
       Map<Character, Integer> mainStringMap = new HashMap<>();
       Map<Character, Integer> patternMap = new HashMap<>();
       for(int i = 0;i< pattern.length();i++){
           patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i),0)+1);
       }
       int startIndex = 0;
       int endIndex = 0;
       while (endIndex< input.length()){
           mainStringMap.put(input.charAt(endIndex), mainStringMap.getOrDefault(input.charAt(endIndex),0)+1);
           endIndex++;
           if(endIndex<pattern.length()){
               continue;
           }
           if(!notFound(mainStringMap, patternMap )){
            return true;
        }
           mainStringMap.put(input.charAt(startIndex), mainStringMap.get(input.charAt(startIndex))-1);
           startIndex++;
       }
       return false;
   }

    public static boolean notFound(Map<Character, Integer> mainStringMap, Map<Character, Integer> patternMap){
        return patternMap.entrySet().stream()
                .anyMatch( entry -> !mainStringMap.getOrDefault(entry.getKey(),0).equals(entry.getValue()));
    }


    public static void main(String[] args) {

        System.out.println(permutationInAStringFound("oidbcaf", "abc"));
        System.out.println(permutationInAStringFound("odicf", "dc"));
        System.out.println(permutationInAStringFound("bcdxabcdy", "bcdyabcdx"));
        System.out.println(permutationInAStringFound("aaacb", "abc"));

    }
}
