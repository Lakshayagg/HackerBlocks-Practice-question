package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for (int l = 0; l < t; l++) {
            int n = s.nextInt();
            int[] arr = new int[n];
            String str = new String();
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
                str+=arr[i];
            }
            System.out.println(str);
            ArrayList list = permutelist("",str);
            System.out.println(list);
            Collections.sort(list);
            int index = list.indexOf(str);
            Object x=   list.get(index+1);
            int i = Integer.valueOf((String) x);
            System.out.println(i);
            while(i>0){
                System.out.println(i%10);
                i=i/10;
            }
        }
    }
    public static ArrayList permutelist(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList list = new ArrayList();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList list = new ArrayList();
        unprocessed=unprocessed.substring(1);
        for (int i = 0; i <=processed.length() ; i++) {
            String first =processed.substring(0,i);
            String second = processed.substring(i);
            list.addAll(permutelist(first+ch+second,unprocessed));
        }
        return list;
    }
}
