import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { StartComponent } from './start.component';

describe('StartComponent', () => {
  let component: StartComponent;
  let fixture: ComponentFixture<StartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StartComponent ],
      imports: [HttpClientTestingModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

describe('resetValues', () => {
  let component: StartComponent;
  let fixture: ComponentFixture<StartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StartComponent ],
      imports: [HttpClientTestingModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should reset all values', () => {
    component.fifaVersion = 22;
    component.preferredFoot = 'left';
    component.ageMin = 22;
    component.ageMax = 30;
    component.overallMin = 70;
    component.overallMax = 80;
    component.potentialMin = 50;
    component.potentialMax = 90;
    component.heightMin = 10;
    component.heightMax = 200;
    component.minValue = 50000;
    component.maxValue = 1000000;
    component.minWage = 50000;
    component.maxWage = 1000000;
    component.minHeadingAccuracy =0 ;
    component.maxHeadingAccuracy = 80;
    component.minVolleys = 0;
    component.maxVolleys = 100;
    component.minDribbling = 80;
    component.maxDribbling = 100;
    component.minCurve = 50;
    component.maxCurve = 90;
    component.minFkAccuracy = 40;
    component.maxFkAccuracy = 100;
    component.minAcceleration = 0;
    component.maxAcceleration = 100;
    component.minSprintSpeed = 0;
    component.maxSprintSpeed = 100;
    component.minAgility = 0;
    component.maxAgility = 100;
    component.minReaction = 0;
    component.maxReaction = 0;
    component.minBalance = 0;
    component.maxBalance = 100;
    component.minJumping = 0;
    component.maxJumping = 100;
    component.minStamina = 0;
    component.maxStamina = 100;
    component.minAggression = 0;
    component.maxAggression = 100;
    component.minLongShots = 0;
    component.maxLongShots = 100;
    component.minCrossing = 0;
    component.maxCrossing = 100;

    component.resetValues();

    expect(component.fifaVersion).toEqual(23);
    expect(component.preferredFoot).toEqual('');
    expect(component.ageMin).toEqual(0);
    expect(component.ageMax).toEqual(100);
    expect(component.overallMin).toEqual(0);
    expect(component.overallMax).toEqual(100);
    expect(component.potentialMin).toEqual(0);
    expect(component.potentialMax).toEqual(100);
    expect(component.heightMin).toEqual(0);
    expect(component.heightMax).toEqual(300);
    expect(component.minValue).toEqual(0);
    expect(component.maxValue).toEqual(100000000000);
    expect(component.minWage).toEqual(0);
    expect(component.maxWage).toEqual(100000000000);
    expect(component.minHeadingAccuracy).toEqual(0);
    expect(component.maxHeadingAccuracy).toEqual(100);
    expect(component.minVolleys).toEqual(0);
    expect(component.maxVolleys).toEqual(100);
    expect(component.minDribbling).toEqual(0);
    expect(component.maxDribbling).toEqual(100);
    expect(component.minCurve).toEqual(0);
    expect(component.maxCurve).toEqual(100);
    expect(component.minFkAccuracy).toEqual(0);
    expect(component.maxFkAccuracy).toEqual(100);
    expect(component.minAcceleration).toEqual(0);
    expect(component.maxAcceleration).toEqual(100);
    expect(component.minSprintSpeed).toEqual(0);
    expect(component.maxSprintSpeed).toEqual(100);
    expect(component.minAgility).toEqual(0);
    expect(component.maxAgility).toEqual(100);
    expect(component.minReaction).toEqual(0);
    expect(component.maxReaction).toEqual(100);
    expect(component.minBalance).toEqual(0);
    expect(component.maxBalance).toEqual(100);
    expect(component.minShotPower).toEqual(0);
    expect(component.maxShotPower).toEqual(100);
    expect(component.minJumping).toEqual(0);
    expect(component.maxJumping).toEqual(100);
    expect(component.minStamina).toEqual(0);
    expect(component.maxStamina).toEqual(100);
    expect(component.minAggression).toEqual(0);
    expect(component.maxAggression).toEqual(100);
    expect(component.minLongShots).toEqual(0);
    expect(component.maxLongShots).toEqual(100);
    expect(component.minCrossing).toEqual(0);
    expect(component.maxCrossing).toEqual(100);

  });

  it('should call goToPage with name parameter if passed', () => {
    spyOn(component, 'goToPage');
    const name = 'page1';
    component.resetValues(name);
    expect(component.goToPage).toHaveBeenCalledWith(name);
  });
});

