import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from "@angular/router";
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { StartComponent } from './start.component';
import { FormsModule } from "@angular/forms";
import { SortableColumn } from "../sorting/sortable-column";
import { HttpClientModule } from "@angular/common/http";
import { RouterTestingModule} from "@angular/router/testing";
import { Router } from '@angular/router';
import { dirname } from "@angular/compiler-cli";
import { SpielerService } from '../service/start.service';
import { of } from 'rxjs';
import { Page } from '../interface/page';
import { ApiResponse } from '../interface/api-response';
import { fakeAsync, tick } from '@angular/core/testing';
import { SelectedPlayerService } from '../service/selected-player.service';




describe('Sorting', () => {
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


describe('ValuesControl', () => {
  let component: StartComponent;
  let fixture: ComponentFixture<StartComponent>;
  let spielerService: SpielerService;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule,
        RouterTestingModule,
        FormsModule
      ],
      declarations: [ StartComponent ],
      providers: [SpielerService
        // {provide: SpielerService, useValue: spielerServiceSpy}
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StartComponent);
    component = fixture.componentInstance;
    spielerService = TestBed.inject(SpielerService);
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });

  it('should reset all values', () => {
    component.fifaVersion = 22;
    component.preferredFoot = 'left';
    component.ageMin = 22;
    component.ageMax = 30;
    component.overallMin = 70;
    component.overallMax = 80;
    component.potentialMin = 50;
    component.potentialMax = 90;
    component.heightMin = 10;
    component.heightMax = 200;
    component.minValue = 50000;
    component.maxValue = 1000000;
    component.minWage = 50000;
    component.maxWage = 1000000;
    component.minHeadingAccuracy =0 ;
    component.maxHeadingAccuracy = 80;
    component.minVolleys = 0;
    component.maxVolleys = 100;
    component.minDribbling = 80;
    component.maxDribbling = 100;
    component.minCurve = 50;
    component.maxCurve = 90;
    component.minFkAccuracy = 40;
    component.maxFkAccuracy = 100;
    component.minAcceleration = 0;
    component.maxAcceleration = 100;
    component.minSprintSpeed = 0;
    component.maxSprintSpeed = 100;
    component.minAgility = 0;
    component.maxAgility = 100;
    component.minReaction = 0;
    component.maxReaction = 55;
    component.minBalance = 0;
    component.maxBalance = 99;
    component.minJumping = 0;
    component.maxJumping = 99;
    component.minStamina = 0;
    component.maxStamina = 80;
    component.minAggression = 93;
    component.maxAggression = 100;
    component.minLongShots = 0;
    component.maxLongShots = 35;
    component.minCrossing = 0;
    component.maxCrossing = 33;
    component.minFinishing=0;
    component.maxFinishing=55;
    component.minShortPassing=0;
    component.maxShortPassing=100;

    component.resetValues();

    expect(component.fifaVersion).toEqual(23);
    expect(component.preferredFoot).toEqual('');
    expect(component.ageMin).toEqual(0);
    expect(component.ageMax).toEqual(100);
    expect(component.overallMin).toEqual(0);
    expect(component.overallMax).toEqual(100);
    expect(component.potentialMin).toEqual(0);
    expect(component.potentialMax).toEqual(100);
    expect(component.heightMin).toEqual(0);
    expect(component.heightMax).toEqual(300);
    expect(component.minValue).toEqual(0);
    expect(component.maxValue).toEqual(100000000000);
    expect(component.minWage).toEqual(0);
    expect(component.maxWage).toEqual(100000000000);
    expect(component.minHeadingAccuracy).toEqual(0);
    expect(component.maxHeadingAccuracy).toEqual(100);
    expect(component.minVolleys).toEqual(0);
    expect(component.maxVolleys).toEqual(100);
    expect(component.minDribbling).toEqual(0);
    expect(component.maxDribbling).toEqual(100);
    expect(component.minCurve).toEqual(0);
    expect(component.maxCurve).toEqual(100);
    expect(component.minFkAccuracy).toEqual(0);
    expect(component.maxFkAccuracy).toEqual(100);
    expect(component.minAcceleration).toEqual(0);
    expect(component.maxAcceleration).toEqual(100);
    expect(component.minSprintSpeed).toEqual(0);
    expect(component.maxSprintSpeed).toEqual(100);
    expect(component.minAgility).toEqual(0);
    expect(component.maxAgility).toEqual(100);
    expect(component.minReaction).toEqual(0);
    expect(component.maxReaction).toEqual(100);
    expect(component.minBalance).toEqual(0);
    expect(component.maxBalance).toEqual(100);
    expect(component.minShotPower).toEqual(0);
    expect(component.maxShotPower).toEqual(100);
    expect(component.minJumping).toEqual(0);
    expect(component.maxJumping).toEqual(100);
    expect(component.minStamina).toEqual(0);
    expect(component.maxStamina).toEqual(100);
    expect(component.minAggression).toEqual(0);
    expect(component.maxAggression).toEqual(100);
    expect(component.minLongShots).toEqual(0);
    expect(component.maxLongShots).toEqual(100);
    expect(component.minCrossing).toEqual(0);
    expect(component.maxCrossing).toEqual(100);
    expect(component.minFinishing).toEqual(0);
    expect(component.maxFinishing).toEqual(100);
    expect(component.minShortPassing).toEqual(0);
    expect(component.maxShortPassing).toEqual(100);
  });

  it('should add a player to the selected players array when toggleSelection is called with a player that is not already selected', () => {
    const testSpieler = {
      playerId: 1,
      photoURL: '',
      fifaVersion: 23,
      knownName: 'Test',
      age: 25,
      flag: 'JO',
      clubLogo: '',
      overall: 90,
      potential: 90,
      bestPos: 'FW',
      valueEUR: 100000,
      height: 200,
      weight: 100,
      preferredFoot: 'left',
      headingAccuracy: 50,
      volleys: 50,
      dribbling: 50,
      curve: 50,
      fkAccuracy: 50,
      acceleration: 100,
      sprintSpeed: 100,
      agility: 100,
      reaction: 100,
      balance: 100,
      shotPower: 100,
      jumping: 100,
      stamina: 100,
      aggression: 100,
      longShots: 100,
      crossing: 100,
      finishing: 100,
      shortPassing: 100,
      wage: 1000000,
      selected: false
    };
  
    component.toggleSelection(testSpieler);
  
    expect(testSpieler.selected).toBe(true);
    expect(component.selectedPlayers.length).toBe(1);
    expect(component.selectedPlayers[0]).toEqual(testSpieler);
  });

  it('should return true for pages within 5 pages of the current page', () => {
    const currentPage = 10;
    for (let i = 1; i <= 20; i++) {
      const startPage = currentPage - 5;
      const endPage = currentPage + 5;
      expect(component.shouldShowPage(i, currentPage)).toEqual(i >= startPage && i <= endPage);
    }
  });
  
  it('should call SpielerService.spieler$ observable with correct parameters', () => {
    const sampleData: Page = {
      content: [],
      pageable: {
        sort: null,
        offset: 0,
        pageSize: 20,
        pageNumber: 0,
        paged: true,
        unpaged: false
      },
      last: true,
      totalPages: 1,
      totalElements: 0,
      size: 20,
      number: 0,
      sort: null,
      numberOfElements: 0,
      first: true,
      empty: true
    };
    const sampleApiResponse: ApiResponse<Page> = {
      timeStamp: '',
      statusCode: 200,
      status: 'OK',
      message: 'Sample message',
      data: { page: sampleData }
    };

    spyOn(spielerService, 'spieler$').and.returnValue(of(sampleApiResponse));
    component.goToPage('test', 23, '', 0,100,0,100,0,100,0,150,0,5000,0,5,1,99,0,99,0,99,0,99,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,20,'overall','desc');
  
    expect(spielerService.spieler$).toHaveBeenCalledWith(
      'test', 23, '', 0,100,0,100,0,100,0,150,0,5000,0,5,1,99,0,99,0,99,0,99,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,100,0,20,'overall','desc'
    );
  });

  it('should set the selected FIFA version', () => {
    const version = 21;
    component.onFifaVersionChange(version);
    expect(component.selectedFifaVersion).toBe(version);
  });

  

  // it('should increment the current page when going to the next page', fakeAsync(() => {
  //   component.currentPageSubject.next(0);
  //   component.goToNextOrPreviousPage('forward');
  //   tick();
  //   component.currentPageSubject.subscribe(pageNumber => {
  //     expect(pageNumber).toEqual(1);
  //   });
  // }));
  
  // it('should decrement the current page when going to the previous page', fakeAsync(() => {
  //   component.currentPageSubject.next(6);
  //   component.goToNextOrPreviousPage('backward');
  //   tick();
  //   component.currentPageSubject.subscribe(pageNumber => {
  //     expect(pageNumber).toEqual(5);
  //   });
  // }));

  
});
  
  



  


