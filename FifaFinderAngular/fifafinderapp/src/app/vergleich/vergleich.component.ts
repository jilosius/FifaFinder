// Vergleich.component.ts
import { Component, OnInit } from '@angular/core';

import { Spieler } from '../interface/spieler';
import { SelectedPlayerService } from '../services/selected-player.service';
import { VergleichService } from '../services/vergleich.service';
import { StartComponent } from '../start/start.component';

@Component({
  selector: 'app-vergleich',
  templateUrl: './vergleich.component.html',
  styleUrls: ['./vergleich.component.css']
})
export class VergleichComponent implements OnInit {
  spieler: Spieler[];
  selectedPlayerIds: number[];
  selectedFifaVersion: number;
  

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
          },
          (error) => {
            console.log(error);
          }
        );
      }
    );
    }
}