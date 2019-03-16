import { Component, OnInit, ViewChild, ViewChildren, QueryList } from '@angular/core';
import {Post} from '../post';
import { BlogPostComponent } from '../blog-post/blog-post.component';
import { BlogDataService } from '../blog-data.service';


@Component({
  selector: 'app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.scss']
})
export class BlogListComponent implements OnInit {

  posts:Post[][];
  currentPage:number;
  @ViewChild("firstComp") firstComponent:BlogPostComponent;

  @ViewChildren("postComponents") postComponents: QueryList<any>;

  constructor(private dataService:BlogDataService) { }

  ngOnInit() {
    this.currentPage = 0;
    this.posts = this.dataService.getData();
  }
  updatePage(page){
    console.log("update page is blog-list component");
    this.currentPage = page;
  }

  expandFirst(){
    this.firstComponent.expand();
  }

  expandAll(){
    this.postComponents.forEach(post => post.expand());
  }

}
