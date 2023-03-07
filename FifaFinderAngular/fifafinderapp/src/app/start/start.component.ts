import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from "@angular/forms";
import { Router } from '@angular/router';
import { BehaviorSubject, catchError, map, Observable, of, startWith } from 'rxjs';
import { ApiResponse } from '../interface/api-response';
import { Club } from "../interface/club";
import { FifaVersion } from "../interface/fifaversion";
import { Page } from '../interface/page';
import { Spieler } from '../interface/spieler';
import { ClubService } from "../service/club.service";
import { DeletePlayerService } from "../service/delete-player.service";
import { SelectedPlayerService } from '../service/selected-player.service';
import { SpielerService } from '../service/start.service';
import { SortableColumn } from "../sorting/sortable-column";
import { PlaysForService } from '../service/PlaysFor.service';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
//Autor: Saif, Levi
//We are working with states: this means when the appState == 'APP_LOADING', the html elements and functions used are different to when it is 'APP_LOADED' or 'APP_ERROR'
export class StartComponent implements OnInit {
  spielerState$: Observable<{ appState: string, appData?: ApiResponse<Page>, error?: HttpErrorResponse }>; //Example: {'APP_LOADED', ApiResponse<Spieler>, error(optional}
  responseSubject = new BehaviorSubject<ApiResponse<Page>>(null); //Save the response to use out of map() function
  public currentPageSubject = new BehaviorSubject<number>(0); //Save observable at current page
  currentPage$ = this.currentPageSubject.asObservable();

  players: Spieler[];
  selectedPlayerIds: number[];
  selectedPlayers: Spieler[] = [];
  selectedFifaVersion: number;
  pagesToDisplay: number = 10;

  clubFilter = new FormControl('',{nonNullable: true});

  clubs: Club[] = [];
  filteredClubs: Observable<Club[]>;

  name: string;
  //defining variables that are used in the dropdown filter, Autor: Saif, Levi
  playerId: number;
  fifaVersion: number =  23;
  clubName: string;
  preferredFoot: string = "";
  ageMin: number= 0;
  ageMax: number= 100;
  overallMin: number=0;
  overallMax: number=100;
  potentialMin: number=0;
  potentialMax: number=100;
  heightMin: number=0;
  heightMax: number=300;
  minValue: number=0;
  maxValue: number=100000000000;
  minWage: number=0;
  maxWage: number=100000000000;
  minHeadingAccuracy: number=0;
  maxHeadingAccuracy: number=100;
  minVolleys: number=0;
  maxVolleys: number=100;
  minDribbling: number=0;
  maxDribbling: number=100;
  minCurve: number=0;
  maxCurve: number=100;
  minFkAccuracy: number=0;
  maxFkAccuracy: number=100;
  minAcceleration: number=0;
  maxAcceleration: number=100;
  minSprintSpeed: number=0;
  maxSprintSpeed: number=100;
  minAgility: number=0;
  maxAgility: number=100;
  minReaction: number=0;
  maxReaction:number=100;
  minBalance: number=0;
  maxBalance: number=100;
  minShotPower: number=0;
  maxShotPower: number=100;
  minJumping: number=0;
  maxJumping: number=100;
  minStamina: number=0;
  maxStamina: number=100;
  minAggression: number=0;
  maxAggression: number=100;
  minLongShots: number=0;
  maxLongShots: number=100;
  minCrossing: number=0;
  maxCrossing: number=100;
  minFinishing: number=0;
  maxFinishing: number=100;
  minShortPassing: number=0;
  maxShortPassing: number=100;

  pageNumber: number= 0;
  size: number= 20;

  //Autor: Levi
  //does the currency formatting on Value,Wage,etc. Columns
  formatter = new Intl.NumberFormat('de-DE', {
    style: 'currency',
    currency: 'EUR',
    minimumFractionDigits: 0,
    maximumFractionDigits: 0,
    notation: 'compact'
  });

