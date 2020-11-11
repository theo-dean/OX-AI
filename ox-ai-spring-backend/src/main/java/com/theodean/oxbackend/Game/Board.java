package com.theodean.oxbackend.Game;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Board {
    enum gameState {
        ACTIVE,
        PLAYERWIN,
        AIWIN,
        DRAW
    }

    int[] states;   //Array with integer representation for states of each cell on the board.
    //Where: 0 - empty, 1 - cross, 2 - naught. (This matches the front-end system)

    public Board() {
        this.states = new int[9];
    }

    public Board(int[] states){
        this.states = states.clone();
    }

    int[] getStates() {
        return this.states;
    }

    int getStates(int pos) {
        return this.states[pos];
    }

    public void setStates(int[] states){       //This method is not well implemented. Rework.
        if (states.length == 9){
            /*for (int i=0;i < 9;i++){
                this.states[i] = states[i];
            }
            return;
             */
            this.states = states;
            return;
        }
        System.out.println(states.length+" states were supplied. 9 states are required.");
    }

    public ArrayList<Board> possibleMoves() {
        return null;
    }

    public gameState isWin(int winner) {
        if (winner == 0){
            return gameState.ACTIVE;
        }
        if (winner == 1){
            return gameState.PLAYERWIN;
        }
        if (winner == 2){
            return gameState.AIWIN;
        }

        throw new IllegalStateException("State supplied invalid: "+ winner);
    }

    public gameState gameStatus() {
        //Checking if there are any winning combinations
        if (states[0] == states[1] && states[1] == states[2]) {// Row 1
            if (states[0] != 0) {   //Making checking the combinations are not of blank squares!
                return isWin(states[0]);
            }
        }
        if (states[3] == states[4] && states[4] == states[5]) {// Row 2
            if (states[3] != 0) {
                return isWin(states[3]);
            }
        }
        if (states[6] == states[7] && states[7] == states[8]) {// Row 3
            if (states[6] != 0) {
                return isWin(states[6]);
            }
        }
        if (states[0] == states[3] && states[3] == states[6]) {// Column 1
            if (states[0] != 0) {
                return isWin(states[0]);
            }
        }
        if (states[1] == states[4] && states[4] == states[7]) {// Column 2
            if (states[1] != 0) {
                return isWin(states[1]);
            }
        }
        if (states[2] == states[5] && states[5] == states[8]) {// Column 3
            if (states[2] != 0) {
                return isWin(states[2]);
            }
        }
        if (states[0] == states[4] && states[4] == states[8]) {// Diagonal 1
            if (states[0] != 0) {
                return isWin(states[0]);
            }
        }
        if (states[2] == states[4] && states[4] == states[6]) {// Diagonal 2
            if (states[2] != 0) {
                return isWin(states[2]);
            }
        }

        for (int i=0;i<getStates().length;i++){ //Check each grid pos
            if (getStates(i)==0) {  // If any grid pos is empty
                return gameState.ACTIVE;    //Game is still active
            }
        }

        return gameState.DRAW;
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
        return(String.format("%c %c %c\n%c %c %c\n%c %c %c", grid[0],grid[1],grid[2],grid[3],grid[4],grid[5],grid[6],grid[7],grid[8]));
    }
}
