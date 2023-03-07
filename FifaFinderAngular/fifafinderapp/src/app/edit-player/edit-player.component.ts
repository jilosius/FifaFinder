import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map, Observable, startWith } from 'rxjs';
import { AddDto } from '../interface/add-dto';
import { Club } from "../interface/club";
import { UpdateDto } from '../interface/update-dto';
import { ClubService } from "../service/club.service";
import { EditPlayerService } from '../service/edit-player.service';

//Author: Enes
function autocompleteObjectValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    if (typeof control.value.clubName === 'string') {
      return { 'invalidAutocompleteObject': { value: control.value } }
    }
    return null  /* valid option selected */
  }
}

@Component({
  selector: 'app-edit-player',
  templateUrl: './edit-player.component.html',
  styleUrls: ['./edit-player.component.css']
})  
//Author: Enes
export class EditPlayerComponent{
  playerId: number;
  fifaVersion: number;
  currentData: UpdateDto;


    AddForm = this.fb.group({
    knownName: ['default', Validators.required],
    fullName: ['default', Validators.required],
    age: [0, Validators.required],
    dateOfBirth: ['2000.01.01', Validators.required],
    fifaVersion: [0, Validators.required],
    weight: [0, Validators.required],
    height: [0, Validators.required],
    photoUrl: ['', Validators.required],
    valueEUR: [0, Validators.required],
    wage: [0, Validators.required],
    releaseClause: [0, Validators.required],
    clubPosition: ['', Validators.required],
    clubNumber: [0, Validators.required],
    contractUntil: [0, Validators.required],
    onLoan: ['', Validators.required],
    nationalPosition: ['', Validators.required],
    nationalNumber: [0, Validators.required],
    nationalTeam: ['', Validators.required],
    overall: [0, Validators.required],
    potential: [0, Validators.required],
    bestPosition: ['', Validators.required],
    intReputation: [0, Validators.required],
    preferredFoot: ['', Validators.required],
    weakFoot: [0, Validators.required],
    skillMoves: [0, Validators.required],
    crossing: [0, Validators.required],
    finishing: [0, Validators.required],
    headingAccuracy: [0, Validators.required],
    shortPassing: [0, Validators.required],
    volleys: [0, Validators.required],
    dribbling: [0, Validators.required],
    curve: [0, Validators.required],
    fkaccuracy: [0, Validators.required],
    longPassing: [0, Validators.required],
    ballControl: [0, Validators.required],
    acceleration: [0, Validators.required],
    sprintSpeed: [0, Validators.required],
    agility: [0, Validators.required],
    reaction: [0, Validators.required],
    balance: [0, Validators.required],
    shotPower: [0, Validators.required],
    jumping: [0, Validators.required],
    stamina: [0, Validators.required],
    strength: [0, Validators.required],
    longShots: [0, Validators.required],
    aggression: [0, Validators.required],
    interceptions: [0, Validators.required],
    positioning: [0, Validators.required],
    vision: [0, Validators.required],
    penalties: [0, Validators.required],
    composure: [0, Validators.required],
    marking: [0, Validators.required],
    standingTackle: [0, Validators.required],
    slidingTackle: [0, Validators.required],
    gkdiving: [0, Validators.required],
    gkhandling: [0, Validators.required],
    gkkicking: [0, Validators.required],
    gkpositioning: [0, Validators.required],
    gkreflexes: [0, Validators.required]
      });
      clubName = new FormControl('',{nonNullable: true, validators: [autocompleteObjectValidator(), Validators.required]});
      clubs: Club[] = [];
      filteredClubs: Observable<Club[]>;

  constructor(private editPlayerService: EditPlayerService,   private route: ActivatedRoute, private router: Router,private fb: FormBuilder, private clubService: ClubService) {};

  //Author:Enes
  public validation_msgs = {
    'clubName': [
      { type: 'invalidAutocompleteObject', message: 'Contact name not recognized. Click one of the autocomplete options.' },
      { type: 'required', message: 'Contact is required.' }
    ]}

  //Author:Enes
  private _filterClubs(value: string): Club[] {
    const filterValue = value.toLowerCase();
    return this.clubs.filter(club =>
    club.clubName.toLowerCase().includes(filterValue));
  }

  //Author: Jannik
  isAddMode(): boolean {
    const addMode = this.route.snapshot.paramMap.get('mode');
    if (addMode=="true") {
      return true;
    }
    return false;
  }

  //Author: Enes
  ngOnInit() {
    this.clubService.clubs$().subscribe( clubs  => {
      this.clubs = clubs;
    });
    this.filteredClubs = this.clubName.valueChanges.pipe(
      startWith(''),
      map(value => this._filterClubs(value || '')),
    );
    //Author:Jannik
    if(this.isAddMode()==false) {
      const playerId = this.route.snapshot.paramMap.get('playerId');
      this.playerId = Number(playerId);
      const fifaVersion = this.route.snapshot.paramMap.get('fifaVersion');
      this.fifaVersion = Number(fifaVersion);
      this.editPlayerService.details$(this.playerId, this.fifaVersion).subscribe( details => {
        this.currentData = details;
        console.log(this.currentData);
        this.clubName.setValue(this.currentData.clubName)
        this.AddForm.setValue({
          fullName: 'a',
          knownName: 'a',
          age: 0,
          dateOfBirth: 'a',
          fifaVersion: 0,
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
          fkaccuracy: this.currentData.fkaccuracy,
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
          gkdiving: this.currentData.gkdiving,
          gkhandling: this.currentData.gkhandling,
          gkkicking: this.currentData.gkkicking,
          gkpositioning: this.currentData.gkpositioning,
          gkreflexes: this.currentData.gkreflexes,
          photoUrl: this.currentData.photoUrl
        })
      });
    }
  }
  //Author:Jannik
  onEditPlayer(data: UpdateDto) {
    data.clubName = this.clubName.value;
    console.log(data);
    this.editPlayerService.updatePlayerDetails(data, this.playerId, this.fifaVersion);
  }
  //Author:Jannik
  onAddPlayer(data: AddDto) {
    data.clubName = this.clubName.value;
    console.log(data);
    this.editPlayerService.addPlayer(data);
  }

}

