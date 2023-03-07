import { HttpErrorResponse } from '@angular/common/http';
import { Spieler, PlaysFor, DataPoint } from "./PlaysFor";
import { Component, OnInit  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CanvasJS } from 'src/assets/canvasjs.angular.component';
import { PlaysForService } from '../service/PlaysFor.service';
import { Router, ParamMap  } from '@angular/router';
import { switchMap, take } from 'rxjs/operators';
@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css'],
})
//@Author wafi for page details
export class PlayerComponent implements OnInit   {


  playername: String;
  chart: any;
  ngOnInit() {
      console.log(this.playername);
      this.playername  = this.route.snapshot.paramMap.get('knownName');
      this.getSpielerByFullName(this.playername);
      this.chart = new CanvasJS.Chart('chartContainer', this.chartOptions);



}

  playerId : number;
  selectedOption: string ="";
  chartOptions = {};
  public Players : PlaysFor[]=[];
  public theplayer:Spieler;
  pacDataPoints: DataPoint[]=[]
  map = new Map<string, number>();

  constructor(private playsForService:PlaysForService,private route: ActivatedRoute,){
    this.playername="L. Messi"
  }
  private getSpielerByFullName(name: String) {
    return this.playsForService.getSpielerByFullName(name).subscribe(
      (response:Spieler)=>{
        this.theplayer=response;
        this.playerId=response.id;
        console.log(this.playerId);
        console.log(this.theplayer);
        this.getPlaysForByPlayerIDId(this.playerId);

      },
      (error:HttpErrorResponse)=>{alert(error.message);
      });
    }

  public getPlaysForByPlayerIDId(id:number):void{
    this.playsForService.getPlaysForByPlayerIDId(id).subscribe(
      (response:PlaysFor[])=>{
        this.Players=response;
        console.log(this.Players);

      },
      (error:HttpErrorResponse)=>{alert(error.message);

      }
      );
  }


}
