package com.sgt.mediumoverflow.web;

import com.sgt.mediumoverflow.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:49296")

public class CommentResource
{
    @Autowired
    CommentService commentService;

    @GetMapping ("/comments/{post_id}")
    public List<Map<String,Object>> fetchComments(@PathVariable int post_id)
    {
        return commentService.fetchComments(post_id);
    }

    @PostMapping("/comments")
    public ResponseEntity<String> addComment(@RequestBody Map<String,Object> body)
    {
        return commentService.addComment(body);
    }

    @PutMapping ("/comments")
    public ResponseEntity<String> deleteComment(@RequestBody Map<String,Object> body)
    {
        return commentService.deleteComment(body);
    }

}
