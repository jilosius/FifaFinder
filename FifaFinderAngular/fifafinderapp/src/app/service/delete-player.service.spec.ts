import { TestBed } from '@angular/core/testing';

import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { DeletePlayerService } from './delete-player.service';


describe('DeletePlayerService', () => {
  let service: DeletePlayerService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [DeletePlayerService]
    });
    service = TestBed.inject(DeletePlayerService);
    httpMock = TestBed.inject(HttpTestingController)
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should make a DELETE call to the Backend', () => {
    let actual: any;
    service.deletePlayer(1).subscribe(response => (actual = response));
    const req = httpMock.expectOne('http://localhost:8080/playsfor/delete1');
    expect(req.request.method).toEqual('DELETE');
    req.flush([false, true, false]);
    httpMock.verify();
    expect(actual).toEqual([false,true,false]);
  });

  it('should make a DELETE per Fifaversion call to the Backend', () => {
    let actual: any;
    service.deletePlayerInFifaVersion(1,23).subscribe(response => (actual = response));
    const req = httpMock.expectOne('http://localhost:8080/playsfor/deleteInFifaVersion?playerID=1&fifaVersion=23');
    expect(req.request.method).toEqual('DELETE');
    req.flush([false,false,true]);
    httpMock.verify();
    expect(actual).toEqual([false,false,true]);
  });


});
