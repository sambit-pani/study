import { Component, OnInit, Input } from '@angular/core';
import { TruncatePipe } from '../truncate.pipe';
import { Post } from '../post';
import { post } from 'selenium-webdriver/http';

@Component({
  selector: 'app-blog-post',
  templateUrl: './blog-post.component.html',
  styleUrls: ['./blog-post.component.scss']
})
export class BlogPostComponent implements OnInit {

  @Input() post:Post;

  fullSummary:string;
  constructor(private truncatePipe:TruncatePipe) { }

  ngOnInit() {
    this.fullSummary = this.post.summary;
    this.post.summary = this.truncatePipe.transform(this.post.summary, 25);
  }
  expand(){
    if(this.post.summary === this.fullSummary){
      this.post.summary = this.truncatePipe.transform(this.post.summary, 25);
    }else{
      this.post.summary = this.fullSummary;
    }
  }

  toggleFav(){
   this.post.isFav = !this.post.isFav;
  }
}
