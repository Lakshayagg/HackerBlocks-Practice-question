package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CompleteTree {
    private Node root;
    private Scanner s = new Scanner(System.in);

    public class Node {
        private int data;        //1 6 2 8 7 4 3 11 -1 9 -1 -1 5 -1 -1 -1 -1 10 -1 -1 -1 -1 -1
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getvalue() {
            return this.data;
        }

        public Node() {
        }
    }

    public void buildtree() {
        int count = 0;
        int d;
        Queue<Node> q = new LinkedList<Node>();
        d = s.nextInt();
        this.root = new Node(d);
        Node cur = root;
        while (true) {
            d = s.nextInt();
            if (d != -1) {
                if (count == 0) {
                    cur.left = new Node(d);
                    count++;
                    q.add(cur.left);
                } else if (count == 1) {
                    cur.right = new Node(d);
                    q.add(cur.right);
                    count = 0;
                    if (q.peek() != null)
                        cur = q.peek();
                    q.remove();
                }
            } else if (d == -1) {
                if (count == 0)
                    count++;
                else {
                    count = 0;
                    if (q.peek() != null)
                        cur = q.peek();
                    q.remove();
                }


                if (q.isEmpty()) {
                    return;
                }
            }
        }
    }
    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void topView(){
        topView(this.root);
    }
    private void topView(Node node){
        if(node==null){
            return;
        }
        atLastLeft(node.left);
        System.out.print(node.data+" ");
        atLastRight(node.right);
    }
    private void atLastLeft(Node node){
        if(node==null){
            return;
        }
        atLastLeft(node.left);
        System.out.print(node.data+" ");
    }
    private void atLastRight(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        atLastRight(node.right);
    }

    public static void main(String[] args) {
        CompleteTree tree = new CompleteTree();
        tree.buildtree();
//        tree.display();
        tree.topView();
    }
}

