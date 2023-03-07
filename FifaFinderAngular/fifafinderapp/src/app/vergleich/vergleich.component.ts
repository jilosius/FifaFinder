// Vergleich.component.ts
import { Component, OnInit } from '@angular/core';

import { Spieler } from '../interface/spieler';
import { SelectedPlayerService } from '../service/selected-player.service';
import { VergleichService } from '../service/vergleich.service';

@Component({
  selector: 'app-vergleich',
  templateUrl: './vergleich.component.html',
  styleUrls: ['./vergleich.component.css']
})
export class VergleichComponent implements OnInit {
  spieler: Spieler[];
  selectedPlayerIds: number[];
  selectedFifaVersion: number;
  highestOverall: number;
  highestPotential:number;
  highestHeadingAccuracy: number;
  highestVolleys: number;
  highestDribbling: number;
  highestCurve: number;
  highestAcceleration: number;
  highestSprintSpeed: number;
  highestAgility: number;
  highestReaction: number;
  highestShotPower: number;
  highestJumping: number;
  highestStamina: number;
  highestAggression: number;
  highestLongShots: number;
  highestCrossing: number;
  highestFinishing: number;
  highestShortPassing: number;
  highestWage: number;
  highestValueEUR: number;
  highestHeight: number;

  lowestOverall: number;
  lowestPotential:number;
  lowestHeadingAccuracy: number;
  lowestVolleys: number;
  lowestDribbling: number;
  lowestCurve: number;
  lowestAcceleration: number;
  lowestSprintSpeed: number;
  lowestAgility: number;
  lowestReaction: number;
  lowestShotPower: number;
  lowestJumping: number;
  lowestStamina: number;
  lowestAggression: number;
  lowestLongShots: number;
  lowestCrossing: number;
  lowestFinishing: number;
  lowestShortPassing: number;
  lowestWage: number;
  lowestValueEUR: number;
  lowestHeight: number;



  constructor(private vergleichService: VergleichService, private selectedPlayerService: SelectedPlayerService) { }

  ngOnInit(): void {
    this.selectedPlayerService.selectedPlayerIds$.subscribe(
      selectedPlayerIds => {
        this.selectedPlayerIds = selectedPlayerIds;
        this.selectedFifaVersion = this.selectedPlayerService.getSelectedFifaVersion();
        this.vergleichService.selectedSpieler$(
          this.selectedPlayerIds[0],
          this.selectedPlayerIds[1],
          this.selectedPlayerIds[2],
          this.selectedPlayerIds[3],
          this.selectedPlayerIds[4],
          this.selectedFifaVersion
          ).subscribe(
          (data: Spieler[]) => {
            this.spieler = data;
            //Check highest value of every row to highlight in green
            this.highestOverall = Math.max(...this.spieler.map(s => s.overall));
            this.highestPotential = Math.max(...this.spieler.map(s => s.potential));
            this.highestValueEUR = Math.max(...this.spieler.map(s => s.valueEUR));
            this.highestHeight = Math.max(...this.spieler.map(s => s.height));
            this.highestHeadingAccuracy = Math.max(...this.spieler.map(s => s.headingAccuracy));
            this.highestVolleys = Math.max(...this.spieler.map(s => s.volleys));
            this.highestDribbling = Math.max(...this.spieler.map(s => s.dribbling));
            this.highestCurve = Math.max(...this.spieler.map(s => s.curve));
            this.highestAcceleration = Math.max(...this.spieler.map(s => s.acceleration));
            this.highestSprintSpeed = Math.max(...this.spieler.map(s => s.sprintSpeed));
            this.highestAgility = Math.max(...this.spieler.map(s => s.agility));
            this.highestReaction = Math.max(...this.spieler.map(s => s.reaction));
            this.highestShotPower = Math.max(...this.spieler.map(s => s.shotPower));
            this.highestJumping = Math.max(...this.spieler.map(s => s.jumping));
            this.highestStamina = Math.max(...this.spieler.map(s => s.stamina));
            this.highestAggression = Math.max(...this.spieler.map(s => s.aggression));
            this.highestLongShots = Math.max(...this.spieler.map(s => s.longShots));
            this.highestCrossing = Math.max(...this.spieler.map(s => s.crossing));
            this.highestFinishing = Math.max(...this.spieler.map(s => s.fifaVersion));
            this.highestShortPassing = Math.max(...this.spieler.map(s => s.shortPassing));
            this.highestWage = Math.max(...this.spieler.map(s => s.wage));

          },
          (error) => {
            console.log(error);
          }
        );
      }
    );
    }
}