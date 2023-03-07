import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Mannschaften, PlaysFor, Spieler } from "../player/PlaysFor";


@Injectable({providedIn:"root"})

export class PlaysForService{
    private apiServerurl=environment.apiBaseUrl;
    constructor(private http: HttpClient){ }
    public getPlaysForByFifaVersionAndId(fifaVersion:number,id:number) :Observable<PlaysFor>{
        return this.http.get<PlaysFor>(`${this.apiServerurl}/playsFor/${fifaVersion}/${id}`);
    }
    public  getAll() :Observable<PlaysFor[]>{
        return this.http.get<PlaysFor[]>(`${this.apiServerurl}/playsFor/all`);
    }
    public getPlaysForByPlayerIDId(id:number) :Observable<PlaysFor[]>{
        return this.http.get<PlaysFor[]>(`${this.apiServerurl}/playsfor/player/${id}`);
    }   
    public getSpielerById(id: number): Observable<Spieler> {
        return this.http.get<Spieler>(`${this.apiServerurl}/players/${id}`);
    }
    public getSpielerByFullNameContaining(knownName: String): Observable<Spieler[]> {
        return this.http.get<Spieler[]>(`${this.apiServerurl}/players/search?n=${knownName}`);
    }
    public getSpielerByFullName(knownName: String): Observable<Spieler> {
        return this.http.get<Spieler>(`${this.apiServerurl}/players/knownName/${knownName}`);
    }
    public getMannschaftenWithDetails(id: Number): Observable<Mannschaften> {
        return this.http.get<Mannschaften>(`${this.apiServerurl}/clubs/mannschaften/${id}`);
    }

    mannschaften$ = (id:number): Observable<Mannschaften> =>
    this.getMannschaftenWithDetails(id);
    
    }
    