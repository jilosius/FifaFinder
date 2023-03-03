import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UpdateDto } from '../interface/update-dto';
import { EditPlayerService } from '../service/edit-player.service';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import { switchMap, take } from 'rxjs/operators';
import { AddDto } from '../interface/add-dto';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-edit-player',
  templateUrl: './edit-player.component.html',
  styleUrls: ['./edit-player.component.css']
})
export class EditPlayerComponent{
  playerId: number;
  fifaVersion: number;
  currentData: UpdateDto;
  @ViewChild('playerDetailsForm') form: NgForm;

  constructor(private editPlayerService: EditPlayerService,   private route: ActivatedRoute, private router: Router,) {};

  isAddMode(): boolean {
    const addMode = this.route.snapshot.paramMap.get('mode');
    if (addMode=="true") {
      return true;
    }
    return false;
  }

  ngOnInit() {
    if(this.isAddMode()==false) {
      const playerId = this.route.snapshot.paramMap.get('playerId');
      this.playerId = Number(playerId);
      const fifaVersion = this.route.snapshot.paramMap.get('fifaVersion');
      this.fifaVersion = Number(fifaVersion);
      this.editPlayerService.details$(this.playerId, this.fifaVersion).subscribe( details => {
        this.currentData = details;
        this.form.setValue({
          weight: this.currentData.weight,
          height: this.currentData.height,
          clubPosition: this.currentData.clubPosition,
          clubNumber: this.currentData.clubNumber,
          nationalPosition: this.currentData.nationalPosition,
          nationalNumber: this.currentData.nationalNumber,
          preferredFoot: this.currentData.preferredFoot,
          contractUntil: this.currentData.contractUntil,
          onLoan: this.currentData.onLoan,
          nationalTeam: this.currentData.nationalTeam,
          overall: this.currentData.overall,
          potential: this.currentData.potential,
          bestPosition: this.currentData.bestPosition,
          clubName: this.currentData.clubName,
          valueEUR: this.currentData.valueEUR,
          wage: this.currentData.wage,
          releaseClause: this.currentData.releaseClause,
          intReputation: this.currentData.intReputation,
          weakFoot:this.currentData.weakFoot,
          skillMoves: this.currentData.skillMoves,
          crossing: this.currentData.crossing,
          finishing: this.currentData.finishing,
          headingAccuracy: this.currentData.headingAccuracy,
          shortPassing: this.currentData.shortPassing,
          volleys: this.currentData.volleys,
          dribbling: this.currentData.dribbling,
          curve: this.currentData.curve,
          fKAccuracy: this.currentData.fKAccuracy,
          longPassing: this.currentData.longPassing,
          ballControl: this.currentData.ballControl,
          acceleration: this.currentData.acceleration,
          sprintSpeed: this.currentData.sprintSpeed,
          agility: this.currentData.agility,
          reaction: this.currentData.reaction,
          balance: this.currentData.balance,
          shotPower: this.currentData.shotPower,
          jumping: this.currentData.jumping,
          stamina: this.currentData.stamina,
          strength: this.currentData.strength,
          longShots: this.currentData.longShots,
          aggression: this.currentData.aggression,
          interceptions: this.currentData.interceptions,
          positioning: this.currentData.positioning,
          vision: this.currentData.vision,
          penalties: this.currentData.penalties,
          composure: this.currentData.composure,
          marking: this.currentData.marking,
          standingTackle: this.currentData.standingTackle,
          slidingTackle: this.currentData.slidingTackle,
          gKDiving: this.currentData.gKDiving,
          gKHandling: this.currentData.gKHandling,
          gKKicking: this.currentData.gKKicking,
          gKPositioning: this.currentData.gKPositioning,
          gKReflexes: this.currentData.gKReflexes,
          photoUrl: this.currentData.photoUrl
        })
      });
    }
  }

  onEditPlayer(data: UpdateDto) {
    console.log(data);
    this.editPlayerService.updatePlayerDetails(data, this.playerId, this.fifaVersion);
  }

  onAddPlayer(data: AddDto) {
    console.log(data);
    this.editPlayerService.addPlayer(data);
  }
}

