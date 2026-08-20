package com.waleed;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

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
        System.out.println("1. Play 1 Round");
        System.out.println("2. Play 3 Rounds");
        System.out.print("Choose game mode (1 or 2): ");

        int choice = 1;
        try {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.nextLine();
            }
        } catch (Exception e) {
            scanner.nextLine();
        }

        int totalRounds = (choice == 2) ? 3 : 1;
        int playerScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= totalRounds; round++) {
            if (totalRounds > 1) {
                System.out.println("\n--- Round " + round + " of " + totalRounds + " ---");
            }
            resetBoard();
            char roundWinner = playSingleRound();

            if (roundWinner == 'X') {
                playerScore++;
                System.out.println("You won this round!");
            } else if (roundWinner == 'O') {
                computerScore++;
                System.out.println("Computer won this round!");
            } else {
                System.out.println("This round is a draw!");
            }
            System.out.println("Score -> You: " + playerScore + " | Computer: " + computerScore);

            if (totalRounds > 1 && (playerScore == 2 || computerScore == 2)) {
                System.out.println("\nMatch decided early!");
                break;
            }
        }

        if (totalRounds > 1) {
            System.out.println("\n============================");
            System.out.println("Final Score:");
            System.out.println("You: " + playerScore + " | Computer: " + computerScore);
            if (playerScore > computerScore) {
                System.out.println("Congratulations! You won the match!");
            } else if (computerScore > playerScore) {
                System.out.println("Computer won the match! Better luck next time.");
            } else {
                System.out.println("The match ended in a tie overall!");
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    /*
     * Resets the game board back to initial numbers state
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
     * Manages a single round of Tic Tac Toe
     */
    public static char playSingleRound() {
        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            printBoard();

            if (currentPlayer == 'X') {
                playerMove();
                moves++;
                if (checkWin('X')) {
                    printBoard();
                    return 'X';
                }
            } else {
                System.out.println("\nComputer's turn (O)...");
                computerMove();
                moves++;
                if (checkWin('O')) {
                    printBoard();
                    return 'O';
                }
            }

            if (moves == 9) {
                printBoard();
                return 'T'; // Tie
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    /*
     * Displays the current state of the game board
     */
    public static void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    /*
     * Handles the player's move
     */
    public static void playerMove() {
        int choice;
        while (true) {
            System.out.print("Enter available position (1-9): ");
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 9) {
                    int row = (choice - 1) / 3;
                    int col = (choice - 1) % 3;

                    if (board[row][col] != 'X' && board[row][col] != 'O') {
                        board[row][col] = 'X';
                        break;
                    } else {
                        System.out.println("Position already taken! Choose another one.");
                    }
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // clear invalid input from buffer
            }
        }
    }

    /*
     * Generates a random valid position for the computer's turn
     */
    public static void computerMove() {
        while (true) {
            int choice = random.nextInt(9) + 1;
            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            if (board[row][col] != 'X' && board[row][col] != 'O') {
                board[row][col] = 'O';
                System.out.println("Computer chose position: " + choice);
                break;
            }
        }
    }

    /*
     * Checks if the specified player has won the game.
     */
    public static boolean checkWin(char p) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == p && board[i][1] == p && board[i][2] == p) ||
                    (board[0][i] == p && board[1][i] == p && board[2][i] == p)) {
                return true;
            }
        }
        if ((board[0][0] == p && board[1][1] == p && board[2][2] == p) ||
                (board[0][2] == p && board[1][1] == p && board[2][0] == p)) {
            return true;
        }
        return false;
    }
}