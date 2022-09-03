import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';



@Injectable({
  providedIn: 'root'
})
export class RestapiService {

  username="";
  password= "";
  id="";
  bgColor="";
  avatar=""
  USER_NAME_SESSION_ATTRIBUTE_NAME = ""
  token=""

  constructor(private cookieService:CookieService, private http:HttpClient) { }



  login(username: string, password:string) :Observable<any>{
    //const headers = new HttpHeaders({Authorization: this.createBasicAuthToken(username, password)});
    console.log("username", username, "password", password);
    return this.http.get(environment.apiUrl + 'auth/v1/login', 
    {headers: {Authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
    this.username = username;
    this.password = password;
    this.registerSuccessfulLogin(username, password, res);
    }));

  }

  createBasicAuthToken(username: string, password:string){
    return 'Basic '+ window.btoa(username+":"+password);
  }

  registerSuccessfulLogin(username: string, password:string, resp:any) {
    // save the username(email) to session
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
    this.cookieService.set('username', username)
    this.cookieService.set('password', password)
    console.log("response", resp)
  }

  logout() :Observable<any>{
    console.log("in here")
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = "";
    this.password = "";
    this.cookieService.delete('username')
    this.cookieService.delete('password')
    return this.http.post(environment.apiUrl + 'logout', null)
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === "" || user === null) 
    {
      return false
    }
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === "" || user === null) 
    {
      return ""
    }
    return user
  }
  
  testLoginStatus() :Observable<any>{
    //return this.http.get(environment.apiUrl + 'home/v1', {headers: {Authorization: this.createBasicAuthToken(this.username, this.password)}, responseType: 'text' as 'json'})

    return this.http.post(environment.apiUrl + 'home/v1', null)
  }
  
}
