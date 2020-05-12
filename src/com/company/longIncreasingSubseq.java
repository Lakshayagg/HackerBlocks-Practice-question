package com.company;

import java.util.Scanner;

public class longIncreasingSubseq {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = s.nextInt();
        }
        System.out.println(list(ar,n));
    }
    public static int list(int[] ar,int n){
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = 1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(ar[i]>ar[j] && res[i]<res[j]+1){
                    res[i]=res[i]+1;
                }
            }
        }
        int max = res[0];
        for(int i=1;i<n;i++){
            if(max<res[i]){
                max= res[i];
            }
        }
        return max;
    }
}
