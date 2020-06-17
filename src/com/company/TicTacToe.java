package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToe {

    List<ArrayList<Integer>> winningSet = new ArrayList<ArrayList<Integer>>();

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
        System.out.println();
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

    public List addWinningSet () {


        winningSet.add(new ArrayList<>(Arrays.asList(1,2,3)));
        winningSet.add(new ArrayList<>(Arrays.asList(4,5,6)));
        winningSet.add(new ArrayList<>(Arrays.asList(7,8,9)));

        winningSet.add(new ArrayList<>(Arrays.asList(1,4,7)));
        winningSet.add(new ArrayList<>(Arrays.asList(2,5,8)));
        winningSet.add(new ArrayList<>(Arrays.asList(3,6,9)));

        winningSet.add(new ArrayList<>(Arrays.asList(1,5,9)));
        winningSet.add(new ArrayList<>(Arrays.asList(3,5,7)));

        return winningSet;
    }
    public void printWinningList(){
        System.out.println(addWinningSet());
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
    public void convertPosition(int positionConvert){
        switch (positionConvert){
            case 1:
                placeMark(0,1);
                break;
            case 2:
                placeMark(0,3);
                break;
            case 3:
                placeMark(0,5);
                break;
            case 4:
                placeMark(2,1);
                break;
            case 5:
                placeMark(2,3);
                break;
            case 6:
                placeMark(2,5);
                break;
            case 7:
                placeMark(4,1);
                break;
            case 8:
                placeMark(4,3);
                break;
            case 9:
                placeMark(4,5);
                break;
        }

    }
    public String checkMatchWinner(List playerPositions){
        for(List list : winningSet){
            if(playerPositions.contains(list)){
                return "You Win";
            }
        }
        return "";
    }

}
