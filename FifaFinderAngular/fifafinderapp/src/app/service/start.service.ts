import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse } from '../interface/api-response';
import { Page } from '../interface/page'

@Injectable({ providedIn: 'root' })
export class SpielerService {
  private readonly serverUrl: string = 'http://localhost:8080/players/start/filtered';

  constructor(private http: HttpClient) { }

  // Make call to the back end API to retrieve page of spieler
  spieler$ = (
    name: string = '',
    fifaVersion: number = 23,
    preferredFoot: string = "",
    minAge: number = 0,
    maxAge: number = 100,
    minOverall: number = 0,
    maxOverall: number = 100,
    potentialMin: number = 0,
    potentialMax: number = 100,
    heightMin: number=0,
    heightMax: number=300,
    minValue: number=0,
    maxValue: number=1000000000,
    minWage: number=0,
    maxWage: number=1000000000,
    minHeadingAccuracy: number=0,
    maxHeadingAccuracy: number=100,
    minVolleys: number=0,
    maxVolleys: number=100,
    minDribbling: number=0,
    maxDribbling: number=100,
    minCurve: number=0,
    maxCurve: number=100,
    minFkAccuracy: number=0,
    maxFkAccuracy: number=100,
    minAcceleration: number=0,
    maxAcceleration: number=100,
    minSprintSpeed: number=0,
    maxSprintSpeed: number=100,
    minAgility: number=0,
    maxAgility: number=100,
    minReaction: number=0,
    maxReaction: number=100,
    minBalance: number=0,
    maxBalance: number=100,
    minShotPower: number=0,
    maxShotPower: number=100,
    minJumping: number=0,
    maxJumping: number=100,
    minStamina: number=0,
    maxStamina: number=100,
    minAggression: number=0,
    maxAggression: number=100,
    minLongShots: number=0,
    maxLongShots: number=100,
    minCrossing: number=0,
    maxCrossing: number=100,
    minFinishing: number=0,
    maxFinishing: number=100,
    minShortPassing: number=0,
    maxShortPassing: number=100,
    page: number = 0,
    size: number = 20,
    sort: string = 'overall',
    order: string = 'desc'
  ): Observable<ApiResponse<Page>> =>
    this.http.get<ApiResponse<Page>>(
      `${this.serverUrl}?fullName=${name}&fifaVersion=${fifaVersion}&preferredFoot=${preferredFoot}&minAge=${minAge}&maxAge=${maxAge}&minOverall=${minOverall}&maxOverall=${maxOverall}&maxShortPassing=${maxShortPassing}&minShortPassing=${minShortPassing}&maxFinishing=${maxFinishing}&minFinishing=${minFinishing}&maxCrossing=${maxCrossing}&minCrossing=${minCrossing}&maxLongShots=${maxLongShots}&minLongShots=${minLongShots}&maxAggression=${maxAggression}&minAggression=${minAggression}&maxStamina=${maxStamina}&minStamina=${minStamina}&maxJumping=${maxJumping}&minJumping=${minJumping}&maxShotPower=${maxShotPower}&minShotPower=${minShotPower}&maxBalance=${maxBalance}&minBalance=${minBalance}&maxReaction=${maxReaction}&minReaction=${minReaction}&maxAgility=${maxAgility}&minAgility=${minAgility}&maxSprintSpeed=${maxSprintSpeed}&minSprintSpeed=${minSprintSpeed}&maxAcceleration=${maxAcceleration}&minAcceleration=${minAcceleration}&maxFkAccuracy=${maxFkAccuracy}&minFkAccuracy=${minFkAccuracy}&maxCurve=${maxCurve}&minCurve=${minCurve}&maxDribbling=${maxDribbling}&minDribbling=${minDribbling}&maxVolleys=${maxVolleys}&minVolleys=${minVolleys}&maxHeadingAccuracy=${maxHeadingAccuracy}&minHeadingAccuracy=${minHeadingAccuracy}&maxWage=${maxWage}&minWage=${minWage}&maxValue=${maxValue}&minValue=${minValue}&heightMax=${heightMax}&heightMin=${heightMin}&potentialMax=${potentialMax}&potentialMin=${potentialMin}&page=${page}&size=${size}&sort=${sort}&order=${order}`);
}
// &preferredFoot=${preferredFoot}
