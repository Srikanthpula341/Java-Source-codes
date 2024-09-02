package com.sri.practise;



class Tree {
    int value;
    Tree left , right;

    public Tree (int data){
        this.value = data;
        left = right = null;
    }
}
public class BinaryTreeTest {

    Tree root;

   public static void main(String[] args) {
    
       BinaryTreeTest bt = new BinaryTreeTest();
       bt.root = new Tree(1);

       bt.root.left = new Tree(2);
       bt.root.right = new Tree(3);

       bt.root.left.left = new Tree(4);
       bt.root.left.right = new Tree(5);

       bt.root.right.left = new Tree(6);
       bt.root.right.right = new Tree(7);

       bt.root.left.left.left = new Tree(8);
       bt.root.left.left.right = new Tree(9);

       bt.root.left.right.left = new Tree(10);
       bt.root.left.right.right = new Tree(11);

       bt.root.right.left.left = new Tree(12);
       bt.root.right.left.right = new Tree(13);

       bt.root.right.right.left = new Tree(14);
       bt.root.right.right.right = new Tree(15);

       bt.root.left.left.left.left = new Tree(16);
       bt.root.left.left.left.right = new Tree(17);

       bt.root.left.left.right.left = new Tree(18);
       bt.root.left.left.right.right = new Tree(19);

       bt.root.left.right.left.left = new Tree(20);
       bt.root.left.right.left.right = new Tree(21);

       bt.root.left.right.right.left = new Tree(22);
       bt.root.left.right.right.right = new Tree(23);

       bt.root.right.left.left.left = new Tree(24);
       bt.root.right.left.left.right = new Tree(25);
   }

   public int getWidth (Tree node ){

    if(node == null){
        return 0;
    }

    int left = getWidth(node.left);
    int right = getWidth(node.right);

    return Math.max(left, right)+1;

   }

   public int getHeight(Tree node) {

       if (node == null) {
           return 0;
       }

       int left = getHeight(node.left);
       int right = getHeight(node.right);

       return Math.max(left, right) + 1;

   }
    
    
}
