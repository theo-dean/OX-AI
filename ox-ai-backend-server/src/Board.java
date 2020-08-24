public class Board {
    int[] states;   //Array with integer representation for states of each cell on the board.
                        //Where: 0 - empty, 1 - naught, 2 - cross.

    public Board(){
        this.states = new int[9];
    }

    int[] getStates(){
        return this.states;
    }

    int getStates(int pos){
        return this.states[pos];
    }

    public String
}
