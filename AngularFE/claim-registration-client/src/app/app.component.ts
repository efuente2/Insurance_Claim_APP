import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { claimExport } from './model/claimModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  //title = 'claim-registration-client';
  title = 'AngularHttpRequest';

  selectedFile:any;

  allproducts: claimExport[] = []; 

  constructor(private http: HttpClient){

  }

  ngOnInit(){
    this.fetchClaims();
  }

  onClaimFetch(){
    this.fetchClaims();
  }

  onFileSelected(event:any){
    console.log(event);

    this.selectedFile = event.target.files[0];

    console.log('file', this.selectedFile);

  }

  onUpload(){
    let formData = new FormData();
    formData.set("file", this.selectedFile)
    this.http.post('http://localhost:9080/upload',formData)
    .subscribe((res) => {
        console.log(res);})
  }

  onClaimCreate(claim: {name: string, email: string, amount: string, date: string, claimId: string }){
    console.log(claim);
    const headers = new HttpHeaders({'myHeaders': 'proacademy'});
    this.http.post<{name: string}>(
      'http://localhost:9090/Claim',
      claim,{headers: headers})
      .subscribe((res) => {
        console.log(res);
    });
  }

  private fetchClaims(){
    this.http.get<{[key: string]: claimExport}>('http://localhost:9090/Claim')
    .pipe(map((res) => {
      const products = [];
        for(const key in res){
          if(res.hasOwnProperty(key)){
          products.push({...res[key], id: key})
          }
          
        }
        return products;
    }))
    .subscribe((products) => {
      console.log(products);
      this.allproducts = products;
    })
  }
}

