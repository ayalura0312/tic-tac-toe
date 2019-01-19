package com.example;

//import jdk.jshell.EvalException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ayusha Ayalur
 */
public class TicTacToeTest {

    //NoWinner Inputs
    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }

    @Test
    public void simpleTieBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("oxoxoxxox"));
    }

    @Test
    public void simpleEmptyBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("........."));
    }

    //Invalid Inputs
        //too short
    @Test
    public void simpleShortBoard() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("xoxo"));
    }
        //too long
    @Test
    public void simpleLongBoard() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("xoxoxoxoxo"));
    }
        //null
    @Test
    public void simpleNullBoard() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(null));
    }
        //empty
    @Test
    public void simpleEmptyString() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(""));
    }

    //UnreachableState Inputs
        //too many x's
    @Test
    public void tooManyXsBoard() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("xxoxox..."));
    }
        //too many o's
    @Test
    public void tooManyOsBoard() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("oxooxo..."));
    }
        //all x's
    @Test
    public void allXsBoard() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("xxxxxxxxx"));
    }
        //all o's
    @Test
    public void allOsBoard() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("ooooooooo"));
    }
        //multipleWinners
    @Test
    public void multipleWinnerBoard() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("xoxxooxox"));
    }

    //X-Wins Inputs
        //horizontal X
    @Test
    public void horizontalExWinner() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("oxoxxxxoo"));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("xxxxoooxo"));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("oxoooxxxx"));
    }
        //vertical X
    @Test
    public void verticalExWinner() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("xo.x..x.."));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("ox..x..xo"));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("..x.oxo.x"));
    }
        //diagonal X
    @Test
    public void diagonalExWinner() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("x.o.xo..x"));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("oox.x.x.."));

    }

    //O-Wins Inputs
        //horizontal O
    @Test
    public void horizontalOhWinner() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("ooo.xx.x."));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("x.xooo.x."));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("x.x.x.ooo"));
    }
        //vertical O
    @Test
    public void verticalOhWinner() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("o..oxxo.x"));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard(".o.xo.xox"));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard(".xox.ox.o"));
    }
        //diagonal O
    @Test
    public void diagonalOhWinner() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard(".xo.oxo.x"));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("o.xxox..o"));
    }
}