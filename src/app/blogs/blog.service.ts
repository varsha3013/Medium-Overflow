import { Injectable } from '@angular/core';
import { Blog } from '../shared/interfaces/blog.interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class BlogService {

  constructor( private http:HttpClient) 
  {

   }

  // getBlogData():Blog[]
  // {
  //    return [
  //     {
  //         "title": "HELLO TECHNOLOGY",
  //         "description": "Dummy data desc",
  //         "published_at": "2023-10-22T11:37:20.900+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "Programming,Nature,Programming,Painting,Programming,tag1,tag2,tag3,tag4"
  //     },
  //     {
  //         "title": "Introduction to SQL",
  //         "description": "Learn the basics of SQL.",
  //         "published_at": "2023-10-23T14:54:04.343+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "sql.jpg",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "Nature"
  //     },
  //     {
  //         "title": "Exploring Nature",
  //         "description": "Adventures in the wilderness.",
  //         "published_at": "2023-10-23T14:54:04.343+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "nature.jpg",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "Cooking"
  //     },
  //     {
  //         "title": "Delicious Recipes",
  //         "description": "Cooking your favorite dishes.",
  //         "published_at": "2023-10-23T14:54:04.343+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "food.jpg",
  //         "category_name": "FICTION",
  //         "full_name": "John Doe",
  //         "tags": "Style"
  //     },
  //     {
  //         "title": "tobedeletedsoon",
  //         "description": "tobedeletedsoon",
  //         "published_at": "2023-12-18T07:39:56.910+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "tobedeletedsoon",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag1,testtag2"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T07:52:09.730+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T07:53:35.893+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T07:54:22.610+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T07:55:38.003+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T07:56:42.627+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T07:57:25.250+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T07:58:03.493+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T08:00:06.660+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T08:03:45.670+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag10,testtag11,testtag13"
  //     },
  //     {
  //         "title": "test_18dec",
  //         "description": "test_18dec",
  //         "published_at": "2023-12-18T08:04:29.060+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_18dec",
  //         "category_name": "TECHNOLOGY",
  //         "full_name": "Vidhhi lulla",
  //         "tags": "testtag110,testtag111,testtag113"
  //     },
  //     {
  //         "title": "test_19dec",
  //         "description": "test_19dec",
  //         "published_at": "2023-12-18T08:05:00.310+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dec",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1110,testtag1111,testtag1113"
  //     },
  //     {
  //         "title": "test_19dec",
  //         "description": "test_19dec",
  //         "published_at": "2023-12-18T08:08:36.560+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dec",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag111,testtag222,testtag333"
  //     },
  //     {
  //         "title": "test_19dec",
  //         "description": "test_19dec",
  //         "published_at": "2023-12-18T08:08:54.853+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dec",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1110,testtag1111,testtag1113"
  //     },
  //     {
  //         "title": "test_19dec",
  //         "description": "test_19dec",
  //         "published_at": "2023-12-18T08:10:38.187+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dec",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1110,testtag1111,testtag1113"
  //     },
  //     {
  //         "title": "test_19dec",
  //         "description": "test_19dec",
  //         "published_at": "2023-12-19T13:26:37.007+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dec",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1110,testtag1111,testtag1113"
  //     },
  //     {
  //         "title": "test_19dec",
  //         "description": "test_19dec",
  //         "published_at": "2023-12-19T13:29:59.797+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dec",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1110,testtag1111,testtag1113"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T13:32:10.267+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T13:33:39.013+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T15:32:52.140+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T15:33:07.940+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T15:37:33.207+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "1",
  //         "description": "1",
  //         "published_at": "2023-12-19T15:38:55.663+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "1",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "1,1,1,1,1,1,1,1,1"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T15:40:58.257+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T15:42:27.903+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T15:43:38.750+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     },
  //     {
  //         "title": "test_19dectoday",
  //         "description": "test_19dectoday",
  //         "published_at": "2023-12-19T15:45:01.303+00:00",
  //         "no_of_likes": 0,
  //         "no_of_comments": 0,
  //         "image_url": "test_19dectoday",
  //         "category_name": "FASHION",
  //         "full_name": "Mohit Narang",
  //         "tags": "testtag1111,testtag1113,test_19dectoday"
  //     }
  // ]
  // }

  getBlogData():Observable<any>
  {
    return this.http.get('http://localhost:8080/api/blogs')
  }


  getCategories():Observable<any>
  {
    return this.http.get('http://localhost:8080/api/categories')
  }

  fetchBlogsByCategory(category_id:number):Observable<Blog[]>
  {
    return this.http.get<Blog[]>(`http://localhost:8080/api/blogs/category/${category_id}`)
  }

  getSingleBlogData(slug:string):Observable<Blog>
  {
    return this.http.get<Blog>(`http://localhost:8080/api/blogs/${slug}`)
  }

  addPost(data:any):Observable<any>
  {
    return this.http.post('http://localhost:8080/api/blog',data)
  }
  


  
}
