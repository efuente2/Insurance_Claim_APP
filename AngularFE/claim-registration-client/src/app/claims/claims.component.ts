import { Component, OnInit } from '@angular/core';
import { claim } from '../claim';
import { ClaimsRegistrationService } from '../claims-registration.service';

@Component({
  selector: 'app-claims',
  templateUrl: './claims.component.html',
  styleUrls: ['./claims.component.css']
})
export class ClaimsComponent implements OnInit{


  claim: claim = new claim("12","12","12","12","12");
  message:any;

  constructor(private service:ClaimsRegistrationService){ }

  ngOnInit(){
  }

  public registerNow(){
    let resp=this.service.doRegistration(this.claim);
    resp.subscribe((data)=>this.message=data)
  }
}
