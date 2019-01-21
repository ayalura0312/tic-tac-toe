package com.example;

public class TicTacToe {

    public static Evaluation evaluateBoard(String boardState) {

        //Invalid Input
        if(boardState == null || boardState.length() == 0 || boardState.length() != 9) {
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
        if (xCounter == 9 || oCounter == 9) {
            return Evaluation.UnreachableState;
        }
        if (oCounter > xCounter || xCounter > oCounter + 1) {
            return Evaluation.UnreachableState;
        }

            //MultipleWinners
        int xWinsCounter = 0;
        int oWinsCounter = 0;
        for (int i = 0; i <= 6; i = i + 3) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                if (charArray[i + 1] == 'x' || charArray[i + 1] == 'X') {
                    if (charArray[i + 2] == 'x' || charArray[i + 2] == 'X') {
                        xWinsCounter++;
                    }
                }
            }
        }
        for (int i = 0; i <= 2; i++) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                if (charArray[i + 3] == 'x' || charArray[i + 3] == 'X') {
                    if (charArray[i + 6] == 'x' || charArray[i + 6] == 'X') {
                        xWinsCounter++;
                    }
                }
            }
        }
        for (int i = 0; i <= 6; i = i + 3) {
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                if (charArray[i + 1] == 'o' || charArray[i + 1] == 'O') {
                    if (charArray[i + 2] == 'o' || charArray[i + 2] == 'O') {
                        oWinsCounter++;
                    }
                }
            }
        }
        for (int i = 0; i <= 2; i++) {
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
        for (int i = 0; i <= 6; i = i + 3) {
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                if (charArray[i + 1] == 'x' || charArray[i + 1] == 'X') {
                    if (charArray[i + 2] == 'x' || charArray[i + 2] == 'X') {
                        return Evaluation.Xwins;
                    }
                }
            }
        }
            //vertical
        for (int i = 0; i <= 2; i++) {
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
            if (charArray[4] == 'x' || charArray[4] == 'X') {
                if (charArray[8] == 'x' || charArray[8] == 'X') {
                    return Evaluation.Xwins;
                }
            }
        }
        if (charArray[2] == 'x' || charArray[2] == 'X') {
            if (charArray[4] == 'x' || charArray[4] == 'X') {
                if (charArray[6] == 'x' || charArray[6] == 'X') {
                    return Evaluation.Xwins;
                }
            }
        }


        //O-Wins

        //horizontal
        for (int i = 0; i <= 6; i = i + 3) {
            if (charArray[i] == 'o' || charArray[i] == 'O') {
                if (charArray[i + 1] == 'o' || charArray[i + 1] == 'O') {
                    if (charArray[i + 2] == 'o' || charArray[i + 2] == 'O') {
                        return Evaluation.Owins;
                    }
                }
            }
        }
        //vertical
        for (int i = 0; i <= 2; i++) {
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
            if (charArray[4] == 'o' || charArray[4] == 'O') {
                if (charArray[8] == 'o' || charArray[8] == 'O') {
                    return Evaluation.Owins;
                }
            }
        }
        if (charArray[2] == 'o' || charArray[2] == 'O') {
            if (charArray[4] == 'o' || charArray[4] == 'O') {
                if (charArray[6] == 'o' || charArray[6] == 'O') {
                    return Evaluation.Owins;
                }
            }
        }

        //No Winner
        return Evaluation.NoWinner;
    }
}
