import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../clientService/client-service.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

	clients: Client[];


  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
  	this.clientService.getAll().subscribe(data => {
      this.clients = data;
    });
  }

}
