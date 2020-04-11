import { Component, OnInit } from '@angular/core';
import { WelcomeService } from '../welcome.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {
  currentUser : any;

  constructor(private _welcomeService : WelcomeService, private _authService : AuthService) { }

   ngOnInit() {   
    this._welcomeService.getCurrentUser().subscribe((data : any) =>{
       this.currentUser =  data;
    });
  }

  public getUser(){
    return this.currentUser;
  }

}
