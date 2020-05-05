import { Component, OnInit, Input } from '@angular/core';
import { Transaction } from '../transaction';
import { Account } from '../account';
import { ClientService } from '../clientService/client-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-addtransaction',
  templateUrl: './addtransaction.component.html',
  styleUrls: ['./addtransaction.component.css']
})
export class AddtransactionComponent implements OnInit {
	transaction: Transaction;
	clientId: string;
	accounts: Account[];
  constructor(private clientService: ClientService, private route: ActivatedRoute) { 
  	this.transaction = new Transaction();
  }

  ngOnInit(): void {
  	this.clientId = this.route.snapshot.paramMap.get('id');
  	this.clientService.getAllAccounts(this.clientId).subscribe(data => {
      this.accounts = data;
    });
  }

  onSubmit() {
  	this.transaction.clientId = this.clientId;
  	this.clientService.saveTransaction(this.transaction).subscribe(result => window.location.reload());
  }
}
