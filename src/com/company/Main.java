package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;

        Scanner s = new Scanner(System.in);
        n=s.nextInt();
        int t=0;
        while(n>0){
            int i=n%10;
            n=n/10;
            t=t+i*10;
        }
            System.out.println(t);
        
    }
}
