import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../services/restapi.service';
import { MessageService } from '../services/message.service';


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  isLoggedIn = false;
  subscriptionName: any;
  messageReceived: any;

  constructor(private messageService: MessageService,private restApiService:RestapiService) {

   }

  ngOnInit(): void {
    this.subscriptionName = this.messageService.getUpdate().subscribe(data => {
      this.isLoggedIn = data.isLoggedIn;
    });
  }

}
