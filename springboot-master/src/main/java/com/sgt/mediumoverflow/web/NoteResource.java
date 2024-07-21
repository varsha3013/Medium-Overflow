package com.sgt.mediumoverflow.web;


import com.sgt.mediumoverflow.service.BlogService;
import com.sgt.mediumoverflow.service.NoteService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class NoteResource
{
//    to get all notes
@Autowired
NoteService noteService;

    @GetMapping("/notes/{user_id}")
    public List<Map<String,Object>> fetchNotes(@PathVariable int user_id)

    {
        return noteService.fetchNotes(user_id);
    }


    @GetMapping("/notes/{user_id}/{recent}")
    public List<Map<String,Object>> fetchRecentNotes(@PathVariable int user_id,@PathVariable int recent)

    {
        return noteService.fetchRecentNotes(user_id,recent);
    }


//    Get single note:
@GetMapping("/notes/fetch/{slug}")
    public List<Map<String,Object>> fetchSingleNote(@PathVariable String slug)

    {
        return noteService.fetchSingleNote(slug);
    }

    @PostMapping("/register-user")
    public ResponseEntity<String> registerNoteUser(@RequestBody Map<String,Object> body)
    {
        return noteService.registerNoteUser(body);
    }



}
