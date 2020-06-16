package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    static boolean setPlayer;
    static List<Integer> humanMarks = new ArrayList<>();
    static List<Integer> robotMarks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe ttt = new TicTacToe();
        ttt.printGameBoard();
        ttt.printWinningList();

        System.out.println("Enter Starting PLayer (1 for Human or 2 for Robot): ");
        int startingPlayer = scanner.nextInt();

        if (startingPlayer == 1) {
            setPlayer = true;
        }

        while (true) {
            if (setPlayer == true) {
                System.out.print("Human enter your position " + ANSI_RED + "[X]: " + ANSI_RESET);
                ttt.changePlayer("human");
                int humanPlayer = scanner.nextInt();
                // Check if the spot is already marked
                while (humanMarks.contains(humanPlayer) || robotMarks.contains(humanPlayer)) {
                    System.out.println("Spot has been marked please reenter your position: ");
                    humanPlayer = scanner.nextInt();
                }
                humanMarks.add(humanPlayer);

                // Convert player position to game board position
                ttt.convertPosition(humanPlayer);
                ttt.printGameBoard();
                // For testing
                System.out.println("HumanMarks size(): " + humanMarks.size());
                System.out.println("Human player marks position: " + humanMarks.toString());
                setPlayer = false;
            } else {
                System.out.print("Robot position " + ANSI_CYAN + "[O]: " + ANSI_RESET);
                ttt.changePlayer("cpu");
                int robotPlayer = ttt.cpuPosition();
                // Check if the spot is already marked
                while (robotMarks.contains(robotPlayer) || humanMarks.contains(robotPlayer)) {
                    System.out.println("Spot has been marked please reenter your position: ");
                    robotPlayer = ttt.cpuPosition();
                }
                robotMarks.add(robotPlayer);
                // Convert player position to game board position
                ttt.convertPosition(robotPlayer);
                ttt.printGameBoard();
                // For testing
                System.out.println("RobotMarks size(): "+robotMarks.size());
                System.out.println("Robot player marks position: " + robotMarks.toString());
                setPlayer = true;
            }
            if (startingPlayer == 0) {
                break;
            }
        }

        ttt.printGameBoard();
    }
}
