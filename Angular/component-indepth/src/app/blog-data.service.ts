import { Injectable } from '@angular/core';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class BlogDataService {

  constructor() { }

  getData():Post[][]{
    return [
      [new Post("title1","summar of blog 1.adding more content to truncate"),
        new Post("title 2","summary of blog post 2. adding more content to truncate"),
        new Post("title 3","summary of blog post 3.adding more content to truncate")
      ],
      [new Post("title4","summar of blog 4.adding more content to truncate"),
      new Post("title 5","summary of blog post 5. adding more content to truncate"),
      new Post("title 6","summary of blog post 6.adding more content to truncate")
     ],
      [new Post("title7","summar of blog 7.adding more content to truncate"),
       new Post("title 8","summary of blog post 8. adding more content to truncate"),
       new Post("title 9","summary of blog post 9.adding more content to truncate")
     ]

    ];
  }
}
