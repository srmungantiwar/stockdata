import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginUserData = {}
  constructor(private _auth : AuthService,
    private _router : Router) { }

  ngOnInit() {
  }

  registerRoute(){
    this._router.navigate(['/register']);
  }

  loginUser(){
    this._auth.loginUser(this.loginUserData)
    .subscribe(
      res => {
        localStorage.setItem('token',res.jwt);
        this._router.navigate(['/welcome']);
      },
      err => console.log(err)
    )
  }

}
