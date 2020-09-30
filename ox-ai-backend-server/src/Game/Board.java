package Game;

public class Board {
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
            for (int i=0;i < 9;i++){
                this.states[i] = states[i];
            }
            return;
        }
        System.out.println(states.length+" states were supplied. 9 states are required.");
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
