import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'app-goal-listing',
  templateUrl: './goal-listing.component.html',
  styleUrls: ['./goal-listing.component.css']
})
export class GoalListingComponent implements OnInit {
  @Input() id: string = ""
  @Input() title: string = ""
  @Input() description: string = ""
  @Input() targetGoal: string = ""
  @Input() currentAmount: string = ""
  @Input() imgSrc: string = ""
  data: any;
  chartOptions: any;
  //subscription: Subscription;

  //config: AppConfig;

  constructor() { }

  ngOnInit(): void {
    this.data = {
      datasets: [
        {
          labels: ['Current','Target'],
            data: [this.currentAmount, this.targetGoal],
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
  }

}
