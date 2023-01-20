import { HttpClient, HttpErrorResponse, HttpEvent, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
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

  selectedFile: File[] = [];

  allproducts: claimExport[] = []; 

  filenames: string[] = [];

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

    //this.selectedFile = event.target.files[0];
    this.selectedFile= [...event.target.files];

    console.log('file', this.selectedFile);

  }

  onUpload(){
    let formData = new FormData();
    for (const file of this.selectedFile) { formData.append('files', file, file.name)}
    //formData.set("files", this.selectedFile)
    this.http.post('http://localhost:9080/upload',formData)
    .subscribe(
      event => {
        console.log(event);
      },
      (error: HttpErrorResponse) => {
        console.log(error);
      }  
        );
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

  download(fileName: string) {
    return this.http.get(`http://localhost:9080/${fileName}`, {
      observe: 'response',
      responseType: 'blob'
    });
  }

  onDownloadFiles(filename: string): void{
    this.download(filename).subscribe(
    response => {
      console.log(response);
      let fileName = response.headers.get('Content-Disposition')
      ?.split(';')[1].split('=')[1];
      let blob: Blob=response.body as Blob;
      let a = document.createElement('a');
      a.download=fileName;
      a.href = window.URL.createObjectURL(blob);
      a.click();

    },
    (error: HttpErrorResponse) => {
      console.log(error);
    });
  }


}

