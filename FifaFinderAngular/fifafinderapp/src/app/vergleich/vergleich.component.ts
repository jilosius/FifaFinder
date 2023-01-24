// Vergleich.component.ts
import { Component, OnInit } from '@angular/core';

import { Spieler } from '../interface/spieler';
import { SelectedPlayerService } from '../services/selected-player.service';
import { VergleichService } from '../services/vergleich.service';

@Component({
  selector: 'app-vergleich',
  templateUrl: './vergleich.component.html',
  styleUrls: ['./vergleich.component.css']
})
export class VergleichComponent implements OnInit {
  spieler: Spieler[];
  selectedPlayerIds: number[];
  

  constructor(private vergleichService: VergleichService, private selectedPlayerService: SelectedPlayerService) { }

  ngOnInit(): void {
    this.selectedPlayerIds = this.selectedPlayerService.getSelectedPlayerIds();
    this.vergleichService.selectedSpieler$(
      this.selectedPlayerIds[0],
      this.selectedPlayerIds[1],
      this.selectedPlayerIds[2],
      this.selectedPlayerIds[3],
      this.selectedPlayerIds[4]).subscribe(
      (data: Spieler[]) => {
        this.spieler = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

}