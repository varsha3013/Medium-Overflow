package com.sgt.mediumoverflow.service;

import com.sgt.mediumoverflow.repository.BlogRepository;
import com.sgt.mediumoverflow.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class NoteService
{

    @Autowired
    NoteRepository noteRepository;
    public List<Map<String,Object>> fetchNotes(int user_id)

    {
        return noteRepository.fetchNotes(user_id);
    }

    public List<Map<String,Object>> fetchRecentNotes(int user_id,int recent)

    {
        return noteRepository.fetchRecentNotes(user_id,recent);
    }

    public List<Map<String,Object>> fetchSingleNote(String slug)

    {
        return noteRepository.fetchSingleNote(slug);
    }

//    Register user
public ResponseEntity<String> registerNoteUser(@RequestBody Map<String,Object> body)
{




    String user_name=(String)body.get("user_name");
    String full_name=(String) body.get("full_name");
    String email=(String)body.get("email");
    String password=(String)body.get("password");
    String dob=(String)body.get("dob");
    String country=(String)body.get("country");


    int noOfRows=noteRepository.registerNoteUser(full_name,user_name,email,password,dob,country);

    if(noOfRows > 0)
    {
        return ResponseEntity.ok(" User is successfully registered");
    }
    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Registration failed");

}

}
