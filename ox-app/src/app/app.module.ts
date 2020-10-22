import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GameGridComponent } from './game-grid/game-grid.component';
import { RandomAIComponent } from './random-ai/random-ai.component';
import {SocketioService} from './socketio.service';

@NgModule({
  declarations: [
    AppComponent,
    GameGridComponent,
    RandomAIComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [SocketioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
