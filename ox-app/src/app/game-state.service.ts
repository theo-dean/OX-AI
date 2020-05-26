import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class GameStateService {
  private grid: boolean[] = [null, null, null, null, null, null, null, null, null];
  private playerTurn = true;
  constructor() { }

  getGrid(): boolean[]{
    return this.grid;
  }

  getGridPos(gridPos: number): boolean{
    return(this.grid[gridPos]);
  }

  getTurn(): boolean {
    return this.playerTurn;
  }

  reset(): void {
    this.grid = [null, null, null, null, null, null, null, null, null];
    this.playerTurn = true;
  }

  changeGrid(gridPos: number, state: string): boolean{
    if (this.grid[gridPos] !== null){
      return false;
    }
    switch (state) {
      case 'x': // Player Move
        if (this.getTurn()){
          this.grid[gridPos] = true;
          this.playerTurn = false;
        }
        break;
      case 'o':
        this.grid[gridPos] = false;
        this.playerTurn = true;
        break;
      case null:
        this.grid[gridPos] = null;
        break;
    }
    return true;
  }

  checkWin(): boolean {
    if (this.grid[0] && this.grid[1] && this.grid[2]){ // X X X
      return true;
    }
    if (this.grid[3] && this.grid[4] && this.grid[5]) {// Row 2
      return true;
    }
    if (this.grid[6] && this.grid[7] && this.grid[8]){// Row 3
      return true;
    }
    if (this.grid[0] && this.grid[3] && this.grid[6]) {// Column 1
      return true;
    }
    if (this.grid[1] && this.grid[4] && this.grid[7]){// Column 2
      return true;
    }
    if (this.grid[2] && this.grid[5] && this.grid[8]){// Column 3
      return true;
    }
    if (this.grid[0] && this.grid[4] && this.grid[8]){// Diagonal 1
      return true;
    }
    if (this.grid[2] && this.grid[4] && this.grid[6]){// Diagonal 2
      return true;
    }

  }
}
