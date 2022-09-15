import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEventType } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { RestapiService } from './restapi.service';
import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class GoalsService {

  constructor(private cookieService: CookieService, private http: HttpClient, private restApiService: RestapiService) {

  }

  fetchGoal(id: any): Observable<any> {
    return this.http.get(environment.apiUrl + 'home/v1/' + id, { headers: { Authorization: this.restApiService.createBasicAuthToken(this.cookieService.get('username'), this.cookieService.get('password')) } })
  }

  fetchGoals(): Observable<any> {
    return this.http.get(environment.apiUrl + 'home/v1', {headers: { Authorization: this.restApiService.createBasicAuthToken(this.cookieService.get('username'), this.cookieService.get('password')) } })
  }

  createGoal(goal: any): Observable<any> {
    return this.http.post(environment.apiUrl + 'home/v1/create', goal)
  }

  updateGoal(id: any, goal: any): Observable<any> {
    return this.http.put(environment.apiUrl + 'home/v1/' + id, goal)
  }

  deleteGoal(id: any): Observable<any> {
    return this.http.delete(environment.apiUrl + 'home/v1/' + id)
  }
}
