import { Component } from '@angular/core';
import { BlogService } from '../blog.service';
import { Blog } from 'src/app/shared/interfaces/blog.interface';
import { Category } from 'src/app/shared/interfaces/category.interface';

@Component({
  selector:'app-blog-list',
  templateUrl:'./blog-list.component.html',
  styleUrls:['./blog-list.component.css']
})
export class BlogListComponent 
{

  BlogData!:Blog[]
  Categorydata!:Category[]

  ALL_ID=-1
  active = this.ALL_ID




  constructor(private blogService:BlogService)
{


}


ngOnInit():void{
  this.blogService.getBlogData().subscribe((data)=>
  {
    console.log(data)
    this.BlogData=data;

  }
  
  ),
  this.blogService.getCategories().subscribe((data)=>
  {
    console.log(data)
    this.Categorydata=data;  
  }
  )

}


 fetchBlogs(event: any):void
{

  if(event===this.ALL_ID)
  {
    this.blogService.getBlogData().subscribe((data)=>
{
  console.log("HII")
  this.BlogData= data;

})
  }
  else{
    this.blogService.fetchBlogsByCategory(event).subscribe((data)=>
{
  this.BlogData= data;
  console.log(this.active)
})

  }

}



}
