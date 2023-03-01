import { HttpClientModule } from '@angular/common/http';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StartComponent } from './start/start.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Router, RouterModule } from '@angular/router';
import { MatSortModule } from '@angular/material/sort';
import { VergleichComponent } from './vergleich/vergleich.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { RouterTestingModule } from "@angular/router/testing";
import { MatButtonModule } from "@angular/material/button";
import { MatSelectModule } from "@angular/material/select";
import { MatAutocompleteModule } from "@angular/material/autocomplete";
import { MatInputModule } from "@angular/material/input";
import { HideMissingDirective } from './directive/hide-missing.directive';


@NgModule({
  declarations: [
    AppComponent,
    StartComponent,
    VergleichComponent,
    HideMissingDirective
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        RouterTestingModule,
        MatSortModule,
        MatCheckboxModule,
        RouterModule,
        MatButtonModule,
        MatSelectModule,
        MatAutocompleteModule,
        MatInputModule
        // MatMenuModule
    ],
  providers: [],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
