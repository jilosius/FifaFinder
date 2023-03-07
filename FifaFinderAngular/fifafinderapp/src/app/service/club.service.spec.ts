import { inject, TestBed } from '@angular/core/testing';

import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { Club } from "../interface/club";
import { ClubService } from './club.service';

describe('ClubService', () => {
  let service: ClubService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ClubService]
    });
    service = TestBed.inject(ClubService);
    httpMock = TestBed.inject(HttpTestingController)
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should retrieve an Observable of all the Clubs', (inject([HttpTestingController, ClubService], (httpMock: HttpTestingController, service: ClubService) =>{
    const club1: Club = {
      clubID: 1,
      clubName: 'FC Testhausen',
      clubLogo: '.png'
    };
    const club2: Club = {
      clubID: 2,
      clubName: 'FC Testdorf',
      clubLogo: '.jpg'
    };
    let clubs: Club[]=[];
    clubs.push(club1);
    clubs.push(club2);
    service.clubs$().subscribe((response: Club[]) => {
        expect(response).toEqual(clubs);
      }

    )

  })));



});
