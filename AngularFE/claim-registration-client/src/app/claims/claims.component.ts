import { Component, OnInit } from '@angular/core';
import { Claim } from '../claim';
import { ClaimsRegistrationService } from '../claims-registration.service';

@Component({
  selector: 'app-claims',
  templateUrl: './claims.component.html',
  styleUrls: ['./claims.component.css']
})
export class ClaimsComponent implements OnInit{

  name:String = "sdfsef";
  email:String = " sefsefs";
  date:String =" sesef";
  amount:String = " sefsef";
  id:String=" sefsef";

  
  //fclaim: Claim = new Claim(" ","","","","");
  fclaim: Claim = new Claim(this.name,this.email,this.date,this.amount,this.id);
  message:any;

  
  constructor(private service:ClaimsRegistrationService){ }

  ngOnInit(){
  }

  public registerNow(){
    let resp=this.service.doRegistration({ claim: this.fclaim });
    resp.subscribe((data)=>this.message=data);
  }
}
