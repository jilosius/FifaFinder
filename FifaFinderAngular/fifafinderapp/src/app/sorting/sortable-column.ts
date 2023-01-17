export class SortableColumn{
  column: string;
  direction: string = null;


  public constructor(column: string, direction?: string) {
    this.column = column;
    this.direction = direction;
  }

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
