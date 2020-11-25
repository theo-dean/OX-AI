package com.theodean.oxbackend.restservice;

import com.theodean.oxbackend.Game.Board;
import com.theodean.oxbackend.Game.Tree.Node;
import com.theodean.oxbackend.Game.Tree.Tree;

import java.util.Arrays;

public class Solver {
    private final String boardState;
    private int move;

    public Solver(String boardState){
        this.boardState = boardState;
        this.move = 999;
    }

    public Solver(String boardState, int move){
        this.boardState = boardState;
        this.move = move;
    }

    public String getBoardState(){
        return boardState;
    }

    public int getMove(){
        return move;
    }

    private void setMove(int move){
        this.move = move;
    }

    public void solve() throws Exception{
        System.out.println("Board State: "+ getBoardState());
        int[] arr = new int[9];
        char[] board = getBoardState().toCharArray();

        for(int i=0; i<arr.length;i++){
            arr[i] = Character.getNumericValue(board[i]);
        }

        Node root = new Node(new Board(arr));
        this.move = Tree.bestMoveNaught(root);
    }
}
