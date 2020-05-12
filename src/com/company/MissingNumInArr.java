package com.company;

import java.util.Scanner;

public class MissingNumInArr {
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int j=0;j<t;j++){
            int n = s.nextInt();
            int[] a = new int[n-1];
            for(int i=0;i<n-1;i++){
                a[i] = s.nextInt();
            }
            int p=0;
            for(int i=0;i<n-2;i++){
                if(a[i]+2==a[i+1]){
                    p=a[i]+1;
                    break;
                }
            }

            System.out.println(p);

        }

    }
}
