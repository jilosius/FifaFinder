import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EditPlayerComponent } from '../edit-player/edit-player.component';
import { AddDto } from '../interface/add-dto';
import { UpdateDto } from '../interface/update-dto';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class EditPlayerService {
  constructor(private http: HttpClient) {}

  updatePlayerDetails(editPlayerDetails: UpdateDto, playerId: number, fifaVersion: number) {
    this.http.put('http://localhost:8080/playsfor/editdetailsof'+playerId+'in'+fifaVersion, editPlayerDetails).subscribe();
  }

  addPlayer(addPlayerDetails: AddDto) {
    this.http.post('http://localhost:8080/playsfor/add', addPlayerDetails).subscribe();
  }

  details$ = (playerId:number, fifaVersion:number): Observable<UpdateDto> =>
    this.http.get<UpdateDto>('http://localhost:8080/playsfor/detailsforedit/playerid='+playerId+'/fifaversion='+fifaVersion);
}
