import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn = false;

  constructor(private restApiService:RestapiService, private router:Router, private actRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.isLoggedIn = this.restApiService.isUserLoggedIn();
    console.log('home ->' + this.isLoggedIn);
    if (!this.isLoggedIn)
    {
      this.router.navigate(["/login"])
    }
    
    this.restApiService.testLoginStatus().subscribe({
      next: (data) => {
        console.log("returned", data)
      },
      error: (err) => {
        console.log("error", err)
      }
    })
    const id = this.actRoute.snapshot.paramMap.get('id');
  }

  logout(){
    this.restApiService.logout().subscribe({
      next: () => {
        this.router.navigate(["/login"]);
      },
      error: () => {

      }

    });
  }
}
