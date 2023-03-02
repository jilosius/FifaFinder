import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UpdateDto } from '../interface/update-dto';
import { EditPlayerService } from '../service/edit-player.service';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AddDto } from '../interface/add-dto';
import { UpdateMode } from '@angular/compiler-cli/src/ngtsc/program_driver';

@Component({
  selector: 'app-edit-player',
  templateUrl: './edit-player.component.html',
  styleUrls: ['./edit-player.component.css']
})
export class EditPlayerComponent{
  playerId: number;
  fifaVersion: number;
  currentData: UpdateDto;

  constructor(private editPlayerService: EditPlayerService,   private route: ActivatedRoute, private router: Router,) {};

  isAddMode(): boolean {
    const addMode = this.route.snapshot.paramMap.get('mode');
    if (addMode=="true") {
      return true;
    }
    return false;
  }

  ngOnInit() {
    if(this.isAddMode()==false) {
      const playerId = this.route.snapshot.paramMap.get('playerId');
      this.playerId = Number(playerId);
      const fifaVersion = this.route.snapshot.paramMap.get('fifaVersion');
      this.fifaVersion = Number(fifaVersion);
      console.log(this.editPlayerService.getCurrentDetails(this.playerId, this.fifaVersion));//.subscribe((data: UpdateDto)=> this.currentData = { ...data });
    }
  }

  onEditPlayer(data: UpdateDto) {
    console.log(data);
    //this.editPlayerService.updatePlayerDetails(data, this.playerId, this.fifaVersion);
  }

  onAddPlayer(data: AddDto) {
    console.log(data);
    //this.editPlayerService.addPlayer(data);
  }
}

