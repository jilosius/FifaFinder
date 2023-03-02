import { HideMissingDirective } from './hide-missing.directive';
import {ElementRef} from "@angular/core";
import any = jasmine.any;
import {By} from "@angular/platform-browser";
import {TestBed} from "@angular/core/testing";
import {StartComponent} from "../start/start.component";
import {throwError} from "rxjs";


describe('HideMissingDirective', () => {
  it('should create an instance', () => {
    const ef = new ElementRef(any);
    const directive = new HideMissingDirective(ef);
    expect(directive).toBeTruthy();
  });

});
