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
  date: any;
  isConfirmationFormHidden = true;
  isTransactionModalHidden = true;
  data: any;
  dateEnd: any;
  options = {
    responsive: false,
    maintainAspectRatio: false
  };
  updatedGoal: any;


  editForm = new FormGroup ({
    name: new FormControl({value:'', disabled:!this.editEnabled}, [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required, Validators.minLength(1)]),
    amount: new FormControl({value:'', disabled: !this.editEnabled}, [Validators.pattern(/(?=.*?\d)^\$?(([1-9]\d{0,2}(,\d{3})*)|\d+)?(\.\d{1,2})?$/), Validators.required]),
    currentAmount: new FormControl({value:'', disabled: !this.editEnabled}, [Validators.pattern(/(?=.*?\d)^\$?(([1-9]\d{0,2}(,\d{3})*)|\d+)?(\.\d{1,2})?$/), Validators.required]),
    description: new FormControl({value:'', disabled: !this.editEnabled}, [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required]),
    date: new FormControl('', [Validators.required])

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
          console.log("goal", this.goal)
          if (this.goal)
          {
            this.messageService.sendUpdate(true, "");
            this.date = this.convertDate(this.goal.endDate);
            this.data = {
              datasets: [
                {
                  labels: ['Current','Target'],
                    data: [data.currentAmount, data.targetGoal],
                    backgroundColor: [
                        "#66BB6A",
                        "#FF6384"
                        
                    ],
                    hoverBackgroundColor: [
                        "#81C784",  
                        "#FF6384"
                        
                    ]
                }
            ]
            }
            let date = this.convertDate(this.goal.endDate);
            console.log("date", date)
            this.editForm.controls['name'].setValue(this.goal.name);
            this.editForm.controls['amount'].setValue(this.goal.targetGoal);
            this.editForm.controls['description'].setValue(this.goal.description);
            this.editForm.controls['currentAmount'].setValue(this.goal.currentAmount);
            this.editForm.controls['date'].setValue(date);
          }
          else{
            this.router.navigate(["/home"]);
          }
        },
        error: (err) => {

        }
      })
      let navbar = document.getElementById('navbar')
      console.log("nav", navbar)
      //navbar ? navbar.innerText = "Inventory" : null;
  }

  submit() {
    if(this.editForm.invalid)
    {
      return;
    }
    let date = this.getDate(this.editForm.controls['date'].value);
    this.updatedGoal = {
      name: this.editForm.controls['name'].value,
      description: this.editForm.controls['description'].value,
      targetGoal: this.editForm.controls['amount'].value,
      endDate: date,
      currentAmount: this.editForm.controls['currentAmount'].value
    }
    this.goalApiService.updateGoal(this.goal.id, this.updatedGoal).subscribe({
      next: (data) => {
        this.goal = data;
        this.cancelEdit();
      },
      error: (err) => {

      }
    })
  }

  cancelEdit() {
    this.editEnabled = false;
    let date = this.convertDate(this.goal.endDate);
    this.editForm.controls['name'].setValue(this.goal.name);
    this.editForm.controls['amount'].setValue(this.goal.targetGoal);
    this.editForm.controls['description'].setValue(this.goal.description);
    this.editForm.controls['currentAmount'].setValue(this.goal.currentAmount)
    this.editForm.controls['date'].setValue(date);

    this.editForm.controls['name'].disable();
    this.editForm.controls['amount'].disable();
    this.editForm.controls['description'].disable();
    this.editForm.controls['currentAmount'].disable();
    this.editForm.controls['date'].disable();
  }

  enableEdit() {
    this.editEnabled = true;
   // this.editForm.controls.amount.disabled= false
   this.editForm.controls['name'].enable();
   this.editForm.controls['amount'].enable();
   this.editForm.controls['description'].enable();
   this.editForm.controls['currentAmount'].enable();
   this.editForm.controls['date'].enable();
  }

  delete() {

      this.goalApiService.deleteGoal(this.goal.id).subscribe({
        next: (data) => {
          this.router.navigate(["/home"]);
        },
        error: (err) => {
        }
      })

  }

  convertDate(date: any) :any {
    
    const myArray = date.split("-");
    let d = myArray[1] + "-" + myArray[2] + "-" + myArray[0];
    let a = new Date (d);
     return a;
  }
  hideDeleteConfirmation() {
    this.isConfirmationFormHidden = true;
  }
  revealDeleteModal() {
    this.isConfirmationFormHidden = false;
  }

  getDate(e: any): string {
    this.dateEnd = new Date(e);
    return this.dateEnd = this.dateEnd.getFullYear() + "-" + (this.dateEnd.getMonth() + 1) + "-" + this.dateEnd.getDate();
  }
}
