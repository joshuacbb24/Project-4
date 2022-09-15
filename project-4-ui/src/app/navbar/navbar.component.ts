import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RestapiService } from '../services/restapi.service';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn = false;
  showDropdown = false;
  title = ""
  restApiService: RestapiService;
  subscriptionName: any;
  messageReceived: any;
  account: any;
  color = ''
  avatar = ''
  name = ""

  constructor(private messageService: MessageService, restApiService: RestapiService, private router:Router) {
    this.restApiService = restApiService;

  }

  ngOnInit(): void {
    this.subscriptionName = this.messageService.getUpdate().subscribe(data => {
      this.isLoggedIn = data.isLoggedIn;
      this.title = data.title;
      if(this.isLoggedIn)
      this.restApiService.getInfo().subscribe({
        next: (data) => {
          this.account = data;
          this.defaultAvatar();
        },
        error: (err) => {
  
        }
      })
    });

    //this.isLoggedIn = this.restApiService.isUserLoggedIn();
  }
  toggleSidebar(): void {

    let sidebarElement = document.querySelector(".sidebar");
    let navElement = document.querySelector("nav");
    let dashElement = document.querySelector(".home-section");

    console.log(navElement)

    sidebarElement ? sidebarElement.classList.toggle("active") : null;
    dashElement ? dashElement.classList.toggle("active") : null;
    navElement ? navElement.classList.toggle("active") : null;
  }
  logout() {
    this.restApiService.logout().subscribe({
      next: () => {
        this.router.navigate(["/login"]);
      },
      error: () => {

      }

    });
  }
  toggle() {
    //let dropdown = document.getElementsByClassName(".dropdown-content")
    this.showDropdown = !this.showDropdown;
  }

  defaultAvatar() {
    let missingimages = document.getElementsByClassName('profile-pic-wrapper')

    // double check how to access "src" attribute
    for (var i = 0; i < missingimages.length; i++) {
        let missingimg = missingimages[i]
        let profileimg = missingimg.getAttribute('src')
        if (!profileimg || profileimg === '') {
            missingimg.classList.add('profile-pic')
            this.name = this.account.firstName + " " + this.account.lastName;

            missingimg.textContent = this.name[0];

            let bgAvatar = this.account.bgColor
            if (bgAvatar) {
              missingimg.setAttribute("style", "background-color: " + bgAvatar + ";")
            }

        }
    }
  }
}
