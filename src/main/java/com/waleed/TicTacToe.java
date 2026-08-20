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

    /*
    Reset the game board back to initial state
     */
    public static void resetBoard() {
        char count = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = count++;
            }
        }
    }

    /*
    Display the current state of the game board
     */
    public static void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++ ) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++ ) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}