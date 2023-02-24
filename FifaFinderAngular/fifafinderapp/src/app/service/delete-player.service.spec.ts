import { TestBed } from '@angular/core/testing';

import { DeletePlayerService } from './delete-player.service';

describe('DeletePlayerService', () => {
  let service: DeletePlayerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeletePlayerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
