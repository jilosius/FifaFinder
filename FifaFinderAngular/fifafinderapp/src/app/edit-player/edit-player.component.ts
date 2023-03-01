import { Component, Injectable, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UpdateDto } from '../interface/update-dto';
import { EditPlayerService } from '../service/edit-player.service';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AddDto } from '../interface/add-dto';

@Component({
  selector: 'app-edit-player',
  templateUrl: './edit-player.component.html',
  styleUrls: ['./edit-player.component.css']
})
export class EditPlayerComponent{
  
  constructor(private editPlayerService: EditPlayerService,   private route: ActivatedRoute, private router: Router,) {};

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

