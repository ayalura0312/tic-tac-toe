package com.example;

public class TicTacToe {

    public static Evaluation evaluateBoard(String boardState) {

        //maximum string length
        final int MAX_LENGTH = 9;
        //end position of board
        final int END_POSITION = 8;
        //middle position of board
        final int MIDDLE_POSITION = 4;
        //top-right corner of board
        final int TOP_RIGHT = 2;
        //bottom-left corner of board
        final int BOTTOM_LEFT = 6;

        //Invalid Input
        if(boardState == null || boardState.length() == 0 || boardState.length() != MAX_LENGTH) {
            return Evaluation.InvalidInput;
        }

        // implement your code here
        char[] charArray = boardState.toCharArray();
        int xCounter = 0;
        int oCounter= 0;
        int emptySpaceCounter = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                xCounter++;
            }
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                oCounter++;
            }
            if (charArray[i] == '.') {
                emptySpaceCounter++;
            }
        }

        //UnreachableState
        if (xCounter == MAX_LENGTH || oCounter == MAX_LENGTH) {
            return Evaluation.UnreachableState;
        }
        if (oCounter > xCounter || xCounter > oCounter + 1) {
            return Evaluation.UnreachableState;
        }
        if (emptySpaceCounter == MAX_LENGTH) {
            return Evaluation.NoWinner;
        }

            //MultipleWinners
        int xWinsCounter = 0;
        int oWinsCounter = 0;
        for (int i = 0; i <= BOTTOM_LEFT; i = i + 3) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                if (charArray[i + 1] == 'x' || charArray[i + 1] == 'X') {
                    if (charArray[i + 2] == 'x' || charArray[i + 2] == 'X') {
                        xWinsCounter++;
                    }
                }
            }
        }
        for (int i = 0; i <= TOP_RIGHT; i++) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                if (charArray[i + 3] == 'x' || charArray[i + 3] == 'X') {
                    if (charArray[i + 6] == 'x' || charArray[i + 6] == 'X') {
                        xWinsCounter++;
                    }
                }
            }
        }
        for (int i = 0; i <= BOTTOM_LEFT; i = i + 3) {
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                if (charArray[i + 1] == 'o' || charArray[i + 1] == 'O') {
                    if (charArray[i + 2] == 'o' || charArray[i + 2] == 'O') {
                        oWinsCounter++;
                    }
                }
            }
        }
        for (int i = 0; i <= TOP_RIGHT; i++) {
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                if (charArray[i + 3] == 'o' || charArray[i + 3] == 'O') {
                    if (charArray[i + 6] == 'o' || charArray[i + 6] == 'O') {
                        oWinsCounter++;
                    }
                }
            }
        }
        if(xWinsCounter > 0 && oWinsCounter > 0) {
            return Evaluation.UnreachableState;
        }

            //X goes after O wins
        if(oWinsCounter > 0 && xCounter > oCounter) {
            return Evaluation.UnreachableState;
        }

        //X-Wins

            //horizontal
        for (int i = 0; i <= BOTTOM_LEFT; i = i + 3) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                if (charArray[i + 1] == 'x' || charArray[i + 1] == 'X') {
                    if (charArray[i + 2] == 'x' || charArray[i + 2] == 'X') {
                        return Evaluation.Xwins;
                    }
                }
            }
        }
            //vertical
        for (int i = 0; i <= TOP_RIGHT; i++) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                if (charArray[i + 3] == 'x' || charArray[i + 3] == 'X') {
                    if (charArray[i + 6] == 'x' || charArray[i + 6] == 'X') {
                        return Evaluation.Xwins;
                    }
                }
            }
        }
            //diagonal
        if (charArray[0] == 'x' || charArray[0] == 'X') {
            if (charArray[MIDDLE_POSITION] == 'x' || charArray[MIDDLE_POSITION] == 'X') {
                if (charArray[END_POSITION] == 'x' || charArray[END_POSITION] == 'X') {
                    return Evaluation.Xwins;
                }
            }
        }
        if (charArray[TOP_RIGHT] == 'x' || charArray[TOP_RIGHT] == 'X') {
            if (charArray[MIDDLE_POSITION] == 'x' || charArray[MIDDLE_POSITION] == 'X') {
                if (charArray[BOTTOM_LEFT] == 'x' || charArray[BOTTOM_LEFT] == 'X') {
                    return Evaluation.Xwins;
                }
            }
        }


        //O-Wins

        //horizontal
        for (int i = 0; i <= BOTTOM_LEFT; i = i + 3) {
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                if (charArray[i + 1] == 'o' || charArray[i + 1] == 'O') {
                    if (charArray[i + 2] == 'o' || charArray[i + 2] == 'O') {
                        return Evaluation.Owins;
                    }
                }
            }
        }
        //vertical
        for (int i = 0; i <= TOP_RIGHT; i++) {
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                if (charArray[i + 3] == 'o' || charArray[i + 3] == 'O') {
                    if (charArray[i + 6] == 'o' || charArray[i + 6] == 'O') {
                        return Evaluation.Owins;
                    }
                }
            }
        }
        //diagonal
        if (charArray[0] == 'o' || charArray[0] == 'O') {
            if (charArray[MIDDLE_POSITION] == 'o' || charArray[MIDDLE_POSITION] == 'O') {
                if (charArray[END_POSITION] == 'o' || charArray[END_POSITION] == 'O') {
                    return Evaluation.Owins;
                }
            }
        }
        if (charArray[TOP_RIGHT] == 'o' || charArray[TOP_RIGHT] == 'O') {
            if (charArray[MIDDLE_POSITION] == 'o' || charArray[MIDDLE_POSITION] == 'O') {
                if (charArray[BOTTOM_LEFT] == 'o' || charArray[BOTTOM_LEFT] == 'O') {
                    return Evaluation.Owins;
                }
            }
        }

        //No Winner
        return Evaluation.NoWinner;
    }
}
