package com.company;

import java.util.Scanner;

public class ClassAssignment {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();
            int m=classAss("b", 1, n)+classAss("a", 1, n);
            System.out.println("#"+i+" : "+m);
        }
    }
    public static int classAss(String process,int i,int k){
        int count =0;
        if (k == i) {
            return 1;
        }
        if (process.charAt(i-1) == 'b') {
            count+=classAss(process+"a",i+1,k);
        }

        if (process.charAt(i-1)=='a') {
            count+=classAss(process+'a',i+1,k);
            count+=classAss(process+'b',i+1,k);
        }
        return count;
    }
}
//10 6 4 2 7 2 8 1 9 7 4