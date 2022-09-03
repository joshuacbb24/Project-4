import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { RestapiService } from '../restapi.service';

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

  constructor(private authService: RestapiService, private router:Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  handleLogin() {
    this.authService.login(this.username, this.password).subscribe({
      next: (result) =>{
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful';
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
