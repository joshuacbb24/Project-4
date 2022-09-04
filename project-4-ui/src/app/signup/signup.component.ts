import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { RestapiService } from '../services/restapi.service';
import { Account } from '../models/account';
import { FormControl, FormGroupDirective, NgForm, ValidationErrors, ValidatorFn, Validators, FormGroup, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  account2: Array<Account> = [];
  account: any;


  constructor(private restApiService: RestapiService) { }

  ngOnInit(): void {
  }

  register() :void{
    this.restApiService.register(this.account).subscribe({
      next: () => {

      },
      error: () =>{

      }
    })
  }
}
