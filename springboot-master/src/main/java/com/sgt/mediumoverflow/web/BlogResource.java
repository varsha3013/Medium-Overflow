package com.sgt.mediumoverflow.web;

import com.sgt.mediumoverflow.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


//Creating/making an endpoint
//It is an extension of a bean
//It is also a bean and has some other responsibilities
//json to java and vice-versa

//
//@GetMapping("/blogs")
////Vo map kar raha hai ki konsi request ayi hai
////and map it to the function
////So,when we say /blogs and the request type is also GET
////This function will be called
//public List<String> demo()
//        {
//            return List.of("Demo1","Demo2");
//        }

//Postman is a client api for testing

//To tell that the url is api-generated
//so we put a prefix it with /api
//To understand that it is not going to show anything on screen
//but to display data

//The original api is written over the class

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="http://127.0.0.1:5500/")
@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins="http://localhost:49296")
public class BlogResource
{

//    @GetMapping("/blogs")
////Vo map kar raha hai ki konsi request ayi hai
////and map it to the function
////So,when we say /blogs and the request type is also GET
////This function will be called
//public List<String> demo()
//
//        {
//            return List.of("Demo1","Demo2");
//        }

    @Autowired
    BlogService blogService;

//    @GetMapping("/blogs")
//    public List<String> demo()
//
//        {
//            return demoService.demo();
//        }

    @GetMapping("/blogs")
    public List<Map<String,Object>>fetchBlogs()

    {
        return blogService.fetchBlogs();
    }


    @GetMapping("/blogs/category/{category_id}")
    public List<Map<String,Object>> fetchDataById(@PathVariable int category_id)
    {
        return blogService.fetchDataById(category_id);
    }


//        @GetMapping("/blogs")
//    For these after slash we should normally not write a verb
//    eg.fetchblogs
//    we understand it with the help of request


//    @PostMapping ("/blog")
//    public void insertBlog(@RequestBody Map<String,String> body)
//    {
//        System.out.println(body);
//    }
//Extraction is also a logic
//    which is not to be written in resource
//    in service



    @PostMapping ("/blog")
    public ResponseEntity<String> insertBlog(@RequestBody Map<String,Object> body)
    {
        return blogService.insertBlog(body);
    }
//    passing the body
//    with the annotation requestbody

//    14 december
@GetMapping("/blogs/{slug}")
public Map<String,Object> fetchSingleBlog(@PathVariable String slug)
{
    return blogService.fetchSingleBlog(slug);
}


//    In fetch single blog we are fetching all the details


    @PostMapping("/blog/{slug}")
    public ResponseEntity<String> EditSingleBlog(@PathVariable String slug,@RequestBody Map<String,Object> body)
    {
        return blogService.EditSingleBlog(slug,body);
    }

}
