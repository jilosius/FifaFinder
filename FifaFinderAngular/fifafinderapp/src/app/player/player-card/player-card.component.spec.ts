import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

import { PlayerCardComponent } from './player-card.component';
import { PlaysForService } from 'src/app/service/PlaysFor.service';
import { Spieler, PlaysFor } from '../PlaysFor';

describe('PlayerCardComponent', () => {
  let component: PlayerCardComponent;
  let fixture: ComponentFixture<PlayerCardComponent>;
  let playsForService: PlaysForService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerCardComponent ],
      imports: [ HttpClientTestingModule ],
      providers: [ PlaysForService ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerCardComponent);
    component = fixture.componentInstance;
    playsForService = TestBed.inject(PlaysForService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should calculate the correct pace', () => {
    component.player = { acceleration: 80, sprintSpeed: 90 } as PlaysFor;
    expect(component.calculate_pace()).toEqual(90);
  });

  it('should calculate the correct shouting', () => {
    component.player = {
      positioning: 80,
      finishing: 90,
      penalties: 80,
      shotPower: 90,
      volleys: 80
    } as PlaysFor;
    expect(component.calculate_shouting()).toEqual(87 );
  });

  it('should calculate the correct passing', () => {
    component.player = {
      vision: 80,
      crossing: 90,
      curve: 80,
      shortPassing: 90
    } as PlaysFor;
    expect(component.calculate_passing()).toEqual(94 );
  });

  it('should calculate the correct dribbling', () => {
    component.player = {
      agility: 80,
      balance: 70,
      reaction: 80,
      ballControl: 90,
      dribbling: 90
    } as PlaysFor;
    expect(component.calculate_dribling()).toEqual(88 );
  });

  it('should calculate the correct defending', () => {
    component.player = {
      intReputation: 80,
      headingAccuracy: 70,
      marking: 90,
      slidingTackle: 70,
      standingTackle: 90
    } as PlaysFor;
    expect(component.calculate_deffending()).toEqual(84 );
  });

  it('should calculate the correct physical', () => {
    component.player = {
      aggression: 80,
      jumping: 70,
      stamina: 90,
      strength: 80
    } as PlaysFor;
    expect(component.calculate_physical()).toEqual(58 );
  });

  })



