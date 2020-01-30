import { Component, OnInit } from '@angular/core';
import { WelcomeService } from '../welcome.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {

  constructor(private _welcomeService : WelcomeService) { }

  ngOnInit() {
    this._welcomeService.greetUser();
  }

}
