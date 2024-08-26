package FastPointer;

import java.util.*;

public class HappyNumber {

     static Set<Integer> map = new HashSet<>();

    public static boolean isHappyNumber(int number){
        int newNumber = number;
        while (!map.contains(newNumber) && newNumber !=1) {
            map.add(newNumber);
            newNumber = findNewNumber(number);
        }
        if (newNumber == 1) return true;
        return false;
    }

    public static boolean isHappyNumber1(int number){
        int slow = number;
        int fast = number;
        while (slow!=1 && fast!=1) {
            slow = findNewNumber(slow);
            fast = findNewNumber(findNewNumber(fast));
            if(slow == fast){
                return false;
            }
        }
        return true;
    }


    public static int findNewNumber(int number){
        int temp = number;
        number = 0;
        while (temp>0){
            int x = temp%10;
            number += x*x;
            temp = temp / 10;
        }
        return number;
    }


    public static void main(String[] args) {
        System.out.println(isHappyNumber1(23));
        System.out.println(isHappyNumber1(12));
        System.out.println(isHappyNumber1(5));
    }

}
