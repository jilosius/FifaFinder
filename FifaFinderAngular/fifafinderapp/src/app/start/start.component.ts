import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, BehaviorSubject, map, startWith, catchError, of } from 'rxjs';
import { ApiResponse } from '../interface/api-response';
import { Page } from '../interface/page';
import { SpielerService } from '../service/start.service';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})

//We are working with states: this means when the appState == 'APP_LOADING', the html elements and functions used are different to when it is 'APP_LOADED' or 'APP_ERROR'
export class StartComponent implements OnInit {
  spielerState$: Observable<{ appState: string, appData?: ApiResponse<Page>, error?: HttpErrorResponse }>; //Example: {'APP_LOADED', ApiResponse<Spieler>, error(optional} 
  responseSubject = new BehaviorSubject<ApiResponse<Page>>(null); //Save the response to use out of map() function
  private currentPageSubject = new BehaviorSubject<number>(0); //Save observable at current page
  currentPage$ = this.currentPageSubject.asObservable();
  
  //defining variables that are used in the dropdown filter 
  fifaVersion: number;
  preferredFoot: string = "";
  ageMin: number;
  ageMax: number;
  overallMin: number;
  overallMax: number;
  potentialMin: number;
  potentialMax: number;
  heightMin: number;
  heightMax: number;
  minValue: number;
  maxValue: number;
  minWage: number;
  maxWage: number;
  minHeadingAccuracy: number;
  maxHeadingAccuracy: number;
  minVolleys: number;
  maxVolleys: number;
  minDribbling: number;
  maxDribbling: number;
  minCurve: number;
  maxCurve: number;
  minFkAccuracy: number;
  maxFkAccuracy: number;
  minAcceleration: number;
  maxAcceleration: number;
  minSprintSpeed: number;
  maxSprintSpeed: number;
  minAgility: number;
  maxAgility: number;
  minReaction: number;
  maxReaction:number;
  minBalance: number;
  maxBalance: number;
  minShotPower: number;
  maxShotPower: number;
  minJumping: number;
  maxJumping: number;
  minStamina: number;
  maxStamina: number;
  minAggression: number;
  maxAggression: number;
  minLongShots: number;
  maxLongShots: number;
  minCrossing: number;
  maxCrossing: number;
  minFinishing: number;
  maxFinishing: number;
  minShortPassing: number;
  maxShortPassing: number;

  //Array to set the "hidden" attribute of each column to either true or false
  condArray:boolean[] = [true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true]

  constructor(private spielerService: SpielerService) { }

  //on app initialisation: start with: 'APP LOADING', then 'APP_LOADED', and if error return 'APP_ERROR'
  ngOnInit(): void {
    this.spielerState$ = this.spielerService.spieler$().pipe(
      map((response: ApiResponse<Page>) => {
        this.responseSubject.next(response);  //response subject contains response for later use
        this.currentPageSubject.next(response.data.page.number);
        console.log(response);
        return ({ appState: 'APP_LOADED', appData: response });
      }),
      startWith({ appState: 'APP_LOADING' }),
      catchError((error: HttpErrorResponse) => {
        return of({ appState: 'APP_ERROR', error })
      }
      )
    )
  }

