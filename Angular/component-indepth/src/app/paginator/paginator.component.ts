import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.scss']
})
export class PaginatorComponent implements OnInit {

  @Input() noOfPage:number;
  @Output() pageClicked = new EventEmitter<number>();
  pages:number[];
  constructor() { }

  ngOnInit() {
    this.pages = new Array(this.noOfPage);

  }
  updatePageClick(pageNumber){
    this.pageClicked.emit(pageNumber);
  }
}
