import { TestBed } from '@angular/core/testing';

import { SelectedPlayerService } from './selected-player.service';
import { RouterTestingModule } from '@angular/router/testing';

describe('SelectedPlayerService', () => {
  let service: SelectedPlayerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SelectedPlayerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  



});