  //the method that does all the magic: boolean Array is checked to hide/unhide columns, then spielerService is used to return the data/page as required
  goToPage(name?: string,fifaVersion?:number,preferredFoot?:string,minAge?: number,maxAge?: number,minOverall?: number, maxOverall?: number, minPotential?: number,maxPotential?: number,minHeight?: number,maxHeight?: number,minValue?: number,maxValue?: number,minWage?: number,maxWage?: number,minHeadingAccuracy?: number,maxHeadingAccuracy?: number,minVolleys?: number,maxVolleys?: number,minDribbling?: number, maxDribbling?: number,minCurve?: number,maxCurve?: number, minFkAccuracy?: number,maxFkAccuracy?: number,minAcceleration?: number,maxAcceleration?: number, minSprintSpeed?: number,maxSprintSpeed?: number,minAgility?: number, maxAgility?: number,minReaction?: number,maxReaction?:number,minBalance?: number,maxBalance?: number,minShotPower?: number,maxShotPower?: number, minJumping?: number,maxJumping?: number,minStamina?: number,maxStamina?: number,minAggression?: number,maxAggression?: number,minLongShots?: number,maxLongShots?: number,minCrossing?: number,maxCrossing?: number,minFinishing?: number,maxFinishing?: number,minShortPassing?: number,maxShortPassing?: number,
            pageNumber: number = 0): void {
    fifaVersion = this.fifaVersion;
    preferredFoot = this.preferredFoot;
    minAge = this.ageMin;
    maxAge = this.ageMax;
    minOverall = this.overallMin;
    maxOverall = this.overallMax;
    minPotential = this.potentialMin;
    maxPotential = this.potentialMax;
    minHeight = this.heightMin;
    maxHeight = this.heightMax;
    minValue = this.minValue;
    maxValue = this.maxValue;
    minWage = this.minWage;
    maxWage = this.maxWage;
    minHeadingAccuracy=this.minHeadingAccuracy;
    maxHeadingAccuracy=this.maxHeadingAccuracy;
    minVolleys=this.minVolleys;
    maxVolleys=this.maxVolleys;
    minDribbling=this.minDribbling;
    maxDribbling=this.maxDribbling;
    minCurve=this.minCurve;
    maxCurve=this.maxCurve;
    minFkAccuracy=this.minFkAccuracy;
    maxFkAccuracy=this.maxFkAccuracy;
    minAcceleration=this.minAcceleration;
    maxAcceleration=this.maxAcceleration;
    minSprintSpeed=this.minSprintSpeed;
    maxSprintSpeed=this.maxSprintSpeed;
    minAgility=this.minAgility;
    maxAgility=this.maxAgility;
    minReaction=this.minReaction;
    maxReaction=this.maxReaction;
    minBalance=this.minBalance;
    maxBalance=this.maxBalance;
    minShotPower=this.minShotPower;
    maxShotPower=this.maxShotPower;
    minJumping=this.minJumping;
    maxJumping=this.maxJumping;
    minStamina=this.minStamina;
    maxStamina=this.maxStamina;
    minAggression=this.minAggression;
    maxAggression=this.maxAggression;
    minLongShots=this.minLongShots;
    maxLongShots=this.maxLongShots;
    minCrossing=this.minCrossing;
    maxCrossing=this.maxCrossing;
    minFinishing=this.minFinishing;
    maxFinishing=this.maxFinishing;
    minShortPassing=this.minShortPassing;
    maxShortPassing=this.maxShortPassing;
    
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
    

    this.spielerState$ = this.spielerService.spieler$(name, fifaVersion,preferredFoot, minAge, maxAge, minOverall, maxOverall, minPotential,maxPotential,minHeight,maxHeight,minValue,maxValue,minWage,maxWage,minHeadingAccuracy,maxHeadingAccuracy,minVolleys, maxVolleys,minDribbling,maxDribbling, minCurve, maxCurve,minFkAccuracy, maxFkAccuracy,minAcceleration,maxAcceleration,minSprintSpeed,maxSprintSpeed,minAgility, maxAgility, minReaction,maxReaction,minBalance,maxBalance,minShotPower,maxShotPower,minJumping,maxJumping,minStamina,maxStamina, minAggression,maxAggression, minLongShots, maxLongShots,minCrossing,maxCrossing,minFinishing,maxFinishing,minShortPassing, maxShortPassing,
      pageNumber).pipe(
      map((response: ApiResponse<Page>) => {
        this.responseSubject.next(response);
        this.currentPageSubject.next(pageNumber);
        console.log(response);
        return ({ appState: 'APP_LOADED', appData: response });
      }),
      startWith({ appState: 'APP_LOADED', appData: this.responseSubject.value }),  //start with current reponse value
      catchError((error: HttpErrorResponse) => {
        return of({ appState: 'APP_ERROR', error })
      }
      )
    )
  }

  //Method responsible for next/prev page
  goToNextOrPreviousPage(
    direction?: string,
    fifaVersion?:number,
    name?: string, 
    preferredFoot?: string,
    minAge?: number, 
    maxAge?: number, 
    minOverall?: number, 
    maxOverall?: number,
    minPotential?: number,
    maxPotential?: number,
    minHeight?: number,
    maxHeight?: number,
    minValue?: number,
    maxValue?: number,
    minWage?: number,
    maxWage?: number,
    minHeadingAccuracy?: number,
    maxHeadingAccuracy?: number,
    minVolleys?: number,
    maxVolleys?: number,
    minDribbling?: number,
    maxDribbling?: number,
    minCurve?: number,
    maxCurve?: number,
    minFkAccuracy?: number,
    maxFkAccuracy?: number,
    minAcceleration?: number,
    maxAcceleration?: number,
    minSprintSpeed?: number,
    maxSprintSpeed?: number,
    minAgility?: number,
    maxAgility?: number,
    minReaction?: number,
    maxReaction?:number,
    minBalance?: number,
    maxBalance?: number,
    minShotPower?: number,
    maxShotPower?: number,
    minJumping?: number,
    maxJumping?: number,
    minStamina?: number,
    maxStamina?: number,
    minAggression?: number,
    maxAggression?: number,
    minLongShots?: number,
    maxLongShots?: number,
    minCrossing?: number,
    maxCrossing?: number,
    minFinishing?: number,
    maxFinishing?: number,
    minShortPassing?: number,
    maxShortPassing?: number): void {
    this.goToPage(name, fifaVersion, preferredFoot,minAge, maxAge, minOverall, maxOverall, minPotential,maxPotential,minHeight,maxHeight,minValue,maxValue,minWage,maxWage,minHeadingAccuracy,maxHeadingAccuracy,minVolleys, maxVolleys,minDribbling,maxDribbling, minCurve, maxCurve,minFkAccuracy, maxFkAccuracy,minAcceleration,maxAcceleration,minSprintSpeed,maxSprintSpeed,minAgility, maxAgility, minReaction,maxReaction,minBalance,maxBalance,minShotPower,maxShotPower,minJumping,maxJumping,minStamina,maxStamina, minAggression,maxAggression, minLongShots, maxLongShots,minCrossing,maxCrossing,minFinishing,maxFinishing,minShortPassing, maxShortPassing,
                  direction === 'forward' ? this.currentPageSubject.value + 1 : this.currentPageSubject.value - 1);
  }

  resetValues(name?:string):void{
    this.fifaVersion = 23;
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
    this.maxValue= 1000000000;
    this.minWage= 0;
    this.maxWage= 1000000000;
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
    this.goToPage(name);
  }
}

