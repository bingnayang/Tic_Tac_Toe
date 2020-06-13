package com.company;

import java.util.Random;

public class TicTacToe {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private String currentPlayer = "X";
    private String[][] tttGameBoard = {
            {"| ","1"," | ","2"," | ","3"," |"},
            {"+ ","-"," + ","-"," + ","-"," +"},
            {"| ","4"," | ","5"," | ","6"," |"},
            {"+ ","-"," + ","-"," + ","-"," +"},
            {"| ","7"," | ","8"," | ","9"," |"}};

    public void printGameBoard(){
        System.out.println("+---+---+---+");
        for(String[] row: tttGameBoard){
            for(String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println("+---+---+---+");
        System.out.println();
    }
    public boolean placeMark(int row, int col){
        tttGameBoard[row][col] = currentPlayer;
        return true;
    }

    public int cpuPosition(){
        Random random = new Random();
        int randPickedPosition = random.nextInt(9)+1;
        return randPickedPosition;
    }

    public String changePlayer(String player){
        if(player == "human"){
            currentPlayer = ANSI_RED+"X"+ANSI_RESET;
        }else{
            currentPlayer = ANSI_CYAN+"O"+ANSI_RESET;
        }
        return currentPlayer;
    }

}
