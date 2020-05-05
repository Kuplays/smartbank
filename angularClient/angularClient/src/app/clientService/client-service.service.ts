import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../client';
import { Account } from '../account';
import { Transaction } from '../transaction';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
	private clientsUrl: string;
	private accountsUrl: string;
	private transactionsUrl: string;


  constructor(private http: HttpClient) {
  	this.clientsUrl = 'http://localhost:8080/all';
  	this.accountsUrl = 'http://localhost:8080/clientaccounts';
  	this.transactionsUrl = 'http://localhost:8080/transactions';
  }

  public getAll(): Observable<Client[]> {
    return this.http.get<Client[]>(this.clientsUrl);
  }

  public getAllAccounts(id: string): Observable<Account[]> {
    return this.http.get<Account[]>(this.accountsUrl + '/' + id);
  }

  public getAllTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.transactionsUrl);
  }

  public getAllTransactionsById(id: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.transactionsUrl + '/' + id);
  }

  public getAllTransactionsByDate(from: string, until: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.transactionsUrl + '/?from=' + from + "&until=" + until);
  }

  public getAllTransactionsByDateAndId(from: string, until: string, clientid: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.transactionsUrl + '/?from=' + from + "&until=" + until + "&clientid=" + clientid);
  }
 
  public save(client: Client) {
    return this.http.post<Client>(this.clientsUrl, client);
  }

  public saveAccount(account: Account) {
    return this.http.post<Account>(this.accountsUrl, account);
  }

  public saveTransaction(transaction: Transaction) {
    return this.http.post<Transaction>(this.transactionsUrl, transaction);
  }
}
