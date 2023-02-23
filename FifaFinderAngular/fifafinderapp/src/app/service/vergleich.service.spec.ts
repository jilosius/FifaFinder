import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { VergleichService } from './vergleich.service';

describe('VergleichService', () => {
  let service: VergleichService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(VergleichService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
