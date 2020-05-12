package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int k = 0; k < t; k++) {
            int n = s.nextInt();
            int[] st = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                st[i] = s.nextInt();
                end[i] = s.nextInt();
            }
            System.out.println(activitySelection(n, st, end));
        }
    }

    public static int activitySelection(int n, int[] st, int[] end) {
        sort(st, end);
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i] + "-->" + end[i]);
        }
        ArrayList list = new ArrayList();
        list.add(1);
        int k = 0;
        for (int i = 1; i < st.length; i++) {
            if (st[i] >= end[k]) {
                list.add(i + 1);
                k = i;
            }
        }
        return list.size();
    }

    public static void sort(int[] s, int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            temp = s[min_idx];
            s[min_idx] = s[i];
            s[i] = temp;
        }
    }
}

//1 25
//        37 45 75 76 76 91 64 78 10 53 13 24 94 99 89 92 82 84 77 87 65 73 55 77 43 99 32 37 90 95 30 53 97 99 77 91 93 99 13 64 26 51 7 39 31 50 11 14 33 79
