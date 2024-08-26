package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllLevelOrderSiblings {

    static public class TreeNode{
        int value;
        TreeNode left;

        TreeNode right;

        TreeNode sib;

        TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.sib = null;
        }
    }
    
    public static void connectAllLevelOrderSiblings(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode past = null;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0;i< queueSize;i++){
                TreeNode treeNode = queue.poll();
                if(past!=null){
                    past.sib = treeNode;
                }
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
                past = treeNode;
            }
        }
    }

    public static void printSib(TreeNode root){
        TreeNode temp = root;
        while (temp!=null){
            System.out.println(temp.value);
            temp = temp.sib;
        }
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        connectAllLevelOrderSiblings(root);
        printSib(root);
    }
}
