package com.sgt.mediumoverflow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository
{
    @Autowired
    JdbcTemplate jdbctemplate;
    public int registerUser(String full_name,String username,String email,String password,String dob,String bio)
    {

        return jdbctemplate.update("EXEC dbo.sp_register_user ?,?,?,?,?,?",full_name,username,email,password,dob,bio);


    }
}
