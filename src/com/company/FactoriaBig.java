package com.company;

public class FactoriaBig {
    public static void main(String[] args) {
        fact(5);
    }
    static void fact(int x){
        int[] a = new int[500];
        a[0]=1;
        int resize = 1;
        for(int i=2;i<=x;i++){
            resize = multiply(i,a,resize);
        }
        for(int i=resize-1;i>=0;i--){
            System.out.print(a[i]);
        }
    }
    static int multiply(int x,int a[],int resize){
        int carr = 0;
        for(int i=0;i<resize;i++){
            int pro = a[i]*x+carr;
            a[i] = pro%10;
            carr = pro/10;
        }
        while(carr!=0){
            a[resize] = carr%10;
            carr = carr/10;
            resize++;
        }
        return resize;
    }
}
