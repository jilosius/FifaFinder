import { NgModule } from '@angular/core';
import { PlayerComponent } from './player.component';
import { PlayerDetailsComponent } from './player-details/player-details.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatCardModule} from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTreeModule } from '@angular/material/tree';
import { BrowserModule } from '@angular/platform-browser';
import { PlayerCardComponent } from './player-card/player-card.component';
import * as CanvasJSAngularChart from '../../assets/canvasjs.angular.component';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatIconModule} from '@angular/material/icon';
import { PlayerOverviewComponent } from './player-overview/player-overview.component'
var CanvasJSChart = CanvasJSAngularChart.CanvasJSChart;
import {MatGridListModule} from '@angular/material/grid-list'; 
@NgModule({
  declarations: [
    CanvasJSChart,
    PlayerComponent,PlayerDetailsComponent,PlayerCardComponent, PlayerOverviewComponent,],
  imports: [MatTabsModule,MatButtonToggleModule,MatCardModule,
  MatTreeModule,MatFormFieldModule,BrowserModule,MatExpansionModule,MatProgressBarModule,MatIconModule,MatGridListModule
],
  exports: [
    PlayerComponent],
  providers: [],
  bootstrap: []
})
export class PlayerModule { }