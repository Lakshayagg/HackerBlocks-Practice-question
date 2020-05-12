package com.company;

import java.util.Scanner;

public class FactorialProblem {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int j = 0; j < t; j++) {
            int n = s.nextInt();
            int k = s.nextInt();
            System.out.println(findPowerComposite(n,k));
//            int res = 0;
//            int i = 1;
//            while (Math.pow(k, i) <= n) {
//                res += n / Math.pow(k, i);
//                i++;
//            }
//            System.out.println(res);
        }
    }

    static int findPowerPrime(int fact, int p) {
        int res = 0;
        while (fact > 0) {
            res += fact / p;
            fact /= p;
        }
        return res;
    }
    static int findPowerComposite(int fact, int n) {
        int res = Integer.MAX_VALUE;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int count = 0;
            if (n % i == 0) {
                count++;
                n = n / i;
            }
            if (count > 0) {
                int curr_pow = findPowerPrime(fact, i) / count;
                res = Math.min(res, curr_pow);
            }
        }
        if (n >= 2) {
            int curr_pow = findPowerPrime(fact, n);
            res = Math.min(res, curr_pow);
        }
        return res;
    }
}
