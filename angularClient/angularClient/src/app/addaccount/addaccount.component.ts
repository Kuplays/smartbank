import { Component, OnInit, Input } from '@angular/core';
import { Account } from '../account';
import { ClientService } from '../clientService/client-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-addaccount',
  templateUrl: './addaccount.component.html',
  styleUrls: ['./addaccount.component.css']
})
export class AddaccountComponent implements OnInit {
	clientId: string;
	account: Account;
  constructor(private clientService: ClientService, private route: ActivatedRoute) { 
  	this.account = new Account();
  }

  ngOnInit(): void {
  	this.clientId = this.route.snapshot.paramMap.get('id');
  }

  onSubmit() {
  	this.account.clientId = this.clientId;
    this.clientService.saveAccount(this.account).subscribe(result => window.location.reload());
  }

}
