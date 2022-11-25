import { Component } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';

@Component({
    selector: 'Loginpage',
    templateUrl: './loginpage.html',
    styleUrls:['./loginpage.css']
    
})

export class Loginpageclass {
    
} ;


/** Error when invalid control is dirty, touched, or submitted. */

/*
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
/*
/** @title Input with a custom ErrorStateMatcher */
/*
@Component({
  selector: 'input-error-state-matcher-example',
  templateUrl: './loginpage.html',
  styleUrls:['./loginpage.css']
})
export class InputErrorStateMatcherExample {
  emailFormControl = new FormControl('', [Validators.required, Validators.email]);

  matcher = new MyErrorStateMatcher();
}
*/