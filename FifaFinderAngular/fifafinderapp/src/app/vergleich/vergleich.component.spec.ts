import { HttpClient, HttpHandler } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { VergleichComponent } from './vergleich.component';

describe('VergleichComponent', () => {
  let component: VergleichComponent;
  let fixture: ComponentFixture<VergleichComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[RouterTestingModule,],
      declarations: [ VergleichComponent],
      providers: [{provide: HttpClient},
                  {provide: HttpHandler}]
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
