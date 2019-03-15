import { Component, OnInit, Input } from '@angular/core';
import { TruncatePipe } from '../truncate.pipe';

@Component({
  selector: 'app-blog-post',
  templateUrl: './blog-post.component.html',
  styleUrls: ['./blog-post.component.scss']
})
export class BlogPostComponent implements OnInit {

  @Input() title:string;
  @Input()  summary:string;
  fullSummary:string;
  constructor(private truncatePipe:TruncatePipe) { }

  ngOnInit() {
    this.fullSummary = this.summary;
    this.summary = this.truncatePipe.transform(this.summary, 25);
  }
  expand(){
    if(this.summary === this.fullSummary){
      this.summary = this.truncatePipe.transform(this.summary, 25);
    }else{
      this.summary = this.fullSummary;
    }
  }
}
