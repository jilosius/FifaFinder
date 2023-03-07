import { ElementRef } from "@angular/core";
import { HideMissingDirective } from './hide-missing.directive';
import any = jasmine.any;


describe('HideMissingDirective', () => {
  it('should create an instance', () => {
    const ef = new ElementRef(any);
    const directive = new HideMissingDirective(ef);
    expect(directive).toBeTruthy();
  });

});
