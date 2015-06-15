package com.company.Array;

/**
 * Created by RANGA on 1/13/2015.
 */
public class TicTacToe {

    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;

    public int[][] board = new int[3][3];

    public int player;

    public TicTacToe(){
        clearBoard();
    }

    public void clearBoard(){
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                board[i][j] = EMPTY;
            }
        }
        player = X;
    }

    public void putMark(int i, int j) throws IllegalArgumentException{
        if (i<0 || i>2 || j<0 || j>2)
            throw new IllegalArgumentException("Invalid board position");
        if (board[i][j] != EMPTY){
            throw new IllegalArgumentException("Board position occupied");
        }

        board[i][j] = player;
        player = -player;
    }

    public boolean isWin(int mark){
        return (board[0][0]+board[0][1]+board[0][2] == mark*3
        || board[1][0]+board[1][1]+board[1][2] == mark*3
        || board[2][0]+board[2][1]+board[2][2] == mark*3
        || board[0][0]+board[1][0]+board[2][0] == mark*3
        || board[0][1]+board[1][1]+board[2][1] == mark*3
        || board[0][2]+board[1][2]+board[2][2] == mark*3
        || board[0][0]+board[1][1]+board[2][2] == mark*3
        || board[2][0]+board[1][1]+board[0][2] == mark*3);
    }
    public int winner(){
        if(isWin(X)){
            return X;
        }else if (isWin(O)){
            return O;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        game.putMark(1,1);
        game.putMark(0,2);
        game.putMark(2,2);
        game.putMark(0,1);
        game.putMark(0,0);
        game.putMark(2,1);
        game.putMark(1,2);
        game.putMark(1,0);
        game.putMark(2,0);
        int winn = game.winner();

        if (winn == 0){
            System.out.println("Its a TIE");
        }else{
            System.out.println(winn +"player wins");
        }
    }
}
