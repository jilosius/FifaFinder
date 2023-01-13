export class SortableColumn{
    name: String;
    title: String;
    direction: string;

    public constructor(name: string, title: string, direction: string) {
        this.name = name;
        this.title = title;
        this.direction = direction;
    }

    public toggleDirection(){
        if(this.direction == 'asc'){
            this.direction = null;
        } else if(this.direction == 'desc'){
            this.direction = 'asc';
        } else {
            this.direction = 'desc';
        }
    }
}
