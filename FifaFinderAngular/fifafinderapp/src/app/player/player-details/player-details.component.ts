import { Component, Input, OnInit } from '@angular/core';
import { CanvasJS } from 'src/assets/canvasjs.angular.component';
import { DataPoint,  PlaysFor, Spieler } from '../PlaysFor';

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.css'],

})
export class PlayerDetailsComponent  implements OnInit  {
  constructor(){

  }
  @Input() Players : PlaysFor[];
  @Input()theplayer: Spieler;
  selectedFirstTabIndex = 0;
  selectedSecondTabIndices: number[] = [];

  playername: String;
  chart: any;
  ngOnInit() {
    
      this.chart = new CanvasJS.Chart('chartContainer', this.chartOptions);
      this.selectedSecondTabIndices = new Array(this.Players.length).fill(0);
      console.log()
    };
    
  playerId : number;
  chartOptions = {};
  pacDataPoints: DataPoint[]=[]

public getDataPoints(Players: PlaysFor[], yProperty: keyof PlaysFor): void {
  this.pacDataPoints = [];
  for (let index = 0; index < Players.length; index++) {
        const element = Players[index];
        this.pacDataPoints.push({ x: element.id.fifaVersion, y: element[yProperty] });
      }
      this.plot(this.pacDataPoints,yProperty);
      this.chart.render();
}
 
  public plot(data:DataPoint[],yProperty: keyof PlaysFor):any{
    console.log(yProperty);
    console.log(data);
    console.log(data);
  this.chartOptions = {
    animationEnabled: true,
    theme: "light2",
    title:{
    text: "Playerstats"
    },
    axisX: {
      interval: 1
    },
    axisY: {
    title: yProperty
    },
    toolTip: {
    shared: true
    },
    legend: {
    cursor: "pointer",
    itemclick: function (e: any) {
      if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
        e.dataSeries.visible = false;
      } else {
        e.dataSeries.visible = true;
      } 
      e.chart.render();
    }
    },
    data: [{
    type: "line",
    showInLegend: true,
    name: "Projected Sales",
    dataPoints: data
    },]
  }
  this.chart.data[0].addTo("dataPoints",data);
};
  getYPlot(yProperty: keyof PlaysFor): void {
    console.log(`Clicked on ${yProperty}`);
    this.getDataPoints(this.Players, yProperty);
    this.chart.render();

}
onFirstTabChange(index: number) {
  this.selectedFirstTabIndex = index;
}

onSecondTabChange(index: number, i: number) {
  this.selectedSecondTabIndices[i] = index;
}

}