  //Autor: Levi
  //saves the currently selected Sort
  currentSort: SortableColumn = new SortableColumn('overall', 'desc');

  //Autor: Levi
  //Array to set names and default sort direction of columns
  sortableColumns: Array<SortableColumn> = [
    new SortableColumn('age'),
    new SortableColumn('overall', 'desc'),
    new SortableColumn('potential'),
    new SortableColumn('value'),
    new SortableColumn('height'),
    new SortableColumn('weight'),
    new SortableColumn('headingAccuracy'),
    new SortableColumn('volleys'),
    new SortableColumn('dribbling'),
    new SortableColumn('curve'),
    new SortableColumn('fkAccuracy'),
    new SortableColumn('acceleration'),
    new SortableColumn('sprintSpeed'),
    new SortableColumn('agility'),
    new SortableColumn('reaction'),
    new SortableColumn('balance'),
    new SortableColumn('shotPower'),
    new SortableColumn('jumping'),
    new SortableColumn('stamina'),
    new SortableColumn('aggression'),
    new SortableColumn('longShots'),
    new SortableColumn('crossing'),
    new SortableColumn('finishing'),
    new SortableColumn('shortPassing'),
    new SortableColumn('wage')
  ];
  //Autor: Saif
  //Array to set the "hidden" attribute of each column to either true or false
  condArray:boolean[] = [true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true];

  constructor(private spielerService: SpielerService, private selectedPlayerService: SelectedPlayerService, private router: Router, private deletePlayerService: DeletePlayerService, private clubService: ClubService,private playsforservice:PlaysForService) { }

  //Autor: Saif, Levi
  //on app initialisation: start with: 'APP LOADING', then 'APP_LOADED', and if error return 'APP_ERROR'
  ngOnInit(): void {
    this.selectedPlayerService.selectedPlayerIds$.subscribe(
      selectedPlayerIds => {
        this.selectedPlayerIds = selectedPlayerIds;
        if (this.players){
          this.players.forEach(player => {
            if(this.selectedPlayerIds.includes(player.playerId)) {
              player.selected = true;
              this.selectedPlayers.push(player);
            }
          })
        };
      }
    );
    this.spielerState$ = this.spielerService.spieler$().pipe(
      map((response: ApiResponse<Page>) => {
        this.responseSubject.next(response);
        this.currentPageSubject.next(response.data.page.number);
        this.players = response.data.page.content;
        console.log(response);
        return ({ appState: 'APP_LOADED', appData: response });
      }),
      startWith({ appState: 'APP_LOADING' }),
      catchError((error: HttpErrorResponse) => {
        return of({ appState: 'APP_ERROR', error })
      }
      )
    );
    this.clubService.clubs$().subscribe( clubs  => {
      this.clubs = clubs;
    });
    this.filteredClubs = this.clubFilter.valueChanges.pipe(
      startWith(''),
      map(value => this._filterClubs(value || '')),
    );

  }
  //Autor: Levi
  //filters array of clubs by name
  private _filterClubs(value: string): Club[] {
    const filterValue = value.toLowerCase();
    return this.clubs.filter(club =>
    club.clubName.toLowerCase().includes(filterValue));
  }
  onNameClick(knownName: string) {
    this.router.navigate(['/PlayerComponent', knownName]);
  }




