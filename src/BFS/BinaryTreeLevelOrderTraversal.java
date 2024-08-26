package BFS;

import FastPointer.LinkedListCycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


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

    static List<List<Integer>> levelOrderTraversal(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> currentLEvel = new ArrayList<>();
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                currentLEvel.add(treeNode.value);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            result.add(currentLEvel);
        }
        return result;
    }

    static Integer minimumDepth(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int minimumDepth = 0;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                if(treeNode.left == null && treeNode.right == null){
                    return minimumDepth;
                }
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            minimumDepth++;
        }
        return minimumDepth;
    }


    static Integer levelOrderSuccessor(TreeNode node, int k){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean nodeFound = false;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                if (nodeFound){
                    return treeNode.value;
                }
                if(treeNode.value == k){
                    nodeFound = true;
                }
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
        }
        return -1;
    }

    static List<Double> average(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            double sum = 0;
            double count = 0;
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                sum += treeNode.value;
                count++;
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            double avg = sum/count;
            result.add(avg);
        }
        return result;
    }

    static List<List<Integer>> reverseLevelOrderTraversal(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> currentLEvel = new ArrayList<>();
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                currentLEvel.add(treeNode.value);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            result.add(0,currentLEvel);
        }
        return result;
    }

    static List<Integer> rightView(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> currentLEvel = new ArrayList<>();
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                if(i == (queueSize-1)){
                    result.add(treeNode.value);
                }
                currentLEvel.add(treeNode.value);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
        }
        return result;
    }

    static List<List<Integer>> zigzag(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(node);
        int level = 1;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> currentLEvel = new ArrayList<>();
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                if(level%2 == 1){
                    currentLEvel.add(treeNode.value);
                } else {
                    currentLEvel.add(0,treeNode.value);

                }
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }

            }
            level++;
            result.add(currentLEvel);
        }
        return result;
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("" + levelOrderTraversal(root));
        System.out.println("" + reverseLevelOrderTraversal(root));
        System.out.println("" + zigzag(root));
        System.out.println("" + average(root));
        System.out.println("" + minimumDepth(root));
        System.out.println("" + levelOrderSuccessor(root, 3));
        System.out.println("" + rightView(root));


    }
}
