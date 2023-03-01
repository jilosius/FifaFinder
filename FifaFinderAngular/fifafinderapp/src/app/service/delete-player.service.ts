import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import {FifaVersion} from "../interface/fifaversion";

@Injectable({
  providedIn: 'root'
})
export class DeletePlayerService {
  private readonly serverUrl: string = 'http://localhost:8080/playsFor'
  constructor(private http: HttpClient) { }

  public deletePlayer(id: number){
    let deleteUrl: string = this.serverUrl + '/delete' + id;
    return this.http.delete(deleteUrl);
  }

  public deletePlayerInFifaVersion(id: number, fifaVersion: number){
    return this.http.delete(`${this.serverUrl}/deleteInFifaVersion?playerID=${id}&fifaVersion=${fifaVersion}`);
  }

  public listFifaVersions(){
    return this.http.get<FifaVersion[]>(this.serverUrl+'/listVersions');
  }

}
