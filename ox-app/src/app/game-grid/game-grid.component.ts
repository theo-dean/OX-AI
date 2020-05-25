import { Component, OnInit } from '@angular/core';
import { GameStateService } from '../game-state.service';

@Component({
  selector: 'app-game-grid',
  templateUrl: './game-grid.component.html',
  styleUrls: ['./game-grid.component.css']
})
export class GameGridComponent implements OnInit {
  constructor(private gameStateService: GameStateService) { }


  getGrid(gridPos: number): boolean{
    return(this.gameStateService.getGridPos(gridPos));
  }

  getImage(gridPos: number): string{
    if (this.getGrid(gridPos) === true){
      return 'assets/x.jpg';
    }
    if (this.getGrid(gridPos) === false){
      return 'assets/o.jpg';
    }
  }

  changeGrid(gridPos: number){
    this.gameStateService.changeGrid(gridPos, 'x');
  }

  ngOnInit(): void {
  }

}
