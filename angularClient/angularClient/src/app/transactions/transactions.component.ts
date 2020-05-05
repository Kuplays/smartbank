import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { Client } from '../client';
import { ClientService } from '../clientService/client-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
	from: string;
	until: string;
	clients: Client[];
	clientid: string;
	transactions: Transaction[];

  constructor(private clientService: ClientService, private route: ActivatedRoute) {
  	this.from = "";
  	this.until = "";
  	this.clientid = "";
  }

  ngOnInit(): void {
  	this.clientService.getAllTransactions().subscribe(data => {
      this.transactions = data;
    });

    this.clientService.getAll().subscribe(data => {
      this.clients = data;
    });
  }

  onSubmit() {

  	if (this.from != "" && this.until != "" && this.clientid != "") {
  		this.clientService.getAllTransactionsByDateAndId(this.from, this.until, this.clientid).subscribe(data => {
    		this.transactions = data;
    	});
  	} else if ((this.from == "" || this.until == "") && this.clientid != "") {
  		this.clientService.getAllTransactionsById(this.clientid).subscribe(data => {
    		this.transactions = data;
    	});
  	} else if (this.from != "" && this.until != "" && this.clientid == "") {
  		this.clientService.getAllTransactionsByDate(this.from, this.until).subscribe(data => {
    		this.transactions = data;
    	});
  	} else {
  		this.clientService.getAllTransactions().subscribe(data => {
    		this.transactions = data;
    	});
  	}
  }

}
