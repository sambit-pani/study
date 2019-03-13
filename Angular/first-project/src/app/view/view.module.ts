import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ViewComponentComponent } from './view-component/view-component.component';
import { TestService } from '../test.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [ViewComponentComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports:[
    ViewComponentComponent
  ],
  providers:[TestService]
})
export class ViewModule { }
