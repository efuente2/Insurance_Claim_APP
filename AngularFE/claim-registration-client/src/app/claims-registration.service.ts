import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClaimsRegistrationService {

  constructor(private http:HttpClient) { }

  public doRegistration (claim){
    return this.http.post("",claim,{responseType:'text' as 'json'});
  }
}
