import { Component, OnInit } from '@angular/core';
import { WelcomeComponent } from '../welcome/welcome.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  currentUser : any;

  constructor(private _welcomeComponent : WelcomeComponent) { }

  ngOnInit() {
    this.currentUser = this._welcomeComponent.getUser();
  }

}
