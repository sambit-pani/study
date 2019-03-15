import { Component, OnInit } from '@angular/core';
import {Post} from '../post';


@Component({
  selector: 'app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.scss']
})
export class BlogListComponent implements OnInit {

  posts:Post[][];
  currentPage:number;
  constructor() { }

  ngOnInit() {
    this.currentPage = 0;
    this.posts = [
      [new Post("title1","summar of blog 1"),
        new Post("title 2","summary of blog post 2. adding more content to truncate"),
        new Post("title 3","summary of blog post 3")
      ],
      [new Post("title4","summar of blog 4"),
      new Post("title 5","summary of blog post 5. adding more content to truncate"),
      new Post("title 6","summary of blog post 6")
     ],
      [new Post("title7","summar of blog 7"),
       new Post("title 8","summary of blog post 8. adding more content to truncate"),
       new Post("title 9","summary of blog post 9")
     ]

    ];
  }
  updatePage(page){
    console.log("update page is blog-list component");
    this.currentPage = page;
  }
}
