import { Component, OnInit } from '@angular/core';
import { GameStateService } from '../game-state.service';

@Component({
  selector: 'app-random-ai',
  templateUrl: './random-ai.component.html',
  styleUrls: ['./random-ai.component.css']
})
export class RandomAIComponent implements OnInit {
  constructor(private gameStateService: GameStateService) { }

  randomMove(): void {
    let randomCell = Math.floor(Math.random() * Math.floor(9));
    while (!(this.gameStateService.changeGrid(randomCell, 'o'))){
      randomCell = Math.floor(Math.random() * Math.floor(9));
    }
  }

  getTurn(): boolean {
    return this.gameStateService.getTurn();
  }
  getState(): number {
    return this.gameStateService.checkState();
  }

  getStateString(): string {
    let state;
    state = this.gameStateService.checkState();
    if (state === 0){
      return 'Active';
    }
    if (state === 1){
      return 'Player Wins!';
    }
    if (state === 2){
      return 'Computer Wins!';
    }
    if (state === 3){
      return 'Draw!';
    }
  }

  resetGrid(): void {
    this.gameStateService.reset();
  }

  ngOnInit(): void {
  }

}
