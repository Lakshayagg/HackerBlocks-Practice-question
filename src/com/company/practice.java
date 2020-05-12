package com.company;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n=s.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]= s.nextInt();
        }
        System.out.println(optimal(a,0,n-1));
    }

    private static long optimal(int[] a, int i, int n) {
         if(i>n){
             return 0;
         }
         long left =a[i]+ Math.min(optimal(a,i+2,n),optimal(a,i+1,n-1));
         long right =a[n]+Math.min(optimal(a,i,n-2),optimal(a,i+1,n-1));
         long ans = Math.max(left,right);
         return ans;
    }

}

//26 2396 25316 30085 23080 10269 5711 8306 11536 19092 6816 6305 23649 32583 5585 14193 14859 30265
// 18026 5528 16126 15212 25591 14789 3900 31395 25529
