package com.company;

import java.util.Scanner;

public class GCDofArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int res = gcdOfArray(a,n);
        System.out.println(res);
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public static int gcdOfArray(int[] a,int n){
        int result =a[0];
        for (int i = 1; i < n; i++) {
            result = gcd(a[i],result);
            if(result == 1)
                return 1;
        }
        return result;
    }
}
