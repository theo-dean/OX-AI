import { Component, OnInit } from '@angular/core';
import {BackendIoService} from '../backend-io.service';
import { Greeter } from '../Greeter';

@Component({
  selector: 'app-smart-ai',
  templateUrl: './smart-ai.component.html',
  styleUrls: ['./smart-ai.component.css']
})


export class SmartAiComponent implements OnInit {

  response: Greeter;

  constructor(private backendIoService: BackendIoService) { }

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

}
