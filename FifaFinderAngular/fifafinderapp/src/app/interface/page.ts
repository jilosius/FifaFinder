import { Spieler } from './spieler';
import { Sort } from './sort';
import { Pageable } from './pageable';

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