  //Autor: Saif, Levi
  //the method that does all the magic: boolean Array is checked to hide/unhide columns, then spielerService is used to return the data/page as required
  goToPage(name?: string,fifaVersion?:number,clubName?:string,preferredFoot?:string,minAge?: number,maxAge?: number,minOverall?: number, maxOverall?: number, minPotential?: number,maxPotential?: number,minHeight?: number,maxHeight?: number,minValue?: number,maxValue?: number,minWage?: number,maxWage?: number,minHeadingAccuracy?: number,maxHeadingAccuracy?: number,minVolleys?: number,maxVolleys?: number,minDribbling?: number, maxDribbling?: number,minCurve?: number,maxCurve?: number, minFkAccuracy?: number,maxFkAccuracy?: number,minAcceleration?: number,maxAcceleration?: number, minSprintSpeed?: number,maxSprintSpeed?: number,minAgility?: number, maxAgility?: number,minReaction?: number,maxReaction?:number,minBalance?: number,maxBalance?: number,minShotPower?: number,maxShotPower?: number, minJumping?: number,maxJumping?: number,minStamina?: number,maxStamina?: number,minAggression?: number,maxAggression?: number,minLongShots?: number,maxLongShots?: number,minCrossing?: number,maxCrossing?: number,minFinishing?: number,maxFinishing?: number,minShortPassing?: number,maxShortPassing?: number,
            pageNumber: number = 0, size: number = 20, sort?: string, order?: string): void {
    this.name = name;
    this.fifaVersion = fifaVersion;
    this.clubName = clubName;
    this.preferredFoot = preferredFoot;
    this.ageMin = minAge;
    this.ageMax =maxAge ;
    this.overallMin=minOverall  ;
    this.overallMax= maxOverall  ;
    this.potentialMin =minPotential ;
    this.potentialMax =maxPotential ;
    this.heightMin = minHeight;
    this.heightMax =maxHeight ;
    this.minValue =minValue ;
    this.maxValue = maxValue;
    this.minWage = minWage;
    this.maxWage =maxWage;
    this.minHeadingAccuracy=minHeadingAccuracy;
    this.maxHeadingAccuracy=maxHeadingAccuracy;
    this.minVolleys=minVolleys;
    this.maxVolleys=maxVolleys;
    this.minDribbling=minDribbling;
    this.maxDribbling=maxDribbling;
    this.minCurve=minCurve;
    this.maxCurve=maxCurve;
    this.minFkAccuracy=minFkAccuracy;
    this.maxFkAccuracy=maxFkAccuracy;
    this.minAcceleration=minAcceleration;
    this.maxAcceleration=maxAcceleration;
    this.minSprintSpeed=minSprintSpeed;
    this.maxSprintSpeed=maxSprintSpeed;
    this.minAgility=minAgility;
    this.maxAgility=maxAgility;
    this.minReaction=minReaction;
    this.maxReaction=maxReaction;
    this.minBalance=minBalance;
    this.maxBalance=maxBalance;
    this.minShotPower=minShotPower;
    this.maxShotPower=maxShotPower;
    this.minJumping=minJumping;
    this.maxJumping=maxJumping;
    this.minStamina=minStamina;
    this.maxStamina=maxStamina;
    this.minAggression=minAggression;
    this.maxAggression=maxAggression;
    this.minLongShots=minLongShots;
    this.maxLongShots=maxLongShots;
    this.minCrossing=minCrossing;
    this.maxCrossing=maxCrossing;
    this.minFinishing=minFinishing;
    this.maxFinishing=maxFinishing;
    this.minShortPassing=minShortPassing;
    this.maxShortPassing=maxShortPassing;
    sort = this.currentSort.column;
    order = this.currentSort.direction;

    var checkConditionMinArray:number[] = [minHeadingAccuracy,minVolleys,minDribbling,minCurve,minFkAccuracy,minAcceleration,minSprintSpeed,minAgility,minReaction,minBalance,minShotPower,minJumping,minStamina,minAggression,minLongShots,minCrossing,minFinishing,minShortPassing,minWage]
    var checkConditionMaxArray:number[] = [maxHeadingAccuracy,maxVolleys,maxDribbling,maxCurve,maxFkAccuracy,maxAcceleration,maxSprintSpeed,maxAgility,maxReaction,maxBalance,maxShotPower,maxJumping,maxStamina,maxAggression,maxLongShots,maxCrossing,maxFinishing,maxShortPassing,maxWage]


    for(let i=0; i < checkConditionMinArray.length; i++){
      if(checkConditionMinArray[i] != 0){
        this.condArray[i]=false;
      } else if (checkConditionMinArray[i] == 0){
        this.condArray[i]=true;
      }
        else if(checkConditionMaxArray[i] != 100){
        this.condArray[i]=false;
      }
      else if(checkConditionMaxArray[i] == 100){
        this.condArray[i]=true;
      }
    }


    this.spielerState$ = this.spielerService.spieler$(name, fifaVersion, clubName, preferredFoot, minAge, maxAge, minOverall, maxOverall, minPotential,maxPotential,minHeight,maxHeight,minValue,maxValue,minWage,maxWage,minHeadingAccuracy,maxHeadingAccuracy,minVolleys, maxVolleys,minDribbling,maxDribbling, minCurve, maxCurve,minFkAccuracy, maxFkAccuracy,minAcceleration,maxAcceleration,minSprintSpeed,maxSprintSpeed,minAgility, maxAgility, minReaction,maxReaction,minBalance,maxBalance,minShotPower,maxShotPower,minJumping,maxJumping,minStamina,maxStamina, minAggression,maxAggression, minLongShots, maxLongShots,minCrossing,maxCrossing,minFinishing,maxFinishing,minShortPassing, maxShortPassing, pageNumber, size, sort, order).pipe(
      map((response: ApiResponse<Page>) => {
        this.responseSubject.next(response);
        this.currentPageSubject.next(pageNumber);
        console.log(response);
        return ({ appState: 'APP_LOADED', appData: response });
      }),
      startWith({ appState: 'APP_LOADED', appData: this.responseSubject.value }),  //start with current reponse value, Autor: Saif
      catchError((error: HttpErrorResponse) => {
        return of({ appState: 'APP_ERROR', error })
      }
      )
    )
  }

