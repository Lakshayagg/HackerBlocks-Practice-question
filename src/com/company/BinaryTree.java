package com.company;

import java.util.*;

public class BinaryTree {
    private Node root;
    private Scanner s = new Scanner(System.in);

    public void populate() {
        int val = s.nextInt();
        this.root = new Node(val);
        populate(this.root);
    }

    private void populate(Node node) {
        System.out.println("Add left or not");
        boolean left = s.nextBoolean();
        if (left) {
            System.out.println("Add Value");
            int val = s.nextInt();
            node.left = new Node(val);
            populate(node.left);
        }
        System.out.println("Add right or not");
        boolean right = s.nextBoolean();
        if (right) {
            System.out.println("Add value");
            int val = s.nextInt();
            node.right = new Node(val);
            populate(node.right);
        }
    }

    public boolean exists(int value) {
        return exists(this.root, value);
    }

    private boolean exists(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        return exists(node.left, value) || exists(node.right, value);
    }

    public void mirror() {
        mirror(this.root);
    }

    private void mirror(Node node) {
        if (node == null) {
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public Node find(int value){
        return find(this.root,value);
    }

    private Node find(Node node,int value){
        if(node==null){
            return null;
        }
        if(node.value == value){
            return node;
        }
        Node left = find(node.left,value);
        Node right = find(node.right,value);
        if(left== null){
            return null;
        }
        if(right == null){
            return null;
        }
        return null;
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private int heightOfNode(Node node){
        if(node == null){
            return 0;
        }
        int left = heightOfNode(node.left);
        int right = heightOfNode(node.right);
        return Math.max(left,right)+1;
    }

    public int heightOfNode(){
        return heightOfNode(this.root);
    }

    public int diameterOfTree(){
        return heightOfNode(root.left)+heightOfNode(root.right)+1;
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node node,int min,int max){
        if(node == null){
            return true;
        }
        if(node.value<=min || node.value>=max){
            return false;
        }
        return isBinarySearchTree(node.left,min,node.value) && isBinarySearchTree(node.right,node.value,max);
    }

    public boolean isBalanced() {
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node) {
        if(node == null){
            return true;
        }
        boolean flag = false;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            if(temp.left!=null){
                if(flag==true){
                    return false;
                }
                queue.add(temp.left);
            }else{
                flag = true;
            }
            if(temp.right!=null){
                if(flag==true){
                    return false;
                }
                queue.add(temp.left);
            }else{
                flag = true;
            }
        }
        return true;
    }

    public Node getTreeFromPreIn(int[] pre,int phi,int[] in,int ihi){
        if(phi == 0){
            return null;
        }
        int root = pre[0];
        int index = find(in,root);
        int[] preleft = Arrays.copyOfRange(pre,1,index+1);
        int[] prerigth = Arrays.copyOfRange(pre,index+1,phi);
        int[] inleft = Arrays.copyOfRange(in,0,index);
        int[] inright = Arrays.copyOfRange(in,index+1,ihi);
        Node node = new Node(root);
        node.left = getTreeFromPreIn(preleft,preleft.length,inleft,inleft.length);
        node.right = getTreeFromPreIn(prerigth,prerigth.length,inright,inright.length);
        return node;
    }
    public static int find(int[] nums, int item) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == item) {
            }
            return i;
        }
        return -1;
    }

    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();//tree is 12 true 6 true 23 false true 40 true 21 false false false true 13 false false
        // 1 true 2 true 4 false false true 5 false false true 3 true 6 false false true 7 false false
        tree.populate();
        tree.display();
//        System.out.println();
//        tree.postOrder();
//        System.out.println();
//        tree.preOrder();
//        System.out.println();
//        tree.inOrder();
//        System.out.println();
//        System.out.println(tree.heightOfNode());
//        System.out.println(tree.diameterOfTree());
//        System.out.println(tree.exists(4));
//        System.out.println(tree.find(5));
//        tree.mirror();
//        tree.display();
//        System.out.println(tree.isBinarySearchTree());
//        System.out.println(tree.isBalanced());
//        tree.zigzagdisplay();
           tree.zigzag();
    }

    public void zigzag(){
        zigzag(this.root);
    }
    private void zigzag(Node node){
        if(node == null) {
            return;
        }
        Stack<Node> curr_stack = new Stack<Node>();
        curr_stack.add(node);
        Stack<Node> nextLevel = new Stack<Node>();
        boolean level = true;

        while(!curr_stack.isEmpty()){
            node = curr_stack.pop();
            System.out.print(node.value+" ");
            if(level) {
                if (node.left != null) {
                      nextLevel.push(node.left);
                }
                if(node.right!=null){
                   nextLevel.push(node.right);
                }
            }else{
                if(node.right!=null){
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }
            if(curr_stack.isEmpty()){
                Stack<Node> temp = curr_stack;
                curr_stack = nextLevel;
                nextLevel = temp;
                level = !level;
            }
        }
    }
}
