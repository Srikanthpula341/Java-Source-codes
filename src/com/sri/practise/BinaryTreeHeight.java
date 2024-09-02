package com.sri.practise;


class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item){
        value = item;
        left = right = null;
    }
}
public class BinaryTreeHeight {
    TreeNode root;



    public int getHeight (TreeNode node){
        if(node ==null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        // leftHeight++;
        // rightHeight++;
        if(leftHeight>rightHeight){
            return ++leftHeight;
        }else{
            return ++rightHeight;
        }
        //System.out.println(leftHeight + " "+rightHeight);
        
        //return Math.max(leftHeight, rightHeight)+1;
    }

    public static void main(String[] args) {

        BinaryTreeHeight  tree = new BinaryTreeHeight();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.left = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        //tree.root.left.left.left = new TreeNode(8);

        System.out.println("height of Binary Tree "+ tree.getHeight(tree.root));
        
    }
    
}