  //Autor: Saif
  //Method responsible for next/prev page
  goToNextOrPreviousPage(direction?: string): void {
    this.goToPage(this.name,this.fifaVersion,this.clubName,this.preferredFoot,this.ageMin,this.ageMax,this.overallMin,this.overallMax,this.potentialMin,this.potentialMax,this.heightMin,this.heightMax,this.minValue,this.maxValue,
      this.minWage,this.maxWage,this.minHeadingAccuracy,this.maxHeadingAccuracy,this.minVolleys,this.maxVolleys,this.minDribbling,this.maxDribbling,this.minCurve,this.maxCurve,this.minFkAccuracy,this.maxFkAccuracy,
      this.minAcceleration,this.maxAcceleration,this.minSprintSpeed,this.maxSprintSpeed,this.minAgility,this.maxAgility,this.minReaction,this.maxReaction,this.minBalance,this.maxBalance,this.minShotPower,
      this.maxShotPower,this.minJumping,this.maxJumping,this.minStamina,this.maxStamina,this.minAggression,this.maxAggression,this.minLongShots,this.maxLongShots,this.minCrossing,this.maxCrossing,this.minFinishing,
      this.maxFinishing,this.minShortPassing,this.maxShortPassing,
                  direction === 'forward' ? this.currentPageSubject.value + 1  : this.currentPageSubject.value - 1, 20);
                  console.log(this.currentPageSubject.value);
  }

