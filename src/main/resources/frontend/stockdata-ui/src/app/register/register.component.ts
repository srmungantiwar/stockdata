import { Component, OnInit , ViewChild} from '@angular/core';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  @ViewChild('userForm',null) formValues:any; 

  showMsg: boolean = false;
  registerUserData = {}
  constructor(private _auth:AuthService) { }

  ngOnInit() {
  }

  registerUser(){
    this._auth.registerUser(this.registerUserData)
    .subscribe(
      res => {
        this.showMsg = true;
        this.formValues.resetForm();
        console.log(res);
      },
      err => console.log(err)
    )
  }
}
