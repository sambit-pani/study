import { Component } from '@angular/core';
import { User } from './address-card/user.model';
import { TestService } from './test.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hello Angular';
  user:User;

  textValue:string = "abc";

  constructor(private ser:TestService,private client:HttpClient){
    this.user = new User();
    this.user.name = "makuli";
    this.user.designation="tutuli";
    this.user.address = "address of user";
    this.user.phones = [12321,9124,9677064618];
    ser.printToConsole("app module");
  }

  ngOnInit(){
    let obs = this.client.get('https://api.github.com/users/sambit-pani');
    obs.subscribe((res) => console.log(res));
  }
}
