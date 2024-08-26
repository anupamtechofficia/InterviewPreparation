package Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DistinctSubsets {

    public static List<List<Integer>> getDistinctSubsets(List<Integer> set){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i =0 ;i< set.size() ; i++){
            int size = result.size();
            for (int j = 0 ;j< size;j++){
                List<Integer> newSet = new ArrayList<>(result.get(j));
                newSet.add(set.get(i));
                result.add(newSet);
            }
        }
        return result;
    }

    public static List<String> UniqueGeneralizedAbbreviations(String set){
        Queue<String> result = new LinkedList<>();
        List<String> finalValue = new ArrayList<>();
        result.add("");
        for (int i =0 ;i< set.length() ; i++){
            int size = result.size();
            for (int j = 0 ;j< size;j++){
                String word = result.poll();
                String word1  = word + set.charAt(i);
                String word2;
                char[] seq = word.toCharArray();
                if(seq.length>0 && Character.isDigit(seq[seq.length-1])){
                    seq[seq.length-1] = (char)((int)seq[seq.length-1] + 1);
                    word2 = new String(seq);
                } else {
                    word2 = word + "1";
                }
                if(i == set.length()-1){
                    finalValue.add(word1);
                    finalValue.add(word2);
                } else {
                    result.add(word1);
                    result.add(word2);
                }
            }
        }
        return finalValue;
    }

    public static List<List<Integer>> getDistinctSubsetsWithDuplicates(List<Integer> set){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int startIndex = 0;
        for (int i =0 ;i< set.size() ; i++){
            int startPoint = 0;
            if(i>0 && set.get(i).equals(set.get(i-1))){
                startPoint = startIndex;
            }
            int size = result.size();
            startIndex = size;
            while (startPoint< size){
                    List<Integer> newSet = new ArrayList<>(result.get(startPoint));
                    newSet.add(set.get(i));
                    result.add(newSet);
                    startPoint++;
            }

        }
        return result;
    }

    public static List<List<Integer>> permute(List<Integer> set){
        Queue<List<Integer>> temp = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        temp.add(new ArrayList<>());
        for (int i =0 ;i< set.size() ; i++){
            int size = temp.size();
            for (int j = 0 ;j< size;j++){
                List<Integer> per = temp.poll();
                for (int k=0;k<= per.size();k++){
                    List<Integer> newSet = new ArrayList<>(per);
                    newSet.add(k, set.get(i));
                    if(newSet.size() == set.size()){
                        result.add(newSet);
                    } else {
                        temp.add(newSet);
                    }
                }
            }
        }
        return result;
    }

    public static List<String> PermutationsByChangingCase(String value){
        List<String> result = new ArrayList<>();
        result.add(value);
        for (int i =0 ;i< value.length() ; i++){
            int size = result.size();
            for (int j = 0 ;j< size;j++){
                StringBuilder prev = new StringBuilder(result.get(j));
                int charValue = prev.charAt(i);
                int upperValue = 'A';
                if(charValue>= 'a' && charValue <='z'){
                    char asciiUp = (char) (charValue - 'a' + upperValue);
                    prev.replace(i,i+1, ""+asciiUp);
                    result.add(prev.toString());
                }
            }
        }
        return result;
    }

    public static void main(String ... s){
       List<Integer> set = List.of(1,5,3);
       System.out.println(getDistinctSubsets(set));
        List<Integer> set1 = List.of(1,3,3);
        System.out.println(getDistinctSubsetsWithDuplicates(set1));
        List<Integer> set2 = List.of(1, 5, 3, 3, 3);
        System.out.println(getDistinctSubsetsWithDuplicates(set2));
        List<Integer> set3 = List.of(1, 2, 3);
        System.out.println(permute(set3));
        System.out.println(PermutationsByChangingCase("ab7c"));
        System.out.println(UniqueGeneralizedAbbreviations("code"));

    }
}
