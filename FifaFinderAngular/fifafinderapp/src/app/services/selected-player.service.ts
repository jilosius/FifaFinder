import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SelectedPlayerService {

  private selectedPlayerIds: number[] = [];

  constructor() { }

  setSelectedPlayerIds(ids: number[]) {
    this.selectedPlayerIds = ids;
  }

  getSelectedPlayerIds(): number[] {
    return this.selectedPlayerIds;
  }

}
