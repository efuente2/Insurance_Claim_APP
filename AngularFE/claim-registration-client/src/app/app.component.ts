import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  //title = 'claim-registration-client';
  title = 'AngularHttpRequest';

  constructor(private http: HttpClient){

  }

  ngOnInit(){
    this.fetchClaims();
  }

  onClaimFetch(){
    this.fetchClaims();
  }

  onClaimCreate(claim: {cName: string, email: string, amount: string, date: string, id: string }){
    console.log(claim);
    const headers = new HttpHeaders({'myHeaders': 'proacademy'});
    this.http.post(
      'http://localhost:9090/Claim',
      claim,{headers: headers})
      .subscribe((res) => {
        console.log(res);
    });
  }

  private fetchClaims(){
    this.http.get('http://localhost:9090/Claim')
    .subscribe((res) => {
      console.log(res);
    })
  }
}

