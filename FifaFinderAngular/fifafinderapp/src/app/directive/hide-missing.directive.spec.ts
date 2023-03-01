import { HideMissingDirective } from './hide-missing.directive';
import {ElementRef} from "@angular/core";


describe('HideMissingDirective', () => {
  it('should create an instance', () => {
    const directive = new HideMissingDirective();
    expect(directive).toBeTruthy();
  });
});
