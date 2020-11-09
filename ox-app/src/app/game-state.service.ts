import {Injectable} from '@angular/core';

enum gridState {
  blank,
  player,
  computer
}

enum gameState {
  active,
  playerWin,
  computerWin,
  draw
}

@Injectable({
  providedIn: 'root'
})

export class GameStateService {
  private grid: gridState[]; // 0 = no move, 1 = x (player move), 2 = o (computer move)
  private playerTurn = true;
  private winState: gameState; // Blank represents no win

  constructor() {
    this.grid = Array(9).fill(gridState.blank);
    this.winState = gameState.active;
  }

  getGrid(): gridState[] {
    return this.grid;
  }

  getGridPos(gridPos: gridState): number {
    return (this.grid[gridPos]);
  }

  getTurn(): boolean {  // Returns True if it is the Player's turn, and False if it is the Computer's turn
    return this.playerTurn;
  }

  setGameState(state: gameState) {
    this.winState = state;
  }

  reset(): void {
    this.grid = [0, 0, 0, 0, 0, 0, 0, 0, 0];
    this.playerTurn = true;
  }

  changeGrid(gridPos: gridState, state: string): boolean {
    if (this.grid[gridPos] !== 0) {
      return false;
    }
    switch (state) {
      case 'x': // Player Move
        if (this.getTurn()) {
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

  isWin(winner: gridState): gameState {
    if (winner === gridState.player) {
      return gameState.playerWin;
    }
    if (winner === gridState.computer) {
      return gameState.computerWin;
    }
    if (winner === gridState.blank){
      return gameState.active;
    }
  }

  // TODO: This is super messy and badly implemented, think of a smarter way to implement...
  checkState(): gameState {
    if (this.grid[0] === this.grid[1] && this.grid[1] === this.grid[2]) {// Row 1
      if (this.isWin(this.grid[0]) !== gameState.active){ // If game isn't active
        return this.isWin(this.grid[0]);
      }
    }
    if (this.grid[3] === this.grid[4] && this.grid[4] === this.grid[5]) {// Row 2
      if (this.isWin(this.grid[3]) !== gameState.active){
        return this.isWin(this.grid[3]);
      }
    }
    if (this.grid[6] === this.grid[7] && this.grid[7] === this.grid[8]) {// Row 3
      if (this.isWin(this.grid[6]) !== gameState.active){
        return this.isWin(this.grid[6]);
      }
    }
    if (this.grid[0] === this.grid[3] && this.grid[3] === this.grid[6]) {// Column 1
      if (this.isWin(this.grid[0]) !== gameState.active){
        return this.isWin(this.grid[0]);
      }
    }
    if (this.grid[1] === this.grid[4] && this.grid[4] === this.grid[7]) {// Column 2
      if (this.isWin(this.grid[1]) !== gameState.active){
        return this.isWin(this.grid[1]);
      }
    }
    if (this.grid[2] === this.grid[5] && this.grid[5] === this.grid[8]) {// Column 3
      if (this.isWin(this.grid[2]) !== gameState.active){
        return this.isWin(this.grid[2]);
      }
    }
    if (this.grid[0] === 1 && this.grid[4] === 1 && this.grid[8] === 1) {// Diagonal 1
      if (this.isWin(this.grid[0]) !== gameState.active){
        return this.isWin(this.grid[0]);
      }
    }
    if (this.grid[2] === 1 && this.grid[4] === 1 && this.grid[6] === 1) {// Diagonal 2
      if (this.isWin(this.grid[2]) !== gameState.active){
        return this.isWin(this.grid[2]);
      }
    }
    for (const gridPos of this.grid) {
      if (gridPos === gridState.blank) {
        this.setGameState(gameState.active);
        return gameState.active;
      }
    }
    this.setGameState(gameState.draw);
  }
}
