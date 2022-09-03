import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders, HttpXsrfTokenExtractor } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RestapiService } from './restapi.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorServiceService {

  constructor(private restApiService: RestapiService, private xsrfTokenExtractor: HttpXsrfTokenExtractor) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.restApiService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
        const authReq = req.clone({
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': `Basic ${window.btoa(this.restApiService.username + ":" + this.restApiService.password)}`,
                'X-XSRF-TOKEN': this.xsrfTokenExtractor.getToken() as string,
            })
        });
        return next.handle(authReq);
    } else {
        return next.handle(req);
    }
}
}
