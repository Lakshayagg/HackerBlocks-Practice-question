package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutArray {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int j = 0; j < t; j++) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            nextPermut(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void nextPermut(int[] arr) {
        if (arr.length <= 1)
            return;
        int last = arr.length - 2;
        while (last >= 0) {
            if (arr[last] < arr[last + 1]) {
                break;
            }
            last--;
        }
        if (last < 0) {
            arr = reverse(arr, 0, arr.length - 1);
            return;
        }
        int next_greater = arr.length - 1;
        for (int i = arr.length - 1; i > last; i--) {
            if (arr[i] > arr[last]) {
                next_greater = i;
                break;
            }
        }
        int temp = arr[last];
        arr[last] = arr[next_greater];
        arr[next_greater] = temp;
        arr = reverse(arr, last + 1, arr.length - 1);

    }

    public static int[] reverse(int data[], int left, int right) {
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }
        return data;
    }

}
