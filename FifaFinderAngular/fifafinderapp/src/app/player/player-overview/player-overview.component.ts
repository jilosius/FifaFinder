import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { PlaysForService } from 'src/app/service/PlaysFor.service';
import { Mannschaften, PlaysFor, Spieler } from '../PlaysFor';
import {Sort} from '@angular/material/sort';
@Component({
  selector: 'app-player-overview',
  templateUrl: './player-overview.component.html',
  styleUrls: ['./player-overview.component.css']
})
export class PlayerOverviewComponent implements OnInit{
  constructor(private playsForService:PlaysForService){}
    
    
    ngOnInit(): void {
    }
  @Input() player: PlaysFor;
  @Input() theplayer: Spieler;

  
}

