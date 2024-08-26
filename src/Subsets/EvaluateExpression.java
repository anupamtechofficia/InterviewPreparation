package Subsets;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {


    public static Integer  UniqueBinarySearchTrees(int startNode, int endNode){ //2,3
        if(startNode>endNode){
            return 1;
        }
        if(startNode==endNode){
            return 1;
        }
        int total = 0;
        for (int i = startNode;i<= endNode;i++){ // i=3
            Integer leftList = UniqueBinarySearchTrees(startNode, i-1);;
            Integer rightList = UniqueBinarySearchTrees(i+1, endNode);;
            total+=(leftList*rightList);
        }
        return total;

    }

    public static Integer  UniqueBinarySearchTrees(int n){ //2,3
        if(n<=1){
            return 1;
        }
        int total = 0;
        for (int i = 1;i<= n;i++){ // i=3
            Integer leftList =UniqueBinarySearchTrees(i-1);;
            Integer rightList = UniqueBinarySearchTrees(n-i);;

            total+=leftList*rightList;
        }
        return total;

    }
    public static List<Integer> evaluateExpression(String expression){
        List<Integer> result = new ArrayList<>();
        if(expression.length()==1){
            Integer value = Integer.parseInt(expression);
            result.add(value);
            return result;
        }
        for (int i = 0;i< expression.length();i++){
            if(!Character.isDigit(expression.charAt(i))){
                List<Integer> leftList = evaluateExpression(expression.substring(0, i));
                List<Integer> rightList = evaluateExpression(expression.substring(i+1));
                for (Integer left: leftList){
                    for (Integer right: rightList){
                        result.add(calculate(left, expression.charAt(i), right));
                    }
                }

            }
        }
        return result;

    }

    public  static Integer calculate(Integer pastValue, char operation , Integer lastValue){
        switch (operation){
            case '+' : return  pastValue + lastValue;
            case '-' : return  pastValue - lastValue;
            case '*' : return  pastValue * lastValue;
            default : return  pastValue / lastValue;
        }
    }

    public static Integer  UniqueBinarySearchTreesRetry(int startNode) {
        if (startNode <= 1) return 1;
        int count = 0;
        for (int i = 1; i <= startNode; i++) {
            count += UniqueBinarySearchTreesRetry(i - 1)*
                    UniqueBinarySearchTreesRetry(startNode - i);
        }
        return count;
    }

    public static Integer  UniqueBinarySearchTreesRDB(int startNode) {
        if(startNode<2) return 1;
        int[] dp = new int[startNode+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=startNode;i++){
            dp[i] = 0;
            int startIndex = 0;
            int endIndex = i-1;
            while(startIndex<endIndex){
                dp[i] += 2* dp[startIndex++]*dp[endIndex--];
            }
            if(startIndex == endIndex){
                dp[i] += dp[startIndex]*dp[endIndex];
            }
        }
        return dp[startNode];
    }



    public static void main(String ... s){
        System.out.println(evaluateExpression("1+2*3"));
        System.out.println(UniqueBinarySearchTrees(1,5));
        System.out.println(UniqueBinarySearchTreesRetry(5));
        System.out.println(UniqueBinarySearchTreesRDB(5));

    }
}
