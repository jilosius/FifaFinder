import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { Spieler } from '../interface/spieler';
import { VergleichService } from './vergleich.service';

describe('VergleichService', () => {
  let service: VergleichService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [VergleichService]
    });

    service = TestBed.inject(VergleichService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return a list of players for comparison', () => {
    const player1Id = 1;
    const player2Id = 2;
    const player3Id = 3;
    const player4Id = 4;
    const player5Id = 5;
    const fifaVersion = 23;

    const mockSpieler: Spieler[] = [
      { playerId: 1, photoURL: 'https://example.com/player1.jpg', fifaVersion: 23, fullName: '', knownName: '',age:45, flag:'', clubName:'', clubLogo:'', overall:90,potential:90,bestPos:'FW',valueEUR:59999,height: 180,weight: 87,preferredFoot: 'right', headingAccuracy:90,volleys:90,dribbling:90,curve:90,fkAccuracy:90,acceleration:90,sprintSpeed:90,agility:90,reaction:90,balance:90,shotPower:90,jumping:90,stamina:90,aggression:90,longShots:90,crossing:90,finishing:90,shortPassing:90,wage:90,selected:true},
      { playerId: 2, photoURL: 'https://example.com/player2.jpg', fifaVersion: 23, fullName: '', knownName: '',age:25, flag:'', clubName:'', clubLogo:'', overall:90,potential:90,bestPos:'FW',valueEUR:59999,height: 180,weight: 87,preferredFoot: 'right', headingAccuracy:90,volleys:90,dribbling:90,curve:90,fkAccuracy:90,acceleration:90,sprintSpeed:90,agility:90,reaction:90,balance:90,shotPower:90,jumping:90,stamina:90,aggression:90,longShots:90,crossing:90,finishing:90,shortPassing:90,wage:90,selected:true},
      { playerId: 3, photoURL: 'https://example.com/player3.jpg', fifaVersion: 23, fullName: '', knownName: '',age:35, flag:'', clubName:'', clubLogo:'', overall:90,potential:90,bestPos:'FW',valueEUR:59999,height: 180,weight: 87,preferredFoot: 'right', headingAccuracy:90,volleys:90,dribbling:90,curve:90,fkAccuracy:90,acceleration:90,sprintSpeed:90,agility:90,reaction:90,balance:90,shotPower:90,jumping:90,stamina:90,aggression:90,longShots:90,crossing:90,finishing:90,shortPassing:90,wage:90,selected:true},
      { playerId: 4, photoURL: 'https://example.com/player4.jpg', fifaVersion: 23, fullName: '', knownName: '',age:55, flag:'', clubName:'', clubLogo:'', overall:90,potential:90,bestPos:'FW',valueEUR:59999,height: 180,weight: 87,preferredFoot: 'right', headingAccuracy:90,volleys:90,dribbling:90,curve:90,fkAccuracy:90,acceleration:90,sprintSpeed:90,agility:90,reaction:90,balance:90,shotPower:90,jumping:90,stamina:90,aggression:90,longShots:90,crossing:90,finishing:90,shortPassing:90,wage:90,selected:true},
      { playerId: 5, photoURL: 'https://example.com/player5.jpg', fifaVersion: 23, fullName: '', knownName: '',age:19, flag:'', clubName:'', clubLogo:'', overall:90,potential:90,bestPos:'FW',valueEUR:59999,height: 180,weight: 87,preferredFoot: 'right', headingAccuracy:90,volleys:90,dribbling:90,curve:90,fkAccuracy:90,acceleration:90,sprintSpeed:90,agility:90,reaction:90,balance:90,shotPower:90,jumping:90,stamina:90,aggression:90,longShots:90,crossing:90,finishing:90,shortPassing:90,wage:90,selected:true}
    ];

    service.selectedSpieler$(player1Id, player2Id, player3Id, player4Id, player5Id, fifaVersion).subscribe((spieler: Spieler[]) => {
      expect(spieler.length).toBe(5);
      expect(spieler).toEqual(mockSpieler);
    });

    const req = httpMock.expectOne(`${service['serverUrl']}?player1Id=${player1Id}&player2Id=${player2Id}&player3Id=${player3Id}&player4Id=${player4Id}&player5Id=${player5Id}&fifaVersion=${fifaVersion}`);
    expect(req.request.method).toBe('GET');
    req.flush(mockSpieler);
  });
});
