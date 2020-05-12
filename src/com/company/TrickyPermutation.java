package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrickyPermutation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = new String();
        str = s.nextLine();
        ArrayList list = permutelist("",str);
        Object[] objArr = list.toArray();
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for (Object obj: objArr) {
              String ch = (String)obj;
            if(!map.containsKey(ch)){
                map.put(ch,1);
                System.out.println(ch);
            }
        }
    }
    public static ArrayList permutelist(String processed, String unprocessed){
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
