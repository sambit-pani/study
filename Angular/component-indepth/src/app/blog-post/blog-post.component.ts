import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-blog-post',
  templateUrl: './blog-post.component.html',
  styleUrls: ['./blog-post.component.scss']
})
export class BlogPostComponent implements OnInit {

  @Input() title:string;
  @Input()  summary:string;
  constructor() { }

  ngOnInit() {
    
  }

}
