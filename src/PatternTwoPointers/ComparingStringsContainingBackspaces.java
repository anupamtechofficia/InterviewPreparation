package PatternTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class ComparingStringsContainingBackspaces {

    public static boolean comparingStringsContainingBackspaces(String input, String pattern){
        int index1 = input.length()-1;
        int index2 = pattern.length()-1;
        while (index1>=0 && index2>=0){
            while (input.charAt(index1)=='#') index1 -= getBackslashCount(input, index1) * 2;
            while (pattern.charAt(index2)=='#') index2 -= getBackslashCount(pattern, index2)*2;
            if(input.charAt(index1)!=pattern.charAt(index2)) return false;
            index1--;
            index2--;
        }
        return true;
    }

    public static int getBackslashCount(String string, int index){
        int count = 0;
        while (index>=0){
           if(string.charAt(index)=='#'){
               count++;
           } else{
               break;
           }
           index--;
        }
        return count;
    }


    public static void main(String[] args) {

        System.out.println(comparingStringsContainingBackspaces("xy#z", "xzz#"));
        System.out.println(comparingStringsContainingBackspaces("xy#z", "xyz#"));
        System.out.println(comparingStringsContainingBackspaces("xp#", "xyz##"));
        System.out.println(comparingStringsContainingBackspaces("xywrrmp", "xywrrmu#p"));
        System.out.println(comparingStringsContainingBackspaces("xp#", "xy#z#"));


    }
}
