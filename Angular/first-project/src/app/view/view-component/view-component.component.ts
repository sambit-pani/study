import { Component, OnInit } from '@angular/core';
import { TestService } from 'src/app/test.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-view-component',
  templateUrl: './view-component.component.html',
  styleUrls: ['./view-component.component.css']
})
export class ViewComponentComponent implements OnInit {

  userName:string;
  response:any;
  constructor(private svc:TestService,private client:HttpClient) { 
    svc.printToConsole("view module");
  }

  ngOnInit() {
  }
  getUserDetails(){
    console.log("function is called");
    let obs = this.client.get('https://api.github.com/users/'+this.userName);
    obs.subscribe((res) => {this.response = res});
  }
}
