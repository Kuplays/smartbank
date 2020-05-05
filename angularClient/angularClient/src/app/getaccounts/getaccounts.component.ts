import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { ClientService } from '../clientService/client-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-getaccounts',
  templateUrl: './getaccounts.component.html',
  styleUrls: ['./getaccounts.component.css']
})
export class GetaccountsComponent implements OnInit {
	id: string;
	accounts: Account[];

  constructor(private clientService: ClientService, private route: ActivatedRoute) { 
  		
  }

  ngOnInit(): void {
  	this.id = this.route.snapshot.paramMap.get('id');
  	this.clientService.getAllAccounts(this.id).subscribe(data => {
      this.accounts = data;
    });
  }

}
