package com.company;

public class Main {

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.printGameBoard();
        ttt.placeMark(0,1);

        ttt.printGameBoard();
    }
}
