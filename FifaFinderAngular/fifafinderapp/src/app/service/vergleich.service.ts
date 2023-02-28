import { Injectable, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Spieler } from '../interface/spieler';
import { SpielerService } from './start.service';
import { StartComponent } from '../start/start.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VergleichService {
  private readonly serverUrl: string = 'http://localhost:8080/players/start/vergleich';

  selectedSpieler$ = (
    player1Id:number = 0,
    player2Id:number = 0,
    player3Id:number = 0,
    player4Id:number = 0,
    player5Id:number = 0,
    fifaVersion:number = 23


  ) : Observable<Spieler[]> => this.http.get<Spieler[]>(`${this.serverUrl}?player1Id=${player1Id}&player2Id=${player2Id}&player3Id=${player3Id}&player4Id=${player4Id}&player5Id=${player5Id}&fifaVersion=${fifaVersion}`);

  constructor(private http: HttpClient) { }


  // getSpielerToCompare(){
  //   return this.http.get<Spieler[]>(this.serverUrl);
  // }

}
