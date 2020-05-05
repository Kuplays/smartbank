import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../clientService/client-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-addclient',
  templateUrl: './addclient.component.html',
  styleUrls: ['./addclient.component.css']
})

export class AddclientComponent implements OnInit {
	client: Client;
  constructor(private clientService: ClientService, private route: ActivatedRoute, private router: Router) {
  	this.client = new Client(); 
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.clientService.save(this.client).subscribe(result => window.location.reload());
  }

}
