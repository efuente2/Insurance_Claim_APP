import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClaimsComponent } from './claims/claims.component';
import { SearchDeleteComponent } from './search-delete/search-delete.component';

const routes: Routes = [
  {path: "register", component: ClaimsComponent},
  {path: "search", component: SearchDeleteComponent},
  {path: "", redirectTo:"register", pathMatch:"full"}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
