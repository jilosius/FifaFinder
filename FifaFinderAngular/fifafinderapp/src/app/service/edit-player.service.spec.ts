import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { UpdateDto } from '../interface/update-dto';
import { EditPlayerService } from './edit-player.service';
import { AddDto } from '../interface/add-dto';
import { HttpClient } from '@angular/common/http';

describe('EditPlayerService', () => {
  let service: EditPlayerService;
  let httpTestingController: HttpTestingController;
  let httpClient: HttpClient;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [EditPlayerService]
    });
    service = TestBed.inject(EditPlayerService);
    httpTestingController = TestBed.inject(HttpTestingController);
    httpClient = TestBed.inject(HttpClient);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should send a PUT request to update a players details', () => {
    const playerId = 1;
    const fifaVersion = 23;
    const editPlayerDetails: UpdateDto = { 
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

    service.updatePlayerDetails(editPlayerDetails, playerId, fifaVersion);

    const req = httpTestingController.expectOne(`http://localhost:8080/playsfor/editdetailsof1in23`);
    expect(req.request.method).toEqual('PUT');
    expect(req.request.body).toEqual(editPlayerDetails);

    req.flush({});
  });

  it('should send a POST request to add a player', () => {
    const addPlayerDetails: AddDto = { 
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

    service.addPlayer(addPlayerDetails);

    const req = httpTestingController.expectOne('http://localhost:8080/playsfor/add');
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(addPlayerDetails);

    req.flush({});
  });

  it('should get player details by sending a GET request', () => {
    const playerId = 1;
    const fifaVersion = 23;
    const expectedDetails: UpdateDto = {
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

     service.details$(playerId, fifaVersion).subscribe(details => {
      expect(details).toEqual(expectedDetails);
     });

     const req = httpTestingController.expectOne('http://localhost:8080/playsfor/detailsforedit/playerid=1/fifaversion=23');
     expect(req.request.method).toEqual('GET');
     req.flush(expectedDetails);
    })
});
