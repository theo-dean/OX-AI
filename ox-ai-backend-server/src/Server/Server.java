package Server;

import Game.Board;

public class Server implements Runnable{
    private Board board;

    Server(){
        this.board = new Board();
    }

    public void updateBoard(int[] boardStates){
        board.setStates(boardStates);
    }

    @Override
    public void run() {

    }
}
