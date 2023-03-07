import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AddDto } from '../interface/add-dto';
import { UpdateDto } from '../interface/update-dto';
import { ClubService } from '../service/club.service';
import { EditPlayerService } from '../service/edit-player.service';
import { EditPlayerComponent } from './edit-player.component';
import { HttpClient, HttpHandler } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatAutocomplete, MatAutocompleteModule } from '@angular/material/autocomplete';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

//Author:Jannik
describe('EditPlayerComponent', () => {
  let component: EditPlayerComponent;
  let fixture: ComponentFixture<EditPlayerComponent>;

  const mockActivatedRoute = {
    snapshot: {
      paramMap: new Map([['id', '1']])
    }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        FormsModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatAutocompleteModule,
        MatInputModule,
        BrowserAnimationsModule
      ], 
      declarations: [ EditPlayerComponent ],
      providers: [
        HttpClient,
        HttpHandler,
        FormBuilder,
        EditPlayerService,
        ClubService,
        HttpClientTestingModule,
        { provide: ActivatedRoute, useValue: mockActivatedRoute },
        { provide: Router, useClass: class { navigate = jasmine.createSpy('navigate'); } }
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});


describe('isAddMode', () => {
  let component: EditPlayerComponent;
  let fixture: ComponentFixture<EditPlayerComponent>;
  let activatedRouteStub: any;

  beforeEach(async () => {
    activatedRouteStub = {
      snapshot: {
        paramMap: {
          get: (param: string) => {
            if (param === 'mode') {
              return 'true';
            }
            return null;
          }
        }
      }
    }; 

    await TestBed.configureTestingModule({
      declarations: [ EditPlayerComponent ],
      imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatAutocompleteModule,
        MatInputModule,
        BrowserAnimationsModule
      ],
      providers: [
        EditPlayerService,
        FormBuilder,
        ClubService,
        HttpClientTestingModule,
        HttpClient,
        HttpHandler,
        { provide: ActivatedRoute, useValue: activatedRouteStub }
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should return true in add mode', () => {
    expect(component.isAddMode()).toBeTrue();
  });

  it('should return false in edit mode', () => {
    activatedRouteStub.snapshot.paramMap.get = (param: string) => {
      if (param === 'mode') {
        return 'false';
      }
      return null;
    };
    expect(component.isAddMode()).toBeFalse();
  });
});


describe('onEditPlayer/onAddPlayer', () => {
  let editPlayerServiceSpy: jasmine.SpyObj<EditPlayerService>;
  let component: EditPlayerComponent;
  let fixture: ComponentFixture<EditPlayerComponent>;
  let activatedRouteStub: any;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ EditPlayerComponent ],
      imports: [  
        ReactiveFormsModule,
        MatFormFieldModule,
        MatAutocompleteModule
      ],
      providers: [
        EditPlayerService,
        FormBuilder,
        ClubService,
        HttpClientTestingModule,
        HttpClient,
        HttpHandler,
        { provide: ActivatedRoute, useValue: {
              snapshot:
            {
            url: ['fifafinder/:mode']
             }}}
      ]
    })

    editPlayerServiceSpy = jasmine.createSpyObj('EditPlayerService', ['updatePlayerDetails']);
    fixture = TestBed.createComponent(EditPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should update the club name and call service.updatePlayerDetails(UpdateDto, playerId, fifaVersion)', () => {
    spyOn(component, 'ngOnInit');
    spyOn(component, 'isAddMode');
    const playerId = 1;
    const fifaVersion = 23;
    const dataInput: UpdateDto = {
      height: 188,
      clubPosition: 'LW',
      clubNumber: 2,
      nationalPosition: 'LW', 
      nationalNumber: 2,
      preferredFoot: 'Left',
      contractUntil: 2024,
      onLoan: 'TRUE',
      nationalTeam: 'Argentina',  
      weight: 80,
      overall: 80,
      potential: 80,
      bestPosition: 'LW', 
      clubName: 'FC Barcelona',
      valueEUR: 1000000,
      wage: 10000,
      releaseClause: 1000000, 
      intReputation: 80, 
      weakFoot: 2,
      skillMoves: 2,
      crossing: 80,
      finishing: 80,
      headingAccuracy: 80, 
      shortPassing: 80,
      volleys: 80,
      dribbling: 80,
      curve: 80,
      fkaccuracy: 80,
      longPassing: 80,
      ballControl: 80,
      acceleration: 80,
      sprintSpeed: 80,
      agility: 80,
      reaction: 80,
      balance: 80,
      shotPower: 80,
      jumping: 80,
      stamina: 80,
      strength: 80,
      longShots: 80,
      aggression: 80,
      interceptions: 80,
      positioning: 80,
      vision: 80,
      penalties: 80,
      composure: 80,
      marking: 80,
      standingTackle: 80,
      slidingTackle: 80,
      gkdiving: 80,
      gkhandling: 80,
      gkkicking: 80,
      gkpositioning: 80, 
      gkreflexes: 80,
      photoUrl: 'url'
    };

    const serviceCallData: UpdateDto = dataInput;
    serviceCallData.clubName = 'Paris-Saint Germain';

    component.clubName.setValue('Paris-Saint Germain');
    component.playerId = playerId;
    component.fifaVersion = fifaVersion;
    component.onEditPlayer(dataInput);

    expect(dataInput.clubName).toEqual('Paris-Saint Germain');
    expect(editPlayerServiceSpy.updatePlayerDetails).toHaveBeenCalledWith(serviceCallData, playerId, fifaVersion);
  });

  it('should update the club name and call service.addPlayer(AddDto)', () => {
    const dataInput: AddDto = {
      fullName: 'Lionel Messi',
      knownName: 'L. Messi',
      age: 35,
      dateOfBirth: new Date(1977),
      fifaVersion: 23,
      height: 188,
      clubPosition: 'LW',
      clubNumber: 2,
      nationalPosition: 'LW', 
      nationalNumber: 2,
      preferredFoot: 'Left',
      contractUntil: 2024,
      onLoan: 'TRUE',
      nationalTeam: 'Argentina',  
      weight: 80,
      overall: 80,
      potential: 80,
      bestPosition: 'LW', 
      clubName: 'FC Barcelona',
      valueEUR: 1000000,
      wage: 10000,
      releaseClause: 1000000, 
      intReputation: 80, 
      weakFoot: 2,
      skillMoves: 2,
      crossing: 80,
      finishing: 80,
      headingAccuracy: 80, 
      shortPassing: 80,
      volleys: 80,
      dribbling: 80,
      curve: 80,
      fkaccuracy: 80,
      longPassing: 80,
      ballControl: 80,
      acceleration: 80,
      sprintSpeed: 80,
      agility: 80,
      reaction: 80,
      balance: 80,
      shotPower: 80,
      jumping: 80,
      stamina: 80,
      strength: 80,
      longShots: 80,
      aggression: 80,
      interceptions: 80,
      positioning: 80,
      vision: 80,
      penalties: 80,
      composure: 80,
      marking: 80,
      standingTackle: 80,
      slidingTackle: 80,
      gkdiving: 80,
      gkhandling: 80,
      gkkicking: 80,
      gkpositioning: 80, 
      gkreflexes: 80,
      photoUrl: 'url'
    };

    const serviceCallData: AddDto = dataInput;
    serviceCallData.clubName = "Paris-Saint Germain";

    component.clubName.setValue("Paris-Saint Germain");
    component.onAddPlayer(dataInput);

    expect(dataInput.clubName).toEqual('Paris-Saint Germain');
    expect(editPlayerServiceSpy.addPlayer).toHaveBeenCalledWith(serviceCallData);
  });
});