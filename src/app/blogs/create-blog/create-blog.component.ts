import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { pairwise } from 'rxjs';
import { Category } from 'src/app/shared/interfaces/category.interface';
import { BlogService } from '../blog.service';


@Component({
  selector: 'app-create-blog',
  templateUrl: './create-blog.component.html',
  styleUrls: ['./create-blog.component.css']
})
export class CreateBlogComponent
{
  // title=new FormControl
  // fname=new FormControl
  // lname=new FormControl

  // Every input is our formcontrol

  CategoryData!:Category[]
  selectedCategory!:String


   createForm =new FormGroup(
    {
  title:new FormControl(),
  description:new FormControl(),
  category:new FormControl(),
  authorid:new FormControl(1),
  imageurl:new FormControl(''),
  tags:new FormControl('')
    }


  )

  check():void
{
    console.log(this.createForm.value)

}


submit():void
{
    console.log(this.createForm.value);
    this.blogService.addPost(this.createForm.value).subscribe((val)=>
    {
console.log(val)  
console.log("DONE!!") 
 })

}



constructor(private blogService:BlogService)
{

}


ngOnInit():void
{
  this.blogService.getCategories().subscribe((data: Category[])=>
  {
    console.log(data)
    this.CategoryData=data;  
  }

  )

}


SelectCategory(category:Category)
{

  console.log(category)
  this.selectedCategory=category.category_name
  this.createForm.patchValue({
    category:category.category_id
    
  })

  console.log(this.createForm.value)


}





}





// component destroy hua toh subscription should be destroyed

