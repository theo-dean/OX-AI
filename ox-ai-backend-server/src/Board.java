public class Board {
    int[] states;   //Array with integer representation for states of each cell on the board.
    //Where: 0 - empty, 1 - naught, 2 - cross.

    public Board() {
        this.states = new int[9];
    }

    int[] getStates() {
        return this.states;
    }

    int getStates(int pos) {
        return this.states[pos];
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.toString());
    }

    public String toString() {
        char[] grid = new char[9];
        for (int i = 0; i < states.length; i++) {
            switch (states[i]) {
                case (0):
                    grid[i] = '-';
                    break;
                case (1):
                    grid[i] = 'O';
                    break;
                case (2):
                    grid[i] = 'X';
                    break;
            }
        }
        return(String.format("%c %c %c\n%c %c %c\n%c %c %c", grid[0],grid[1],grid[2],grid[3],grid[4],grid[5],grid[6],grid[7],grid[8]));
    }
}
