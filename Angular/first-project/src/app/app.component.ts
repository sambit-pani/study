import { Component } from '@angular/core';
import { User } from './address-card/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hello Angular';
  user:User;

  textValue:string = "abc";

  constructor(){
    this.user = new User();
    this.user.name = "makuli";
    this.user.designation="tutuli";
    this.user.address = "address of user";
    this.user.phones = [12321,9124,9677064618];
  }
}
