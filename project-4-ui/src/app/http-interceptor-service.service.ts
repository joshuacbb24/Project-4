import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders, HttpXsrfTokenExtractor } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RestapiService } from './restapi.service';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorServiceService {

  constructor(private cookieService:CookieService,private restApiService: RestapiService, private xsrfTokenExtractor: HttpXsrfTokenExtractor) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = this.xsrfTokenExtractor.getToken() as string;
    console.log("token", token)
    if (this.restApiService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
        let authReq = req.clone({
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + window.btoa(this.restApiService.username + ":" + this.restApiService.password),
            }
            )/*,withCredentials: true*/});
        return next.handle(authReq);
    } else {
        return next.handle(req);
    }
}
}
