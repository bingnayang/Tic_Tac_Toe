package com.company;

public class TicTacToe {
    private String currentPlayer = "X";
    private String[][] tttGameBoard = {
            {"| ","1"," | ","2"," | ","3"," |"},
            {"| ","-"," + ","-"," + ","-"," |"},
            {"| ","4"," | ","5"," | ","6"," |"},
            {"| ","-"," + ","-"," + ","-"," |"},
            {"| ","7"," | ","8"," | ","9"," |"}};

    public TicTacToe() {

    }

    public void printGameBoard(){
        System.out.println("+-----------+");
        for(String[] row: tttGameBoard){
            for(String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println("+-----------+");
        System.out.println();
    }
    public boolean placeMark(int row, int col){
        tttGameBoard[row][col] = currentPlayer;
        return true;
    }
}
