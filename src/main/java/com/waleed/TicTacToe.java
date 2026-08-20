package com.waleed;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=== Welcome to Tic Tac Toe! ===");
    }
}