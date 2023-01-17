import { Spieler } from './spieler';
import { Pageable } from './pageable';
import { Sort } from "@angular/material/sort";

export class Page{
    content: Spieler[];
    pageable: Pageable;
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    sort: Sort;
    numberOfElements: number;
    first: boolean;
    empty: boolean

    public constructor() {
      this.pageable = new Pageable();
    }
}
