import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {
  private token = localStorage.getItem('token');
  private _welcomeUrl = "http://localhost:8080/welcome";
  private _userURL = "http://localhost:8080/users/";
  
  private _sessionHeader = new HttpHeaders({'Authorization':"Bearer "+this.token});
  
  greetUser() {
    return this.http.get<any>(this._welcomeUrl, {headers : this._sessionHeader});
  }

  getCurrentUser(){
    return this.http.get<any>(this._userURL+this.token, {headers : this._sessionHeader});
  }

  constructor(private http : HttpClient, private authService : AuthService) { }
}
