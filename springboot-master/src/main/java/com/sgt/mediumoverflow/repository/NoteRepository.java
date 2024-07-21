package com.sgt.mediumoverflow.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class NoteRepository
{
    @Autowired
    JdbcTemplate jdbctemplate;
    public List<Map<String,Object>> fetchNotes(int user_id)
    {
        return jdbctemplate.queryForList("EXEC oneNote.GetAllNotes ?",user_id);
    }
    public List<Map<String,Object>> fetchRecentNotes(int user_id,int recent)
    {
        return jdbctemplate.queryForList("EXEC oneNote.GetAllNotes ?,?",user_id,recent);
    }




    public List<Map<String,Object>> fetchSingleNote(String slug)
    {
        return jdbctemplate.queryForList("EXEC oneNote.GetSingleNote ?",slug);
    }




//    Register User
public int registerNoteUser(String full_name,String username,String email,String password,String dob,String country)
{
    return jdbctemplate.update("EXEC oneNote.registerUser ?,?,?,?,?,?",full_name,username,email,password,dob,country);
}



}
