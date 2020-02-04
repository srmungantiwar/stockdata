import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders} from "@angular/common/http";
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _registerUrl = "http://localhost:8080/register";
  private _loginUrl = "http://localhost:8080/authenticate";
  private _reqHeader = new HttpHeaders({'No-Auth':"true"});
  
  constructor(private http : HttpClient,
     private _router : Router) { }

  registerUser(user){
    return this.http.post<any>(this._registerUrl,user, {headers : this._reqHeader});
  }

  loginUser(user){
    return this.http.post<any>(this._loginUrl,user, {headers : this._reqHeader});
  }

  loggedIn(){
    return !!localStorage.getItem('token');
  }

  getToken(){
    return localStorage.getItem('token');
  }

  logoutUser(){
    localStorage.removeItem('token');
    this._router.navigate(['/login']);
  }
}
