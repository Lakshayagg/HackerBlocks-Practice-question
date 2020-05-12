package com.company;

import java.util.Scanner;

public class LL_K_Append {
    private class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LL_K_Append() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LL_K_Append(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    // O(1)
    public int size() {
        return this.size;
    }

    // O(1)
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // O(1)
    public void addLast(int data) {
        Node node = new Node(data, null);
        if (this.size() == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    // O(n)
    public void display() {
        Node node = this.head;
        int n = this.size();
        System.out.println(n);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        //System.out.println("END");
    }

    public void appendlastn(int k) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }
        int n = this.size();
        Node a = this.head;
        Node b = this.head;
        int i = 0;
        k = k % n;
        int ok = n - k - 1;
        while (a != null && i < ok) {
            a = a.next;
            i++;
        }
        this.tail = a;
        Node c = a.next;
        this.head = c;
        a.next = null;
        while (c.next != null) {
            c = c.next;
        }
        c.next = b;
    }

    public void reverse() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is Empty");
        }
        Node prev = null;
        Node current_node = this.head;

        while (current_node != null) {
            Node Next_Node = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = Next_Node;
        }
        this.head = prev;
    }

    public Node reverse(Node node) {
        if (this.isEmpty()) {
            return node;
        }
        Node prev = null;
        Node current_node = node;

        while (current_node != null) {
            Node Next_Node = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = Next_Node;
        }
        node = prev;
        return node;
    }

    public boolean isPallindrom(){
        if(this.isEmpty()){
            return true;
        }
        Node a = this.head;
        Node b =reverse(a);
        int n=this.size();
        for (int i = 0; i < n/2; i++) {
            if(a.data != b.data)
                return false;
        }
        return true;
    }

    public Node kReverse(Node node, int k) {
        if (head == null) {
            return node;
        }
        Node current = node;
        Node prev = null;
        Node next = null;
        int i = 0;
        while (i < k && node != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        if (next != null) {
            node.next = kReverse(next, k);
        }
        return prev;
    }

    public void kReverse(int k) {
        this.head = kReverse(this.head, k);
    }

    public void evenAfterOdd() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is Empty");
        }
        int cnta = 0;
        int cntb = 0;
        Node c = this.head;
        Node a = null;
        Node b = null;
        while (c != null) {
            if (c.data % 2 != 0) {
                a = c;
                break;
            }
            c = c.next;
        }
        while (c != null) {
            if (c.data % 2 == 0) {
                b = c;
                break;
            }
            c = c.next;
        }
        Node tempB = null;
        if (b != null) {
            tempB = b;
            cntb++;
        }
        Node tempA = null;
        if (b != null) {
            tempA = a;
            cnta++;
        }
        c = this.head;
        while (c != null) {
            if (c.data % 2 == 0) {
                if(cnta==1){
                    cnta++;
                }else{
                    b.next = c;
                    b = b.next;
                }
            } else {
                if(cntb == 1) {
                    cntb++;
                }else{
                    a.next = c;
                    a = a.next;
                }
            }
            c = c.next;
        }

        b.next = null;
        if(tempA == null){
            this.head = tempB;
        }else if(tempB==null){
            a.next = null;
            this.head = tempA;
        }else{
            a.next = tempB;
            this.head = tempA;
        }
    }
    public int getLast(int k){
        return getLast(this.head,k);
    }

    private int getLast(Node node,int k){
        if(node == null){
            return -1;
        }
        int x = this.size();
        for(int i=0;i<x-k;i++){
            node = node.next;
        }
        return node.data;
    }

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int N = 9;
        //int M = scn.nextInt();


        LL_K_Append list = new LL_K_Append();
        int i;
        for ( i = 1; i <= N; i++) {
            list.addLast(i);
        }
//        int n = scn.nextInt();
//        list.appendlastn(n);
//        list.display();
//        System.out.println();
//        list.reverse();
//        list.display();

//        list.kReverse(3);
//        list.display();

//        list.evenAfterOdd();
//        list.display();

//        for ( i = N; i < 2*N; i++) {
//            list.addLast(2*N-i);
//        }
//        list.display();
//        System.out.println(list.isPallindrom());

        Scanner s = new Scanner(System.in);
        while(true){
            int n= s.nextInt();
            if(n== -1){
                break;
            }
            list.addLast(n);
        }
        int k = s.nextInt();
        int mm = list.getLast(k);
        System.out.println(mm);
    }
//    public void insertionSort(){
//        insertionSort(this.head);
//    }
//    private void insertionSort(Node node){
//        if(node == null){
//            return;
//        }
//        Node curr = node;
//        Node sorted = null;
//        Node next_node  = node.next;
//        while(curr!=null){
//            if(sorted.data > next_node.data || sorted == null){
//                  next_node.next = sorted;
//                  sorted = next_node;
//            }else{
//               Node  current= sorted;
//                while(current.next != null && current.next.data < next_node.data){
//                    current = current.next;
//                }
//                next_node.next = current.next;
//                current.next = next_node;
//            }
//        }
//
//        this.head = node;
//    }
}


