import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { SpielerService } from '../service/start.service';
import { Page } from '../interface/page'
import { ApiResponse } from '../interface/api-response';

describe('SpielerService', () => {
  let service: SpielerService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [SpielerService]
    });
    service = TestBed.inject(SpielerService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should retrieve a page of spieler', inject([HttpTestingController, SpielerService], (httpMock: HttpTestingController, service: SpielerService) => {
    const mockApiResponse: ApiResponse<Page> = {
      timeStamp: '2023-02-22T12:00:00Z',
      statusCode: 200,
      status: 'OK',
      message: '',
      data: {
        page: {
          content: [],
          pageable: {
            sort: {
              active: 'overall',
              direction: 'desc'
            },
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
          sort: {
            active: 'overall',
            direction: 'desc'
          },
          numberOfElements: 0,
          first: true,
          empty: true
        }
      }
    };

    service.spieler$().subscribe((apiResponse: ApiResponse<Page>) => {
      expect(apiResponse).toEqual(mockApiResponse);
    });

    const req = httpMock.expectOne('http://localhost:8080/players/start/filtered?fullName=&fifaVersion=23&clubName=&preferredFoot=&minAge=0&maxAge=100&minOverall=0&maxOverall=100&maxShortPassing=100&minShortPassing=0&maxFinishing=100&minFinishing=0&maxCrossing=100&minCrossing=0&maxLongShots=100&minLongShots=0&maxAggression=100&minAggression=0&maxStamina=100&minStamina=0&maxJumping=100&minJumping=0&maxShotPower=100&minShotPower=0&maxBalance=100&minBalance=0&maxReaction=100&minReaction=0&maxAgility=100&minAgility=0&maxSprintSpeed=100&minSprintSpeed=0&maxAcceleration=100&minAcceleration=0&maxFkAccuracy=100&minFkAccuracy=0&maxCurve=100&minCurve=0&maxDribbling=100&minDribbling=0&maxVolleys=100&minVolleys=0&maxHeadingAccuracy=100&minHeadingAccuracy=0&maxWage=1000000000&minWage=0&maxValue=1000000000&minValue=0&heightMax=300&heightMin=0&potentialMax=100&potentialMin=0&page=0&size=20&sort=overall&order=desc');
    expect(req.request.method).toBe('GET');
    req.flush(mockApiResponse);
  }));
});
