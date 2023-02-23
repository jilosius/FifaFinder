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

    /*savePlayer(players: boolean) {
        this.http.post(this.serverUrl, players).subscribe((response) => {
            console.log(response); 
      }*/
}