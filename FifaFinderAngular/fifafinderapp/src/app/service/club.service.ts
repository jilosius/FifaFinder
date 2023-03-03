import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Club} from "../interface/club";

@Injectable({
  providedIn: 'root'
})
export class ClubService {
  private readonly serverUrl: string = 'http://localhost:8080/clubs'

  constructor(private http: HttpClient) { }

  clubs$ = (): Observable<Club[]> =>
    this.http.get<Club[]>(`${this.serverUrl}`);
}
