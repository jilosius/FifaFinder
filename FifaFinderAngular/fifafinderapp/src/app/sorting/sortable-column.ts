//Autor: Levi
//Defines a SortableColumn; every column that has sorting enabled is to be defined as a SortableColumn
export class SortableColumn{
  column: string;
  direction: string = null;


  public constructor(column: string, direction?: string) {
    this.column = column;
    this.direction = direction;
  }

  // cycles through the directions of the sort 
  public toggleDirection() {
    if(this.direction == 'asc') {
      this.direction = null;
    } else if(this.direction == 'desc') {
      this.direction = 'asc';
    } else {
      this.direction = 'desc';
    }
  }
}
