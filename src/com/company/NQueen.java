package com.company;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int count = nQueen(board, 0);
        System.out.println();
        System.out.println(count);
    }

    public static int nQueen(boolean[][] board, int row) {
        int count =0;
        if (row == board.length) {
            printQueenBoard(board);
            return 1;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueen(board, row + 1);
                board[row][col] = false;
            }

        }
        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        //  for left diagonal
        int left = Math.min(row, col);
        for (int i = 0; i <= left; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        //for right diagonal
        int right = Math.min(row, board.length - col - 1);
        for (int i = 0; i <= right; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    public static void printQueenBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    System.out.print("{"+i+","+j+"} ");
                }
            }
        }
        System.out.print(" ");
    }
}
