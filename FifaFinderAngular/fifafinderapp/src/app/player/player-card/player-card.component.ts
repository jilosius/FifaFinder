import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { PlaysForService } from 'src/app/service/PlaysFor.service';
import { Mannschaften, PlaysFor, Spieler } from '../PlaysFor';
@Component({
  selector: 'app-player-card',
  templateUrl: './player-card.component.html',
  styleUrls: ['./player-card.component.css']
})
export class PlayerCardComponent implements OnInit{
  constructor(private playsForService:PlaysForService){
    
  };
  ngOnInit() { (this.player.acceleration*0.45+this.player.sprintSpeed*0.55)
         }


  @Input() player : PlaysFor;
  @Input()theplayer: Spieler;
  


  public calculate_pace():number{

    let val=  Math.round(this.player.acceleration*0.45+this.player.sprintSpeed*0.55);

    
    return val;
  }
  public  calculate_shouting():number{
    let val=  Math.round( this.player.positioning*0.05+this.player.finishing*0.45
          +this.player.penalties*0.2+this.player.shotPower*0.05
          +this.player.shotPower*0.2+this.player.volleys*0.005)
           ;
           
           if (Number.isNaN(val))
           return 0;
           
           return val;
  }
  public  calculate_passing():number{
    let val= Math.round( this.player.vision*0.05+this.player.crossing*0.45
          +this.player.curve*0.05+
          +this.player.shortPassing*0.05
    );
    
   
    
    return val;
  }
  public  calculate_dribling():number{
    let val=  Math.round( this.player.agility*0.1+this.player.balance*0.05
          +this.player.reaction*0.05+this.player.ballControl*0.3
          +this.player.dribbling*0.5);
          
         
          
          return val;
  }
  public  calculate_deffending():number{
    let val= Math.round(  this.player.intReputation*0.2+this.player.headingAccuracy*0.1
          +this.player.marking*0.3+this.player.slidingTackle*0.1
          +this.player.standingTackle*0.3);
          
       
          
          return val;
  }
  public  calculate_physical():number{
    let val=  Math.round( this.player.aggression*0.2+this.player.jumping*0.1
          +this.player.stamina*0.3+this.player.strength*0.1);
          
        
          
          return val;
  }
 
 

}
