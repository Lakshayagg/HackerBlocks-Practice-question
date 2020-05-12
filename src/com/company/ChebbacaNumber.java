package com.company;

import java.util.Scanner;

public class ChebbacaNumber {
    public static void main(String[] args) {
        long a;
        Scanner s = new Scanner(System.in);
        a = s.nextInt();
        int i=0;
         double m=0;
        while(a>10){
            long q = a%10;
            a=a/10;
            if(q>4){
                q=9-q;
            }
            m = m+ q*Math.pow(10,i);
            i++;
        }
        if(a==9){
            m = m+ a*Math.pow(10,i);
        }else if(a>4){
            a=9-a;
            m = m+ a*Math.pow(10,i);
        }else{
            m = m+ a*Math.pow(10,i);
        }
        long t = (long)m;
        System.out.println(t);
    }
}
