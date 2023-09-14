import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private baseUrl = 'http://localhost:8000/';

  constructor(private http: HttpClient) { }

  getAPI_Message() {
    // return this.http.get(`${this.baseUrl}${this.usersEndpoint}`) 
    return this.http.get(`${this.baseUrl}`, { responseType: 'text'})
      // .subscribe(response => {
      //   this.htmlContent = response
      // })
  }
  
}