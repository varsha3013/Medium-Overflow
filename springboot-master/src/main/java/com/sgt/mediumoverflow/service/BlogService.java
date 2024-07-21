package com.sgt.mediumoverflow.service;

//Service is an extended version of bean
//not much difference
//only logical difference
//only it has business logic
//we can use bean as well


import com.sgt.mediumoverflow.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class BlogService
{
//    public List<String> demo()
//
//    {
//        return List.of("DemoService1","DemoService2");
//    }


    @Autowired
    BlogRepository blogRepository;

//    public List<String> demo()
//
//    {
//        return demoRepository.demo();
//    }


    public List<Map<String,Object>> fetchBlogs()

    {
        return blogRepository.fetchBlogs();
    }

//    public void insertBlog(Map<String,Object> body)
//    {
//        String title=(String) body.get("title");
//        String description=(String)body.get("description");
//        int authorid=(int)body.get("authorid");
//        int category=(int)body.get("category");
//        String imageurl=(String)body.get("imageurl");
//
//        System.out.println(title+" "+description+" "+authorid+" "+category+" "+"imageurl");
//
//
//    }

    public List<Map<String,Object>> fetchDataById( int category_id)
    {
        return blogRepository.fetchDataById(category_id);
    }



    public ResponseEntity<String> insertBlog(Map<String,Object> body)
    {
        String title=(String) body.get("title");
        String description=(String)body.get("description");
         int authorid=(int)body.get("authorid");
        int category=(int)body.get("category");
        String imageurl=(String)body.get("imageurl");
        String tags=(String)body.get("tags");
//        System.out.println(tags);
        int noOfRows=blogRepository.insertBlog(title,description,authorid,category,imageurl,tags);
//        System.out.println(noOfRows);
        if(noOfRows > 0)
        {
            return ResponseEntity.ok("Successfully inserted");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Insertion failed");

    }
    public Map<String,Object> fetchSingleBlog(String slug)
    {
        return blogRepository.fetchSingleBlog(slug);
    }

    public ResponseEntity<String> EditSingleBlog(@PathVariable String slug, @RequestBody Map<String,Object> body)
    {
        String title=(String) body.get("title");
        String description=(String)body.get("description");
        String imageurl=(String)body.get("imageurl");
        int category=(int)body.get("category");

        int noOfRows=blogRepository.EditSingleBlog(slug,title,description,imageurl,category);
        if(noOfRows > 0)
        {
            return ResponseEntity.ok("Successfully updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Updation failed");


    }


}


