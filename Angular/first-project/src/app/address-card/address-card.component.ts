import { Component, OnInit, Input } from '@angular/core';
import { User } from './user.model';

@Component({
  selector: 'app-address-card',
  templateUrl: './address-card.component.html',
  styleUrls: ['./address-card.component.css']
})
export class AddressCardComponent implements OnInit {
  @Input() userObj:User;
  @Input("id") userId:number;
  user:any;

  isCollapsed : boolean = false;
  buttonValue : string = "Collapse";
 
  constructor() {
    
   }
   onCollapsed(){
     this.isCollapsed = !this.isCollapsed;
     this.buttonValue = this.isCollapsed ? "Expand":"Collapse";
   }
  ngOnInit() {
    this.user = {
      name: this.userObj.name,
      title:this.userObj.designation,
      address:this.userObj.address,
      phone:this.userObj.phones
    };
  }

}