  //Autor: Saif, Levi
  //reset values in filter
  resetValues(name?:string):void{
    this.fifaVersion = 23;
    this.clubName = '';
    this.clubFilter.reset();
    this.preferredFoot = '';
    this.ageMin = 0;
    this.ageMax = 100;
    this.overallMin = 0;
    this.overallMax = 100;
    this.potentialMin= 0;
    this.potentialMax= 100;
    this.heightMin= 0;
    this.heightMax= 300;
    this.minValue= 0;
    this.maxValue= 100000000000;
    this.minWage= 0;
    this.maxWage= 100000000000;
    this.minHeadingAccuracy = 0;
    this.maxHeadingAccuracy = 100;
    this.minVolleys= 0;
    this.maxVolleys= 100;
    this.minDribbling= 0;
    this.maxDribbling= 100;
    this.minCurve= 0;
    this.maxCurve= 100;
    this.minFkAccuracy= 0;
    this.maxFkAccuracy= 100;
    this.minAcceleration= 0;
    this.maxAcceleration= 100;
    this.minSprintSpeed= 0;
    this.maxSprintSpeed= 100;
    this.minAgility= 0;
    this.maxAgility= 100;
    this.minReaction= 0;
    this.maxReaction= 100;
    this.minBalance= 0;
    this.maxBalance= 100;
    this.minShotPower= 0;
    this.maxShotPower= 100;
    this.minJumping= 0;
    this.maxJumping= 100;
    this.minStamina= 0;
    this.maxStamina= 100;
    this.minAggression= 0;
    this.maxAggression= 100;
    this.minLongShots= 0;
    this.maxLongShots= 100;
    this.minCrossing= 0;
    this.maxCrossing= 100;
    this.minFinishing= 0;
    this.maxFinishing= 100;
    this.minShortPassing= 0;
    this.maxShortPassing= 100;
    this.goToPage(name,this.fifaVersion,this.clubName,this.preferredFoot,this.ageMin,this.ageMax,this.overallMin,this.overallMax,this.potentialMin,this.potentialMax,this.heightMin,this.heightMax,this.minValue,this.maxValue,
      this.minWage,this.maxWage,this.minHeadingAccuracy,this.maxHeadingAccuracy,this.minVolleys,this.maxVolleys,this.minDribbling,this.maxDribbling,this.minCurve,this.maxCurve,this.minFkAccuracy,this.maxFkAccuracy,
      this.minAcceleration,this.maxAcceleration,this.minSprintSpeed,this.maxSprintSpeed,this.minAgility,this.maxAgility,this.minReaction,this.maxReaction,this.minBalance,this.maxBalance,this.minShotPower,
      this.maxShotPower,this.minJumping,this.maxJumping,this.minStamina,this.maxStamina,this.minAggression,this.maxAggression,this.minLongShots,this.maxLongShots,this.minCrossing,this.maxCrossing,this.minFinishing,
      this.maxFinishing,this.minShortPassing,this.maxShortPassing);
  }

  //Autor: Saif
  //responsible for selecting players in der Startseite and adding them to an array
  toggleSelection(spieler: Spieler) {
    spieler.selected = !spieler.selected;
    const existingPlayer = this.selectedPlayers.find(s => s.playerId === spieler.playerId);
    if (spieler.selected && !existingPlayer) {
      this.selectedPlayers.push(spieler);
    } else if (!spieler.selected && existingPlayer) {
      this.selectedPlayers = this.selectedPlayers.filter(s => s.playerId !== spieler.playerId);
      this.selectedPlayerIds = this.selectedPlayerIds.filter(id => id !== spieler.playerId);
    }
    this.selectedPlayerService.setSelectedPlayerIds(this.selectedPlayerIds);
  }

