package com.example;

public class TicTacToe {

    public static Evaluation evaluateBoard(String boardState) {
        // implement your code here

        //Invalid Input
        if(boardState == null || boardState.length() == 0 || boardState.length() != 9) {
            return Evaluation.InvalidInput;
        }

        //UnreachableState
        char[] charArray = boardState.toCharArray();
        int xCounter = 0;
        int oCounter= 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                xCounter++;
            }
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                oCounter++;
            }
        }
        if (xCounter == 9 || oCounter == 9) {
            return Evaluation.UnreachableState;
        }
        return Evaluation.InvalidInput;



        //X-Wins

        //O-Wins

        //No Winner
    }
}
