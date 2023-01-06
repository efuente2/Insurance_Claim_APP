import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { claim } from './claim';

@Injectable({
  providedIn: 'root'
})
export class ClaimsRegistrationService {

  constructor(private http:HttpClient) { }

  public doRegistration (claim: claim){
    return this.http.post("http://localhost:9090/Claim",claim,{responseType:'text' as 'json'});
  }
}
