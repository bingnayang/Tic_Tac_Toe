package com.company;

import java.util.Scanner;

public class Main {
    static boolean setPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe ttt = new TicTacToe();
        ttt.printGameBoard();

        System.out.println("Enter Starting PLayer (1 for Human or 2 for Robot): ");
        int startingPlayer = scanner.nextInt();

        if(startingPlayer == 1){
            setPlayer = true;
        }

        while(true){

            if(setPlayer == true){
                System.out.println("Human enter your position: ");
                ttt.changePlayer("human");
                int humanPlayer1 = scanner.nextInt();
                int humanPlayer2 = scanner.nextInt();
                ttt.placeMark(humanPlayer1,humanPlayer2);
                ttt.printGameBoard();
                setPlayer = false;
            }else{
                System.out.println("Robot position: ");
                ttt.changePlayer("cpu");
                int robotPlayer1 = scanner.nextInt();
                int robotPlayer2 = scanner.nextInt();
                ttt.placeMark(robotPlayer1,robotPlayer2);
                ttt.printGameBoard();
                setPlayer = true;
            }

            if(startingPlayer == 0){
                break;
            }
        }

        ttt.printGameBoard();
    }
}
