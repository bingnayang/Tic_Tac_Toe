package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe ttt = new TicTacToe();
        ttt.printGameBoard();

        System.out.println("Enter Starting PLayer (Human or Computer): ");

        ttt.changePlayer("human");


        ttt.placeMark(2,3);

        ttt.printGameBoard();
    }
}
