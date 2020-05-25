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
      case 'x':
        this.grid[gridPos] = true;
        this.playerTurn = false;
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
}
