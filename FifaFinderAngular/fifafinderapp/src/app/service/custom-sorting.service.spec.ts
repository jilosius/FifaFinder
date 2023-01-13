import { TestBed } from '@angular/core/testing';

import { CustomSortingService } from './custom-sorting.service';

describe('CustomSortingService', () => {
  let service: CustomSortingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomSortingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
