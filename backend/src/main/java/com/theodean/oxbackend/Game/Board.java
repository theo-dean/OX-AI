package com.theodean.oxbackend.Game;

import java.util.ArrayList;

public class Board {
    public enum gameState {
        ACTIVE,
        PLAYER_WIN,
        AI_WIN,
        DRAW
    }

    /* Array with integer representation for states of each cell on the board.
     *  Where: 0 - empty, 1 - cross, 2 - naught. (This matches the front-end system)*/
    int[] states;

    public Board() {
        this.states = new int[9];
    }

    public Board(int[] states) {
        this.states = states.clone();
    }

    int[] getStates() {
        return this.states;
    }

    int getStates(int pos) {
        return this.states[pos];
    }

    public boolean isWin() {     //returns true if either player or AI has won, or a draw. Returns false if the game is active.
        return gameStatus() != gameState.ACTIVE;
    }

    /**
     * Returns an int representation of which player's turn it is; 1 represents player turn, 2 represents AI turn.
     *
     * @throws IllegalStateException
     */
    int getTurn() {
        int x = 0, o = 0;

        for (int state : states) {
            if (state == 1) {
                x++;
            } else if (state == 2) {
                o++;
            }
        }

        if (x == o) {
            return 1;
        } else if (o < x && Math.abs(o - x) == 1) {    //Checking AI has less pieces than player, and that the difference is only 1.
            return 2;
        }
        throw new IllegalStateException("Board is not valid. Player has moved " + x + " times, and AI " + o + " times.");
    }

    public void setStates(int[] states) {       //This method is not well implemented. Rework.
        if (states.length == 9) {
            /*for (int i=0;i < 9;i++){
                this.states[i] = states[i];
            }
            return;
             */
            this.states = states;
            return;
        }
        System.out.println(states.length + " states were supplied. 9 states are required.");
    }

    Board makeMove(int pos, int player) throws Exception {
       /* if (isWin()) {
            throw new Exception("Attempting to further a board that is already won/lost/drawn.");
        }*/
        Board temp = new Board(states);
        temp.states[pos] = player;
        return temp;
    }

    public ArrayList<Board> possibleMoves() throws IllegalStateException { // Returns an array of possible moves derived from the current board.
        ArrayList<Board> temp = new ArrayList<>();
        int tempTurn = getTurn();

        for (int i = 0; i < states.length; i++) {
            if (states[i] == 0) {
                try {
                    temp.add(makeMove(i, tempTurn));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return temp;
    }

    gameState checkState(int winner) {
        if (winner == 0) {
            return gameState.ACTIVE;
        }
        if (winner == 1) {
            return gameState.PLAYER_WIN;
        }
        if (winner == 2) {
            return gameState.AI_WIN;
        }

        throw new IllegalStateException("State supplied invalid: " + winner);
    }

    /* Checks what state the game is in.
     *  The game can be running, or can be won (by either player) or drawn.
     *  First checks all the winning combinations (horizontal, vertical, diagonal)
     *  If no combinations, checks if all grid spaces are occupied.*/
    public gameState gameStatus() {
        if (states[0] == states[1] && states[1] == states[2]) {// Row 1
            if (states[0] != 0) {
                return checkState(states[0]);
            }
        }
        if (states[3] == states[4] && states[4] == states[5]) {// Row 2
            if (states[3] != 0) {
                return checkState(states[3]);
            }
        }
        if (states[6] == states[7] && states[7] == states[8]) {// Row 3
            if (states[6] != 0) {
                return checkState(states[6]);
            }
        }
        if (states[0] == states[3] && states[3] == states[6]) {// Column 1
            if (states[0] != 0) {
                return checkState(states[0]);
            }
        }
        if (states[1] == states[4] && states[4] == states[7]) {// Column 2
            if (states[1] != 0) {
                return checkState(states[1]);
            }
        }
        if (states[2] == states[5] && states[5] == states[8]) {// Column 3
            if (states[2] != 0) {
                return checkState(states[2]);
            }
        }
        if (states[0] == states[4] && states[4] == states[8]) {// Diagonal 1
            if (states[0] != 0) {
                return checkState(states[0]);
            }
        }
        if (states[2] == states[4] && states[4] == states[6]) {// Diagonal 2
            if (states[2] != 0) {
                return checkState(states[2]);
            }
        }

        for (int i = 0; i < getStates().length; i++) {
            if (getStates(i) == 0) {
                return gameState.ACTIVE;
            }
        }

        return gameState.DRAW;
    }

    /** Takes a subsequent board, and returns the grid reference of the move. */
    /* Assumes only one move difference; TODO: handle errors*/
    public int gridDifference(Board incrementedBoard) throws Exception{
        for (int i=0; i<states.length; i++){
            if (incrementedBoard.getStates()[i] != states[i]){
                return i;
            }
        }
        throw new Exception("Board provided is the same.");
    }

    public String toString() {
        char[] grid = new char[9];
        for (int i = 0; i < states.length; i++) {
            switch (getStates(i)) {
                case (0):
                    grid[i] = '-';
                    break;
                case (1):
                    grid[i] = 'X';
                    break;
                case (2):
                    grid[i] = 'O';
                    break;
            }
        }
        return (String.format("%c %c %c\n%c %c %c\n%c %c %c", grid[0], grid[1], grid[2], grid[3], grid[4], grid[5], grid[6], grid[7], grid[8]));
    }
}
