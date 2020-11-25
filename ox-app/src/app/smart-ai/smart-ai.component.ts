import { Component, OnInit } from '@angular/core';
import {BackendIoService} from '../backend-io.service';
import { Greeter } from '../Greeter';
import {Move} from '../Move';
import {GameStateService} from '../game-state.service';

@Component({
  selector: 'app-smart-ai',
  templateUrl: './smart-ai.component.html',
  styleUrls: ['./smart-ai.component.css']
})


export class SmartAiComponent implements OnInit {

  grid: string;
  response;
  moveResponse: Move;

  constructor(private backendIoService: BackendIoService, private gameStateService: GameStateService) { }

  ngOnInit(): void {
  }

  getResponse() {
    this.backendIoService.getResponse()
      .subscribe((data: Greeter) => {
        this.response = { ...data};
        console.log(this.response);
    });
  }

  getNamedResponse(name: string) {
    this.backendIoService.getNamedResponse(name)
      .subscribe((data: Greeter) => {
        this.response = { ...data};
        console.log(this.response);
      });
  }

  getSmartMove(){
    this.grid = this.gameStateService.getGridString();
    this.backendIoService.getSmartMove(this.grid)
      .subscribe((data) => {
        this.moveResponse = {...data};
        console.log(this.moveResponse);
        this.makeSmartMove(this.moveResponse.move);
      });
  }

  makeSmartMove(gridPos: number){
    this.gameStateService.changeGrid(gridPos, 'o');
  }

}
