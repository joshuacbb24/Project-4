import { Component, OnInit } from '@angular/core';
import { MessageService } from '../services/message.service';
import { RestapiService } from '../services/restapi.service';
import { FormControl, FormGroupDirective, NgForm, ValidationErrors, ValidatorFn, Validators, FormGroup, AbstractControl } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { GoalsService } from '../services/goals.service';


@Component({
  selector: 'app-edit-goals',
  templateUrl: './edit-goals.component.html',
  styleUrls: ['./edit-goals.component.css']
})
export class EditGoalsComponent implements OnInit {

  today = new Date();
  goal: any;
  editEnabled = false;
  


  editForm = new FormGroup ({
    name: new FormControl({value:'', disabled:!this.editEnabled}, [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required, Validators.minLength(1)]),
    amount: new FormControl({value:'', disabled: !this.editEnabled}, [Validators.pattern(/(?=.*?\d)^\$?(([1-9]\d{0,2}(,\d{3})*)|\d+)?(\.\d{1,2})?$/), Validators.required]),
    description: new FormControl({value:'', disabled: !this.editEnabled}, [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required]),
    date: new FormControl({value:'', disabled: !this.editEnabled}, [Validators.required])

  })

  constructor(private messageService: MessageService, private route: ActivatedRoute, private router: Router, private goalApiService:GoalsService) { }

  ngOnInit(): void {

      // First get the goal id from the current route.
      const routeParams = this.route.snapshot.paramMap;
      const productIdFromRoute = Number(routeParams.get('goalId'));

        // Find the product that correspond with the id provided in route.
      this.goal = this.goalApiService.fetchGoal(productIdFromRoute).subscribe({
        next: (data) => {
          this.goal = data;
          this.messageService.sendUpdate(true, "");
        },
        error: (err) => {

        }
      })
      let navbar = document.getElementById('navbar')
      console.log("nav", navbar)
      //navbar ? navbar.innerText = "Inventory" : null;
  }

  getDate(date: any) {

  }

  submit(myForm: any, formDirective: any) {
    if(this.editForm.invalid)
    {
      return;
    }
    this.editEnabled = false;
    formDirective.resetForm();
    this.editForm.reset();
  }

  cancelEdit(myForm: any, formDirective: any) {
    this.editEnabled = false;
    formDirective.resetForm();
    this.editForm.reset();
  }

  enableEdit() {
    this.editEnabled = true;
   // this.editForm.controls.amount.disabled= false
  }
}
