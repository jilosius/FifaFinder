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

  updatePlayerDetails(editPlayerForm: UpdateDto, playerId: number, fifaVersion: number) {
    this.http.put('http://localhost:8080/playsfor/editdetailsof'+playerId+'in'+fifaVersion, editPlayerForm).subscribe();
  }

  addPlayer(addPlayerForm: AddDto) {
    this.http.post('http://localhost:8080/playsfor/add', addPlayerForm).subscribe();
  }

  getCurrentDetails(playerId: number, fifaVersion: number) {
    return this.http.get<UpdateDto>('http://localhost:8080/playsfor/detailsforedit/playerid='+playerId+'/fifaversion='+fifaVersion);
  }

}
