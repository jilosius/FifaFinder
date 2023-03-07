import { TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';

import { EditPlayerService } from './edit-player.service';

describe('EditPlayerService', () => {
  let service: EditPlayerService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule], 
      providers: [EditPlayerService] 
    });
    service = TestBed.inject(EditPlayerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
