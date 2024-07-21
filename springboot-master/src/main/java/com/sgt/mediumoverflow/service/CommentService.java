package com.sgt.mediumoverflow.service;


import com.sgt.mediumoverflow.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class CommentService
{

    @Autowired
    CommentRepository commentRepository;

    public List<Map<String,Object>> fetchComments(int post_id)

    {
        return commentRepository.fetchComments(post_id);
    }

    public ResponseEntity<String> addComment(Map<String,Object> body)
    {
        int  user_id=(int)body.get("user_id");
        int post_id=(int)body.get("post_id");
        String comment=(String)body.get("comment");

        int noOfRows=commentRepository.addComment(user_id,post_id,comment);
        if(noOfRows > 0)
        {
            return ResponseEntity.ok("Comment Inserted Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Comment Insertion failed");
    }

    public ResponseEntity<String> deleteComment(Map<String,Object> body)
    {
        int  user_id=(int)body.get("user_id");
        int comment_id=(int)body.get("comment_id");


        int noOfRows=commentRepository.deleteComment(user_id,comment_id);
        if(noOfRows > 0)
        {
            return ResponseEntity.ok("Comment deleted Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Comment deletion failed");
    }


}
