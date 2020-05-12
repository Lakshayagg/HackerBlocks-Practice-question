package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class sieveOfEratosthenes {
    static int max = 10000005;
    static ArrayList list = new ArrayList();
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        sieveOfEratosthenes();
        System.out.println(list.get(n-1));
    }
    public static void sieveOfEratosthenes(){
        boolean[] prime = new boolean[max];
        for(int i=0;i<max;i++){
            prime[i] = true;
        }
        for(int i=2;i*i<max;i++){
            if(prime[i] == true){
                for(int j=i*i;j<max;j+=i){
                    prime[j]=false;
                }
            }
        }
        for(int i=2;i<max;i++){
            if(prime[i] == true)
                list.add(i);
        }
    }
}
