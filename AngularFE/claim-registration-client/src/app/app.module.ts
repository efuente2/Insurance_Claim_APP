import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClaimsRegistrationService } from './claims-registration.service';
import { ClaimsComponent } from './claims/claims.component';
import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { RestapiService } from './restapi.service';

@NgModule({
  declarations: [
    AppComponent,
    ClaimsComponent,
    SearchDeleteComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ClaimsRegistrationService, RestapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
