import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete'; 
import { RouterModule } from '@angular/router';
import { EditPlayerComponent } from './edit-player.component';
import { EditPlayerService } from '../service/edit-player.service';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('EditPlayerComponent', () => {
  let component: EditPlayerComponent;
  let fixture: ComponentFixture<EditPlayerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditPlayerComponent],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        MatAutocompleteModule,
        MatFormFieldModule ,
        RouterModule,
        MatInputModule,
        BrowserAnimationsModule
      ],
      providers: [
        EditPlayerService,
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              paramMap: new Map([['id', '1']])
            }
          }
        }
      ]
    }).compileComponents();
  });


  beforeEach(() => {
    fixture = TestBed.createComponent(EditPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  
});
