import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.css']
})
export class DateComponent implements OnInit {

  dateMessage:string;
  constructor() { 
    setInterval(() => {
      let date = new Date();
      this.dateMessage = date.toDateString()+" "+date.toLocaleTimeString();
    },1000);
  }
  ngOnInit() {}
  addNumber(a:number,b:number):number{
      return a+b;
  }
}
