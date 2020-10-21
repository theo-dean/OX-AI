import { Injectable } from '@angular/core';
enum gridState {
  blank,
  player,
  computer
}

@Injectable({
  providedIn: 'root'
})
export class GameStateService {
  private grid: number[]; // 0 = no move, 1 = x (player move), 2 = o (computer move)
  private playerTurn = true;
  private playerWin = null;
  private draw = null;

  constructor() {
    this.grid = Array(9).fill(gridState.blank);
  }

  getGrid(): number[]{
    return this.grid;
  }

  getGridPos(gridPos: number): number{
    return(this.grid[gridPos]);
  }

  getTurn(): boolean {
    return this.playerTurn;
  }

  reset(): void {
    this.grid = [0, 0, 0, 0, 0, 0, 0, 0, 0];
    this.playerTurn = true;
  }

  changeGrid(gridPos: number, state: string): boolean{
    if (this.grid[gridPos] !== 0){
      return false;
    }
    switch (state) {
      case 'x': // Player Move
        if (this.getTurn()){
          this.grid[gridPos] = 1;
          this.playerTurn = false;
        }
        break;
      case 'o':
        this.grid[gridPos] = 2;
        this.playerTurn = true;
        break;
      case null:
        this.grid[gridPos] = 0;
        break;
    }
    return true;
  }

  checkDraw(): boolean {
    for (const gridPos of this.grid){
      if (gridPos === 0){
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
    if (this.grid[0] === 1 && this.grid[1] === 1 && this.grid[2] === 1) { // X X X
      this.playerWin = true;
      return true;
    }
    if (this.grid[3] === 1 && this.grid[4] === 1 && this.grid[5] === 1) {// Row 2
      this.playerWin = true;
      return true;
    }
    if (this.grid[6] === 1 && this.grid[7] === 1 && this.grid[8] === 1){// Row 3
      this.playerWin = true;
      return true;
    }
    if (this.grid[0] === 1 && this.grid[3] === 1 && this.grid[6] === 1) {// Column 1
      this.playerWin = true;
      return true;
    }
    if (this.grid[1] === 1 && this.grid[4] === 1 && this.grid[7] === 1){// Column 2
      this.playerWin = true;
      return true;
    }
    if (this.grid[2] === 1 && this.grid[5] === 1 && this.grid[8] === 1){// Column 3
      this.playerWin = true;
      return true;
    }
    if (this.grid[0] === 1 && this.grid[4] === 1 && this.grid[8] === 1){// Diagonal 1
      this.playerWin = true;
      return true;
    }
    if (this.grid[2] === 1 && this.grid[4] === 1 && this.grid[6] === 1){// Diagonal 2
      this.playerWin = true;
      return true;
    }
  }
}
