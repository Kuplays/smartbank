import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientListComponent } from './client-list/client-list.component';
import { GetaccountsComponent } from './getaccounts/getaccounts.component';
import { TransactionsComponent } from './transactions/transactions.component';



const routes: Routes = [
  { path: 'clients', component: ClientListComponent },
  { path: 'clientaccounts/:id', component: GetaccountsComponent},
  { path: 'transactions', component: TransactionsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
