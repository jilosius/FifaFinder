import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

import { Spieler, PlaysFor } from '../PlaysFor';
import { PlaysForService } from '../../service/PlaysFor.service';
import { PlayerCardComponent } from '../player-card/player-card.component';

describe('PlayerCardComponent', () => {
  let component: PlayerCardComponent;
  beforeEach(async () => {
      await TestBed.configureTestingModule({
        declarations: [ PlayerDetailsComponent ]
      })
      .compileComponents();

      fixture = TestBed.createComponent(PlayerDetailsComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });

    it('should create', () => {
      expect(component).toBeTruthy();
    });
  });
