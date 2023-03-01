import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EditPlayerComponent } from '../edit-player/edit-player.component';
import { AddDto } from '../interface/add-dto';
import { UpdateDto } from '../interface/update-dto';

@Injectable({providedIn: 'root'})
export class EditPlayerService {
  constructor(private http: HttpClient) {}

  updatePlayerDetails(editPlayerForm: UpdateDto, playerId: number, fifaVersion: number) {
    this.http.put('http://localhost:8080/playsfor/editdetailsof'+playerId+'in'+fifaVersion, editPlayerForm).subscribe();
  }

  addPlayer(addPlayerForm: AddDto) {
    this.http.put('http://localhost:8080/playsfor/add', addPlayerForm).subscribe();
  }

}
