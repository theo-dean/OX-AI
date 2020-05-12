import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-game-grid',
  templateUrl: './game-grid.component.html',
  styleUrls: ['./game-grid.component.css']
})
export class GameGridComponent implements OnInit {
  grid: boolean[] = [null, null, null, null, null, null, null, null, null];
  constructor() { }

  changeGrid(gridPos: number): void{
    switch (this.grid[gridPos]) {
      case null:
        this.grid[gridPos] = true;
        break;
      case true:
        this.grid[gridPos] = false;
        break;
      case false:
        this.grid[gridPos] = null;
        break;
    }
  }

  getGrid(gridPos: number): boolean{
    return(this.grid[gridPos]);
  }

  getImage(gridPos: number): string{
    if (this.getGrid(gridPos) === true){
      return 'assets/x.jpg';
    }
    if (this.getGrid(gridPos) === false){
      return 'assets/o.jpg';
    }
  }

  ngOnInit(): void {
  }

}
