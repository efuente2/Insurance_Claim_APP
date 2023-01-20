import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClaimsComponent } from './claims/claims.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SearchDeleteComponent } from './search-delete/search-delete.component';

const routes: Routes = [
  {path: "login", component:LoginComponent},
  {path: "register", component: ClaimsComponent},
  {path: "home", component: HomeComponent},
  {path: "search", component: SearchDeleteComponent},
  {path: "", redirectTo:"login", pathMatch:"full"}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
