import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

//Autor: Levi
//does the communication with the backend related to the delete functionality
@Injectable({
  providedIn: 'root'
})
export class DeletePlayerService {
  private readonly serverUrl: string = 'http://localhost:8080/playsfor'
  constructor(private http: HttpClient) { }

  public deletePlayer(id: number){
    let deleteUrl: string = this.serverUrl + '/delete' + id;
    return this.http.delete(deleteUrl);
  }

  public deletePlayerInFifaVersion(id: number, fifaVersion: number) {
    return this.http.delete(`${this.serverUrl}/deleteInFifaVersion?playerID=${id}&fifaVersion=${fifaVersion}`);
  }

}
