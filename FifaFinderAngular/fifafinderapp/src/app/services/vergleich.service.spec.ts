import { TestBed } from '@angular/core/testing';

import { VergleichService } from './vergleich.service';

describe('VergleichService', () => {
  let service: VergleichService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VergleichService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
