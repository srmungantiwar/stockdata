import { Component, OnInit } from '@angular/core';
import { WelcomeService } from '../welcome.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {
  currentUser : any;

  constructor(private _welcomeService : WelcomeService) { }

   ngOnInit() {   
    this._welcomeService.getCurrentUser().subscribe((data : any) =>{
       this.currentUser =  data;

       console.log(JSON.stringify(this.currentUser));
    });
  }

}
