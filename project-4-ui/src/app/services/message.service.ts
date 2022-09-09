import { Injectable } from '@angular/core';
import { Title } from 'chart.js';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor() { }

  private subjectName = new Subject<any>(); //need to create a subject
    
  sendUpdate(loggedIn: Boolean, title: string) { //the component that wants to update something, calls this fn
      this.subjectName.next({ isLoggedIn: loggedIn,
                              title: title, }); //next() will feed the value in Subject
  }

  getUpdate(): Observable<any> { //the receiver component calls this function 
      return this.subjectName.asObservable(); //it returns as an observable to which the receiver funtion will subscribe
  }
}
