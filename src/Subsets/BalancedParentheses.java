package Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedParentheses {

    static class Parentheses{
        int openCount;
        int closeCount;
        String parentheses;

        Parentheses(){
            this.parentheses = "";
            this.openCount = 0;
            this.closeCount = 0;
        }
        Parentheses(Parentheses current, Boolean open){
            if(open){
                parentheses = current.parentheses + "(";
                this.openCount = current.openCount +1;
                this.closeCount = current.closeCount;
            } else {
                parentheses = current.parentheses + ")";
                this.closeCount = current.closeCount +1;
                this.openCount = current.openCount;
            }
        }
    }

    public static List<String> balancedParentheses(int  size){
        List<String> result = new ArrayList<>();
        Queue<Parentheses> queue = new LinkedList<>();
        queue.add(new Parentheses());
        while (!queue.isEmpty()){
            Parentheses current = queue.poll();
            if((current.closeCount + current.openCount) == size*2){
                result.add(current.parentheses);
            } else {
                if(current.openCount > current.closeCount){
                    Parentheses newParent = new Parentheses(current, Boolean.FALSE);
                    queue.add(newParent);
                }
                if(current.openCount< size){
                    Parentheses newParent = new Parentheses(current, Boolean.TRUE);
                    queue.add(newParent);
                }

            }
        }
        return result;
    }

    public static void main(String ... s){
        System.out.println(balancedParentheses(2));

    }
}
