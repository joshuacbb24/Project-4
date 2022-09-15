import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { RestapiService } from '../services/restapi.service';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username= "";
  password = "";
  errorMessage = 'Invalid Credentials';
  successMessage = "";
  invalidLogin = false;
  loginSuccess = false;
  isLoggedIn = false;

  constructor(private messageService: MessageService,private authService: RestapiService, private router:Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isUserLoggedIn();
    console.log('home ->' + this.isLoggedIn);
    if (this.isLoggedIn)
    {
      this.router.navigate(["/home"])
    }
    this.messageService.sendUpdate(false, "");
  }

  handleLogin() {
    this.authService.login(this.username, this.password).subscribe({
      next: (result) =>{
        console.log("cookie", document.cookie)
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful';
                  // send message to subscribers via observable subject
      this.messageService.sendUpdate(true, "");
      this.router.navigate(["/home"])
      },
      error: (err) => {
        console.log("error", err)
        this.invalidLogin = true;
        this.loginSuccess = false;
    }
    });
  }
  
}
