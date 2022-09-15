import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from '../services/message.service';
import { RestapiService } from '../services/restapi.service';
import { GoalsService } from '../services/goals.service';
import { FormControl, FormGroupDirective, NgForm, ValidationErrors, ValidatorFn, Validators, FormGroup, AbstractControl } from '@angular/forms';
import { HttpClient, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn = false;
  account: any;
  modalHidden = true;
  today = new Date();
  dateEnd: any;
  filesize = 1000000;
  goal: any;
  goals: any;
  //selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string = "";
  imageName: any;

  creationForm = new FormGroup({
    name: new FormControl('', [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required]),
    amount: new FormControl('', [Validators.pattern(/(?=.*?\d)^\$?(([1-9]\d{0,2}(,\d{3})*)|\d+)?(\.\d{1,2})?$/), Validators.required]),
    currentAmount: new FormControl('', [Validators.pattern(/(?=.*?\d)^\$?(([1-9]\d{0,2}(,\d{3})*)|\d+)?(\.\d{1,2})?$/), Validators.required]),
    description: new FormControl('', [Validators.pattern(/^(?=.{1,40}$)[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$/), Validators.required]),
    date: new FormControl('', [Validators.required])
  })

  constructor(private messageService: MessageService, private restApiService: RestapiService,
     private router: Router, private actRoute: ActivatedRoute, private goalApiService: GoalsService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.restApiService.isUserLoggedIn();
    console.log('home ->' + this.isLoggedIn);
    if (!this.isLoggedIn) {
      this.router.navigate(["/login"])
    }
    this.messageService.sendUpdate(true, "Dashboard");
    this.restApiService.getInfo().subscribe({
      next: (data) => {
        this.account = data;
        console.log("account", data)
      },
      error: (err) => {

      }
    })
    this.goalApiService.fetchGoals().subscribe({
      next: (data) => {
        this.goals = data
        console.log("goals", this.goals)
      },
      error: (err) => {

      }
    }
    )

    const id = this.actRoute.snapshot.paramMap.get('id');
  }

  create(myForm: any, formDirective: any) {
    if (this.creationForm.invalid) {
      return;
    }

    let date = this.getDate(this.creationForm.controls['date'].value);
    this.goal = {
      name: this.creationForm.controls['name'].value,
      description: this.creationForm.controls['description'].value,
      targetGoal: this.creationForm.controls['amount'].value,
      endDate: date,
      currentAmount: this.creationForm.controls['currentAmount'].value
    }

    this.goalApiService.createGoal(this.goal).subscribe({
      next: (data) => {
        this.goalApiService.fetchGoals().subscribe({
          next: (data) => {
            this.goals = data
            this.modalHidden = true;
          },
          error: (err) => {

          }
        })
      },
      error: (err) => {

      }
    })
      //clear the form
      formDirective.resetForm();
    this.creationForm.reset();
  }

  closeModal(myForm: any, formDirective: any) {
    this.modalHidden = true;
    formDirective.resetForm();
    this.creationForm.reset();
  }

  revealModal() {
    this.modalHidden = false;
  }

  getDate(e: any): String {
    this.dateEnd = new Date(e);
    return this.dateEnd = this.dateEnd.getFullYear() + "-" + (this.dateEnd.getMonth() + 1) + "-" + this.dateEnd.getDate();
  }
  /*
  onFileChanged(e: any) {
    this.selectedFile = e.target.files[0];
  }
  onUpload() {
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
  }
  */
}
