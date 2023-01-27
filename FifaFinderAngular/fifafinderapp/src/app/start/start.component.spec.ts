import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from "@angular/router";
import { StartComponent } from './start.component';
import {FormsModule} from "@angular/forms";
import {SortableColumn} from "../sorting/sortable-column";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {RouterTestingModule} from "@angular/router/testing";
import {dirname} from "@angular/compiler-cli";

describe('StartComponent', () => {
  let component: StartComponent;
  let fixture: ComponentFixture<StartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule,
        RouterTestingModule,
        FormsModule
      ],
      declarations: [ StartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should reset the sortableColumns array', () => {
    component.sortByColumn(component.sortableColumns[0]);
    expect(component.sortableColumns[1].direction).toBe(null);
    component.resetSort();
    expect(component.sortableColumns[1].direction).toBe('desc');
    for(let i = 0; i < component.sortableColumns.length; i++){
      if(component.sortableColumns[i].column!='overall'){
        expect(component.sortableColumns[i].direction).toBe(null);
      }
    }
  });

  it('should cycle through the directions of one sort object', () =>{
    let testSort = new SortableColumn('test', null);
    expect(testSort.column).toBe('test');
    expect(testSort.direction).toBe(null);
    testSort.toggleDirection();
    expect(testSort.column).toBe('test');
    expect(testSort.direction).toBe('desc');
    testSort.toggleDirection();
    expect(testSort.column).toBe('test');
    expect(testSort.direction).toBe('asc');
  });

  it('should switch the arrows on sort change', () =>{
    let testSortName = 'age';
    component.sortByColumn(component.sortableColumns[0]);
    expect(component.sortArrow(testSortName)).toBe('&#9660;');
    component.sortByColumn(component.sortableColumns[0]);
    expect(component.sortArrow(testSortName)).toBe('&#9650;');
    component.sortByColumn(component.sortableColumns[0]);
    expect(component.sortArrow(testSortName)).toBe('');
  });

  it('should switch all sort directions of currently inactive sort columns (back) to null', () =>{
    component.resetSort();
    component.sortableColumns[0].direction = 'desc';
    component.sortableColumns[5].direction = 'asc';
    component.clearPreviousSorting(component.sortableColumns[5]);
    expect(component.sortableColumns[5].direction).toBe('asc');
    for(let i = 0; i < component.sortableColumns.length; i++ ){
      if(i!=5){
        expect(component.sortableColumns[i].direction).toBe(null);
      }
    }
  });
});

