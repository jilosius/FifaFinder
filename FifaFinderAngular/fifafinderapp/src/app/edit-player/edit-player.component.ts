import { Component, Injectable, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UpdateDto } from '../interface/update-dto';
import { EditPlayerService } from '../service/edit-player.service';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AddDto } from '../interface/add-dto';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';

@Component({
  selector: 'app-edit-player',
  templateUrl: './edit-player.component.html',
  styleUrls: ['./edit-player.component.css']
})
export class EditPlayerComponent{
  

    AddForm = this.fb.group({
    knownName: ['Mustermann', Validators.required],
    fullName: ['Max', Validators.required],
    age: ['18', Validators.required],
    DateOfBirth: ['2020.01.01', Validators.required],
    fifaVersion: ['18', Validators.required],
    weight: ['', Validators.required],
    height: ['', Validators.required],
    PhotoURL: ['', Validators.required],
    valueEur: ['', Validators.required],
    wage: ['', Validators.required],
    releaseClause: ['', Validators.required],
    clubPosition: ['', Validators.required],
    clubNumber: ['', Validators.required],
    clubName: ['', Validators.required],
    contractUntil: ['', Validators.required],
    onLoan: ['', Validators.required],
    nationalPosition: ['', Validators.required],
    nationalNumber: ['', Validators.required],
    nationalTeam: ['', Validators.required],
    Overall: ['', Validators.required],
    Potential: ['', Validators.required],
    bestPosition: ['', Validators.required],
    Reputation: ['', Validators.required],
    preferredFoot: ['', Validators.required],
    weakFoot: ['', Validators.required],
    skillMoves: ['', Validators.required],
    Crossing: ['', Validators.required],
    Finishing: ['', Validators.required],
    HeadingAccuracy: ['', Validators.required],
    ShortPassing: ['', Validators.required],
    Volleys: ['', Validators.required],
    Dribbling: ['', Validators.required],
    Curve: ['', Validators.required],
    FKAccuracy: ['', Validators.required],
    LongPassing: ['', Validators.required],
    BallControl: ['', Validators.required],
    Acceleration: ['', Validators.required],
    Sprintspeed: ['', Validators.required],
    Agility: ['', Validators.required],
    Reaction: ['', Validators.required],
    Balance: ['', Validators.required],
    ShotPower: ['', Validators.required],
    Jumping: ['', Validators.required],
    Stamina: ['', Validators.required],
    Strength: ['', Validators.required],
    LongShots: ['', Validators.required],
    Aggression: ['', Validators.required],
    Interceptions: ['', Validators.required],
    Positioning: ['', Validators.required],
    Vision: ['', Validators.required],
    Penalties: ['', Validators.required],
    Composure: ['', Validators.required],
    Marking: ['', Validators.required],
    StandingTackle: ['', Validators.required],
    SlidingTackle: ['', Validators.required],
    GKDiving: ['', Validators.required],
    GKHandling: ['', Validators.required],
    GKKicking: ['', Validators.required],
    GKPositioning: ['', Validators.required],
    GKReflexes: ['', Validators.required]
      }); 

  constructor(private editPlayerService: EditPlayerService,   private route: ActivatedRoute, private router: Router,private fb: FormBuilder) {};

  isAddMode(): boolean {
    const addMode = this.route.snapshot.paramMap.get('mode');
    if (addMode=="true") {
      return true;
    }
    return false;
  }

  onEditPlayer(data: UpdateDto) {
    this.editPlayerService.updatePlayerDetails(data, 158023, 23);
  }

  onAddPlayer(data: AddDto) {
    this.editPlayerService.addPlayer(data);
  }

}

