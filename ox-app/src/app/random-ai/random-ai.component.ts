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
  getWin(): boolean {
    return this.gameStateService.checkWin();
  }
  resetGrid(): void {
    this.gameStateService.reset();
  }

  ngOnInit(): void {
  }

}
