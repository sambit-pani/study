import { Component, OnInit, ContentChild, AfterContentInit } from '@angular/core';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss']
})
export class ShellComponent implements OnInit, AfterContentInit{

  @ContentChild("appHeader") header;
  constructor() { }

  ngOnInit() {
    console.log(this.header);
  }
  ngAfterContentInit(){
    console.log(this.header);
  }
}
