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
import { EditPlayerComponent } from './edit-player/edit-player.component';
import { MatButtonModule } from "@angular/material/button";
import { MatSelectModule } from "@angular/material/select";
import { MatAutocompleteModule } from "@angular/material/autocomplete";
import { MatInputModule } from "@angular/material/input";
import { HideMissingDirective } from './directive/hide-missing.directive';
import { MatIconModule } from "@angular/material/icon";
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatFormFieldModule } from "@angular/material/form-field";


@NgModule({
  declarations: [
    AppComponent,
    StartComponent,
    VergleichComponent,
    EditPlayerComponent,
    HideMissingDirective
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        MatFormFieldModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        RouterTestingModule,
        MatSortModule,
        MatCheckboxModule,
        RouterModule,
        MatButtonModule,
        MatSelectModule,
        MatAutocompleteModule,
        MatInputModule,
        MatIconModule,
        MatTooltipModule
        // MatMenuModule
    ],
  providers: [],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
