import { PlaysForService } from 'src/app/service/PlaysFor.service';
import { Component,  OnChanges,  OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { Spieler } from 'src/app/player/PlaysFor';
import { HttpErrorResponse } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {debounceTime, catchError, switchMap,  } from 'rxjs/operators';
import { FormControl } from '@angular/forms';
import { MatAutocomplete, MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit ,OnChanges{
  
  PlayyersControl = new FormControl('');
  filteredPlayers: Observable<Spieler[]>;
  constructor(private playsForService: PlaysForService,private router: Router) {}
  ngOnChanges(changes: SimpleChanges) {

    if (changes['selectedOption'] && !changes['selectedOption'].isFirstChange()) {
      console.log(changes['selectedOption']);

    }
  }
  ngOnInit() {
    this.filteredPlayers = this.PlayyersControl.valueChanges
      .pipe(
        debounceTime(500),
        switchMap(value => {
          if (value.length >= 3) {
            return this.getSpielerByFullNameContaining(value);
          } else {
            return of([]);
          }
        })
      );
  }

  private getSpielerByFullNameContaining(name: String) {
    return this.playsForService.getSpielerByFullNameContaining(name).pipe(
      catchError((error: HttpErrorResponse) => {
        alert(error.message);
        return of([]);
      })
    );
  }
  

  optionSelected(event: MatAutocompleteSelectedEvent) {
    const selectedPlayer = event.option.value as string;
  console.log('Selected option:', selectedPlayer);
  this.router.navigate(["/PlayerComponent"], { queryParams: { selectedOption: selectedPlayer } });
  }
  @ViewChild('auto') autocomplete: MatAutocomplete;

  ngAfterViewInit() {
    this.autocomplete.closed.subscribe(() => {
      if (this.autocomplete._keyManager.activeItem) {
        console.log('Selected option:', this.autocomplete._keyManager.activeItem.value);
      } else {
        console.log('User pressed enter.');
      }
    });
  }
  


  
}