  //Autor: Saif
  //go to Vergleich with the selected players array
  getSelectedPlayerIds() {
    if (this.selectedPlayers.length < 2) {
      alert("Please select at least 2 players!");
      return;
    }

    else {
      this.selectedPlayerIds = this.selectedPlayers.map(spieler => spieler.playerId);
      this.selectedPlayerService.setSelectedPlayerIds(this.selectedPlayerIds);
      this.selectedPlayerService.setSelectedFifaVersion(this.selectedFifaVersion);
      this.router.navigate(['/vergleich']); // navigate programmatically only if at least 2 players are selected
    }


  }



//Autor: Levi
//Holds the sorting logic and calls the goToPage function to load the sorted list of players
  sortByColumn(
    sort: SortableColumn
  ): void {
    sort.toggleDirection();
    if(sort.direction == null){
      this.resetSort();
      sort = this.sortableColumns[1];
    }
    this.clearPreviousSorting(sort); // Make sortableColumns array not "remember" previous sorting of other columns
    this.currentSort = sort;
    this.goToPage(
      this.name,
      this.fifaVersion,
      this.clubName,
      this.preferredFoot,
      this.ageMin,
      this.ageMax,
      this.overallMin,
      this.overallMax,
      this.potentialMin,
      this.potentialMax,
      this.heightMin,
      this.heightMax,
      this.minValue,
      this.maxValue,
      this.minWage,
      this.maxWage,
      this.minHeadingAccuracy,
      this.maxHeadingAccuracy,
      this.minVolleys,
      this.maxVolleys,
      this.minDribbling,
      this.maxDribbling,
      this.minCurve,
      this.maxCurve,
      this.minFkAccuracy,
      this.maxFkAccuracy,
      this.minAcceleration,
      this.maxAcceleration,
      this.minSprintSpeed,
      this.maxSprintSpeed,
      this.minAgility,
      this.maxAgility,
      this.minReaction,
      this.maxReaction,
      this.minBalance,
      this.maxBalance,
      this.minShotPower,
      this.maxShotPower,
      this.minJumping,
      this.maxJumping,
      this.minStamina,
      this.maxStamina,
      this.minAggression,
      this.maxAggression,
      this.minLongShots,
      this.maxLongShots,
      this.minCrossing,
      this.maxCrossing,
      this.minFinishing,
      this.maxFinishing,
      this.minShortPassing,
      this.maxShortPassing,
      0,
      20
    );
  }

  //Autor: Levi
  //filters the sortableColumns array for the columns not chosen to be sorted by and resets their direction to null
  clearPreviousSorting(chosenColumn: SortableColumn) {
    this.sortableColumns.filter(
      column => column != chosenColumn
    ).forEach(
      column => column.direction = null
    );
  }

  //Autor: Levi
  //needed for cycling through the sorting options back to the default sort (overall)
  resetSort(){
    this.sortableColumns.filter(
      checkColumn => checkColumn.column != 'overall'
    ).forEach(
      checkColumn => checkColumn.direction = null
    );
    this.sortableColumns[1].direction = 'desc';
  }

  //Autor: Levi
  //returns an arrow(or not) corresponding to whether the column has been selected as the current sort
  sortArrow(columnName: string) {
    if (this.currentSort.column === columnName) {
      switch (this.currentSort.direction) {
        case 'desc':
          return '&#9660;'; // downarrow
        case 'asc':
          return '&#9650;'; // uparrow
        default:
          break;
      }
    }
    return '';
  }

  //Autor: Levi
  //Simply reloads the page
  refresh(){
    window.location.reload();
  }

  //Autor: Levi
  //Delete for every Fifaversion
  deleteAllLogic(id: number){
    if(confirm("Wollen Sie den Spieler wirklich löschen?")) {
      this.deletePlayerService.deletePlayer(id).subscribe();
      this.refresh();
    }
  }

  //Autor: Levi
  //Delete for only one FifaVersion
  deletePerFifaVersionLogic(id:number, fifaVersion: number){
    if(confirm("Wollen Sie den Spielereintrag zu FIFA " + fifaVersion + " wirklich löschen?")) {
      this.deletePlayerService.deletePlayerInFifaVersion(id, fifaVersion).subscribe();
      this.refresh();
    }
  }

  onFifaVersionChange(fifaVersion: number) {
    this.selectedFifaVersion = fifaVersion;
  }

  //Autor: Saif
  //responsible for pagination and page numbers
  shouldShowPage(index:number, currentPage:number) {
    const start = currentPage - 5;
    const end = currentPage + 5;
    return index >= start && index <= end && index <= (start + 10) && index >= (end - 10);
  }

}


