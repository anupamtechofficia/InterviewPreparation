package DFS;

import BFS.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreePathSum {

    static public class Result{
        int result;
    }

    static public class TreeNode{
        int value;
        TreeNode left;

        TreeNode right;

        TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static boolean binaryTreePathSum(TreeNode node, int currentSum, int sum){
        int latestSum = currentSum + node.value;
        if(node.left == null && node.right == null && latestSum == sum){
            return true;
        }
        boolean leftPathPossible = false;
        if(node.left !=  null){
            leftPathPossible = binaryTreePathSum(node.left ,  latestSum ,  sum);
        }

        if(!leftPathPossible && node.right != null){
            leftPathPossible =  binaryTreePathSum(node.right , latestSum, sum);
        }
        return leftPathPossible;
    }

    static List<List<Integer>> AllBinaryTreePathSum(TreeNode node, int currentSum, int sum){
        int latestSum = currentSum + node.value;
        List<List<Integer>> result = new ArrayList<>();
        if(node.left == null && node.right == null && latestSum == sum){
            List<Integer> ans = new ArrayList<>();
            ans.add(node.value);
            result.add(ans);
            return result;
        }
        if(node.left !=  null){
            List<List<Integer>> resultLeft = AllBinaryTreePathSum(node.left ,  latestSum ,  sum);
            for (List<Integer> list : resultLeft){
                list.add(0, node.value);
                result.add(list);
            }
        }

        if(node.right != null){
            List<List<Integer>> resultRight =  AllBinaryTreePathSum(node.right , latestSum, sum);
            for (List<Integer> list : resultRight){
                list.add(0, node.value);
                result.add(list);
            }
        }
        return result;
    }

    static int sumOfPathNumbers(TreeNode node, int pathSum){
        int CurrentPathSum = pathSum * 10 + node.value;
        if(node.left == null && node.right == null){
            return CurrentPathSum;
        }
        int sum = 0;
        if(node.left !=  null){
            sum += sumOfPathNumbers(node.left, CurrentPathSum);
        }

        if(node.right != null){
            sum +=  sumOfPathNumbers(node.right, CurrentPathSum);
        }
        return sum;
    }

    static boolean pathWithGivenSequence(TreeNode node, int index, int[] seq){
        if(index >= seq.length || seq[index] !=  node.value){
            return false;
        }
        if(node.left == null && node.right == null && seq[index] ==  node.value){
            return true;
        }
        return pathWithGivenSequence(node.left , index + 1, seq) ||
                pathWithGivenSequence(node.right , index + 1, seq);
    }

    static int CountPathsForSum(TreeNode node, AtomicInteger count){
        if(node.left == null && node.right == null){
            return node.value;
        }
        int leftSum = node.value;
        int rightSum = node.value;
        if(node.left !=  null){
            leftSum += CountPathsForSum(node.left, count);
        }

        if(node.right != null){
            rightSum +=  CountPathsForSum(node.right, count);
        }

        return Math.min(rightSum,leftSum);
    }

    static int diameter(TreeNode node, Result result){
        if(node.left == null && node.right == null){
            return 1;
        }
        int leftDiameter = 0;
        int rightDiameter = 0;
        if(node.left !=  null){
            leftDiameter += diameter(node.left, result);
        }

        if(node.right != null){
            rightDiameter +=  diameter(node.right, result);
        }
        result.result = Math.max(result.result, leftDiameter+rightDiameter+1);

        return Math.max(leftDiameter,rightDiameter) +1;
    }

    static int maxSum(TreeNode node, Result result){
        if(node.left == null && node.right == null){
            return node.value;
        }
        int leftSum = 0;
        int rightSum = 0;
        if(node.left !=  null){
            leftSum = maxSum(node.left, result);
        }

        if(node.right != null){
            rightSum =  maxSum(node.right, result);
        }
        int maxChildSum = Math.max(leftSum, rightSum);
        result.result = Math.max(Math.max(result.result, maxChildSum), leftSum+rightSum+node.value);

        return maxChildSum + node.value;
    }

    public static void main(String[] args) {

        /*

                1
             7     9
           4   5 2   7

         */
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        System.out.println("" + binaryTreePathSum(root, 0, 12));
        System.out.println("" + AllBinaryTreePathSum(root, 0, 12));
        System.out.println("" + sumOfPathNumbers(root, 0));
        int[] seq = {1,7,5};
        System.out.println("" + pathWithGivenSequence(root, 0, seq));
        Result result = new Result();
        result.result = 0;
        diameter(root, result);
        System.out.println("" + result.result);

        Result result1 = new Result();
        result1.result = 0;
        maxSum(root, result1);
        System.out.println("" + result1.result);

    }

    
}
