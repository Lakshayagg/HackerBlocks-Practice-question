package com.company;

import java.util.Scanner;

public class StrongestFighter {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]= s.nextInt();
        }
        int k= s.nextInt();
        for(int i=0;i<=n-k;i++){
            int max = maxVal(a,i,k);
            System.out.print(max+" ");
        }

    }
    public static int maxVal(int[] a,int i,int k){
        int max = a[i];
        for(int j=i+1;j<i+k && j<a.length;j++){
            if(max<a[j]){
                max = a[j];
            }
        }
        return max;
    }
}
