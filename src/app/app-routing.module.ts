import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlogListComponent } from './blogs/blog-list/blog-list.component';
import { HeroComponent } from './home/hero/hero.component';
import { SingleBlogComponent } from './blogs/single-blog/single-blog.component';
import { CreateBlogComponent } from './blogs/create-blog/create-blog.component';

const routes: Routes = [

  {
    path:'blogs',
    component:BlogListComponent
  },
  {
    path:'',
    component:HeroComponent
  },
  {
    path:'blog/:slug',
    component:SingleBlogComponent
  },
  {
    path:'create-blog',
    component:CreateBlogComponent

  }
];

// here we write our routes
// routes is an object
// routes ka Array
// whatever we register
// /blogs /something
// is child
// /4200/BlogsModule
// is root level


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

// this is the module where we configure our routes
// whar are routes
// jaise /blogs pe blogs wala list aana chaiye

