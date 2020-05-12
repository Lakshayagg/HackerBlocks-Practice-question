package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxAreaHistogram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(histogramRectangle(a));
    }

    public static int histogramRectangle(int[] in) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < in.length;) {
            if (stack.isEmpty() || in[stack.peekFirst()] <= in[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    area = in[top] * i;
                } else {
                    area = in[top] * (i - stack.peekFirst() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                area = in[top] * i;
            } else {
                area = in[top] * (i - stack.peekFirst() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
