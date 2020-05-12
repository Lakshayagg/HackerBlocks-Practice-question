package com.company;

import java.util.Scanner;

public class GenerateParantheises {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        printParentheises(n);
    }

    private static void printParentheises(int n) {
        validParentheises(n / 2, n / 2, "");
    }

    private static void validParentheises(int i, int j, String s) {
        if (i == 0 && j == 0) {
            System.out.println(s);
        }
        if (i > j) {
            return;
        }
        if (i > 0) {
            validParentheises(i - 1, j, s + "(");
        }
        if (j > 0) {
            validParentheises(i, j - 1, s + ")");
        }
    }
}
