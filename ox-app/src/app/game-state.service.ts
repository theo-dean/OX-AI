import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class GameStateService {
  private grid: boolean[] = [null, null, null, null, null, null, null, null, null];
  private playerTurn = true;
  private playerWin = null;
  private draw = null;
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

  checkDraw(): boolean {
    for (let gridPos of this.grid){
      if (gridPos === null){
        return false;
      }
    }
    if (!(this.checkWin())) {
      this.draw = true;
      return true;
    }
    return false;
  }

  checkWin(): boolean {
    if (this.grid[0] && this.grid[1] && this.grid[2]){ // X X X
      this.playerWin = true;
      return true;
    }
    if (this.grid[3] && this.grid[4] && this.grid[5]) {// Row 2
      this.playerWin = true;
      return true;
    }
    if (this.grid[6] && this.grid[7] && this.grid[8]){// Row 3
      this.playerWin = true;
      return true;
    }
    if (this.grid[0] && this.grid[3] && this.grid[6]) {// Column 1
      this.playerWin = true;
      return true;
    }
    if (this.grid[1] && this.grid[4] && this.grid[7]){// Column 2
      this.playerWin = true;
      return true;
    }
    if (this.grid[2] && this.grid[5] && this.grid[8]){// Column 3
      this.playerWin = true;
      return true;
    }
    if (this.grid[0] && this.grid[4] && this.grid[8]){// Diagonal 1
      this.playerWin = true;
      return true;
    }
    if (this.grid[2] && this.grid[4] && this.grid[6]){// Diagonal 2
      this.playerWin = true;
      return true;
    }
  }
}
