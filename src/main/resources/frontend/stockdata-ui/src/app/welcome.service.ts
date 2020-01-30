import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {

  private _welcomeUrl = "http://localhost:8080/welcome";
  
  greetUser() {
    return this.http.get<any>(this._welcomeUrl);
  }

  constructor(private http : HttpClient) { }
}
