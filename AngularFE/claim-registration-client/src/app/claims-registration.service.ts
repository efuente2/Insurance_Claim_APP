import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Claim } from './claim';

@Injectable({
  providedIn: 'root'
})
export class ClaimsRegistrationService {

  constructor(private http:HttpClient) { }

  public doRegistration (claim: { claim: Claim; }){
    return this.http.post("http://localhost:9090/Claim",claim,{responseType:'text' as 'json'});
  }

  public getAllClaims(){
    return this.http.get("http://localhost:9090/Claim");
  }
}
