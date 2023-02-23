import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VergleichComponent } from './vergleich.component';

describe('VergleichComponent', () => {
  let component: VergleichComponent;
  let fixture: ComponentFixture<VergleichComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VergleichComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VergleichComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
