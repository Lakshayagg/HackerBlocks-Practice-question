package com.company;

import java.util.Scanner;

public class MergeKSorted {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int k= s.nextInt();
        int n= s.nextInt();
        int[][] a = new int[k][n];
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                a[i][j] = s.nextInt();
            }
        }
        int[] mrg = new int[n*k];
        if(k>1){
            mrg = merge(a[0],a[1]);
        }
        if(k>2){
            for(int i=2;i<k;i++){
                mrg = merge(a[i],mrg);
            }
        }
        for(int i=0;i<mrg.length;i++){
            System.out.print(mrg[i]+" ");
        }
    }
    public static int[] merge(int a[],int b[]){
        int[] c= new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                c[k++]=a[i++];
            }else{
                c[k++] = b[j++];
            }
        }
        while(i<a.length){
            c[k++] = a[i++];
        }
        while(j<b.length){
            c[k++] = b[j++];
        }
        return c;
    }
}
