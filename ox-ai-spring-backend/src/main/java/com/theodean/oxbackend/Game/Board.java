package com.theodean.oxbackend.Game;

import java.util.ArrayList;

public class Board {
    enum gameState {
        ACTIVE,
        PLAYERWIN,
        AIWIN,
        DRAW
    }

    enum gridState {
        EMPTY,
        PLAYER,
        AI
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

    }

    public gameState isWin(gridState winner) {

    }

    public gameState gameActive() {
        if (states[0] == states[1] && states[1] == states[2]) {// Row 1
            return isWin(states[0]);
        }
        if (states[3] == states[4] && states[4] == states[5]) {// Row 2
            return isWin(states[3]);
        }
        if (states[6] == states[7] && states[7] == states[8]) {// Row 3
            return isWin(states[6]);
        }
        if (states[0] == states[3] && states[3] == states[6]) {// Column 1
            return isWin(states[0]);
        }
        if (states[1] == states[4] && states[4] == states[7]) {// Column 2
            return isWin(states[1]);
        }
        if (states[2] == states[5] && states[5] == states[8]) {// Column 3
            return isWin(states[2]);
        }
        if (states[0] == 1 && states[4] == 1 && states[8] == 1) {// Diagonal 1
            return isWin(states[0]);
        }
        if (states[2] == 1 && states[4] == 1 && states[6] == 1) {// Diagonal 2
            return isWin(states[2]);
        }
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
