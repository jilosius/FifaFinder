import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { addPlayerService } from '../service/addPlayer.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent {
  private readonly addPlayerUrl: string = 'http://localhost:8080/playsFor/add';
  constructor(private http: HttpClient){}

  createPlayer(players: {knownName: string, fullName: string, age: number, weight: number,
     height: number, PhotoURL: string, DateOfBirth: Date, fifaVersion: number,
     clubPosition: string, clubNumber: number, clubID: number, nationalPosition: string,
    nationalNumber: number, nationalTeam: string, contractUntil: number, onLoan: string, 
    valueEur: number, wage: number, releaseClause: number, Overall: number, Potential: number, 
    bestPosition: string, Reputation: number, preferredFoot: string, weakFoot: number, 
    skillMoves: number, Crossing: number, Finishing: number, HeadingAccuracy: number, 
    ShortPassing: number, Volleys: number, Dribbling: number, Curve: number, FKAccuracy: number, 
    LongPassing: number, BallControl: number, Acceleration: number, Sprintspeed: number, 
    Agility: number, Reaction: number, Balance: number, ShotPower: number, Jumping: number, 
    Stamina: number, Strength: number, LongShots: number, Aggression: number, Interception: number, 
    Positioning: number, Vision: number, Penalties: number, Composure: number, Marking: number, 
    StandingTackle: number, SlidingTackle: number, GKDiving: number, GKHandling: number, 
    GKKicking: number, GKPositioning: number, GKReflexes: number}){
  
  
      console.log(players);

    this.http.post(this.addPlayerUrl, players).subscribe((response) => {
      console.log(response); 
    }) 

  }

}
