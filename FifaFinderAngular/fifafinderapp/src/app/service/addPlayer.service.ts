import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
//import { Observable } from 'rxjs';
import { ApiResponse } from '../interface/api-response';
import { Page } from '../interface/page'
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

export class addPlayerService {
    private readonly serverUrl: string = 'http://localhost:8080/playsFor/add';
  
    constructor(private http: HttpClient) { }
/*
    playsFor$ = (knownName: string, fullName: string, Age: number, weight: number,
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
       GKKicking: number, GKPositioning: number, GKReflexes: number): Observable<ApiResponse<string> => this.http.post(`${this.serverUrl},) */
}