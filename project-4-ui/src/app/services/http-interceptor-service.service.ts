import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders, HttpXsrfTokenExtractor, HttpClientXsrfModule } from '@angular/common/http';
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
    let token = this.xsrfTokenExtractor.getToken() as string
    console.log("xsrf token", token)
    if (this.restApiService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
        let authReq = req.clone({ withCredentials: true,
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                //check this
                'Authorization': 'Basic ' + window.btoa(this.cookieService.get('username')+ ":" + this.cookieService.get('password') ),
                'X-XSRF-TOKEN': token ? token : "",
            })
        });
        return next.handle(authReq);
    } else {
        return next.handle(req);
    }
}
}
