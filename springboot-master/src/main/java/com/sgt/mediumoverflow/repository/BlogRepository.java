package com.sgt.mediumoverflow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Repository
//has almost same as of service
//i.e conversion

public class BlogRepository
{
    @Autowired
    JdbcTemplate jdbctemplate;
//        public List<String> demo()
//
//    {
//        return List.of("DemoRepository1","DemoRepository2");
//    }

            public List<Map<String,Object> > fetchBlogs()
    {
        return jdbctemplate.queryForList("EXEC medium.sp_fetch_all_blogs");
    }

    public List<Map<String,Object> > fetchDataById(int category_id)
    {
        return jdbctemplate.queryForList("EXEC medium.sp_fetch_all_blogs ?",category_id);
    }
//            return jdbctemplate.queryForList("EXEC medium.sp_fetch_all_blogs");
//    can write queryForList for when there is only one row
//public List<Map<String,Object> >demo()
//    value can be of any type i.e object
//    lhs has string which will always be column name
//    Thus,Map<String,Object>

    public int insertBlog(String title,String description,int authorid,int category,String imageurl,String tags)
    {
        System.out.println(title+" "+description+" "+ authorid+" "+category+" "+imageurl+" "+tags);
        return jdbctemplate.update("EXEC [medium].[sp_insert_blog] ?,?,?,?,?,?",title,description,authorid,category,imageurl,tags);

    }


    public Map<String, Object> fetchSingleBlog(String slug)
    {
        return jdbctemplate.queryForMap("EXEC medium.sp_fetchSingleBlog ?",slug);
    }

    public int EditSingleBlog(String slug,String title,String description,String imageurl,int category)
    {
        return jdbctemplate.update("EXEC medium.sp_edit_blog ?,?,?,?,?",slug,title,description,imageurl,category);


    }








}
