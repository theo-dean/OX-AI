import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GameGridComponent } from './game-grid/game-grid.component';
import { RandomAIComponent } from './random-ai/random-ai.component';
import { SmartAiComponent } from './smart-ai/smart-ai.component';

@NgModule({
  declarations: [
    AppComponent,
    GameGridComponent,
    RandomAIComponent,
    SmartAiComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
