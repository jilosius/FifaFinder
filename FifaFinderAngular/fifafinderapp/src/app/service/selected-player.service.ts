import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SelectedPlayerService {

  private selectedPlayerIdsSubject = new BehaviorSubject<number[]>([]);
  private selectedFifaVersion: number;

  constructor() { }

  get selectedPlayerIds$() {
    return this.selectedPlayerIdsSubject.asObservable();
  }

  setSelectedPlayerIds(ids: number[]) {
    this.selectedPlayerIdsSubject.next(ids);
  }

  setSelectedFifaVersion(fifaVersion: number) {
    this.selectedFifaVersion = fifaVersion;
  }

  getSelectedFifaVersion(): number {
    return this.selectedFifaVersion;
  }

}
