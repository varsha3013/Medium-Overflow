import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Blog } from 'src/app/shared/interfaces/blog.interface';
import { BlogService } from '../blog.service';

@Component({
  selector: 'app-single-blog',
  templateUrl: './single-blog.component.html',
  styleUrls: ['./single-blog.component.css']
})
export class SingleBlogComponent

{
  slug!:string;
  SingleBlogData!:Blog


  constructor(private route:ActivatedRoute,private blogService:BlogService)
  {
    this.route.params.subscribe((value)=>
    {
      this.slug=value['slug'];
      console.log(this.slug)
    })
  }


  ngOnInit():void{


    this.blogService.getSingleBlogData(this.slug).subscribe((data: Blog)=>
    {
      console.log(data)
      this.SingleBlogData=data;  
    }
    )
  }


}
