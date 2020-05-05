import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientListComponent } from './client-list/client-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ClientService } from './clientService/client-service.service';
import { AddclientComponent } from './addclient/addclient.component';
import { FormsModule } from '@angular/forms';
import { GetaccountsComponent } from './getaccounts/getaccounts.component';
import { AddaccountComponent } from './addaccount/addaccount.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { AddtransactionComponent } from './addtransaction/addtransaction.component';
import { FilterComponent } from './filter/filter.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientListComponent,
    AddclientComponent,
    GetaccountsComponent,
    AddaccountComponent,
    TransactionsComponent,
    AddtransactionComponent,
    FilterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
