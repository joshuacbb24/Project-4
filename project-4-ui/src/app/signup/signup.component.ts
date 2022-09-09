import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { RestapiService } from '../services/restapi.service';
import { Account } from '../models/account';
import { FormControl, FormGroupDirective, NgForm, ValidationErrors, ValidatorFn, Validators, FormGroup, AbstractControl } from '@angular/forms';

export const confirmPasswordValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const password = control.get('password');
  const password2 = control.get('password2');

  return password && password2 && password.value === password2.value ? null : { password2: false };
};
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  account2: Array<Account> = [];
  account: any;
  existingAccount = false;
  isLoggedIn = false;

  registrationForm = new FormGroup({
    firstName: new FormControl('', [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required, Validators.minLength(1)]),
    lastName: new FormControl('', [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required, Validators.minLength(1)]),
    email: new FormControl('', [Validators.email, Validators.required]),
    password: new FormControl('',[Validators.required]),
    password2: new FormControl('',[Validators.required])
  }, { validators: [confirmPasswordValidator] })


  constructor(private restApiService: RestapiService, private router: Router) { }

  ngOnInit(): void {
    this.isLoggedIn = this.restApiService.isUserLoggedIn();
    console.log('home ->' + this.isLoggedIn);
    if (this.isLoggedIn)
    {
      this.router.navigate(["/home"])
    }
  }

  register() :void{
    if (this.registrationForm.invalid) {
      return;
    }
    this.account = {
      firstName:this.registrationForm.controls['firstName'].value,
      lastName:this.registrationForm.controls['lastName'].value,
      email:this.registrationForm.controls['email'].value,
      password: this.registrationForm.controls['password'].value,
      avatar: ""
    }
    this.restApiService.register(this.account).subscribe({
      next: (data) => {
        this.existingAccount = false;
        this.router.navigate(["/login"])
      },
      error: (err) =>{
        console.log("account exists")
        this.existingAccount = true;
      }
    })
  }
}
