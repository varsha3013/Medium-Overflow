package com.sgt.mediumoverflow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository
{
    @Autowired
    JdbcTemplate jdbctemplate;

    public List<Map<String,Object>> fetchComments(int post_id)
    {
        return jdbctemplate.queryForList("EXEC medium.sp_fetch_all_comments ?",post_id);
    }

    public int addComment(int user_id,int post_id,String comment)
    {
        return jdbctemplate.update("EXEC medium.add_comment ?,?,?",user_id,post_id,comment);
    }

    public int deleteComment(int user_id,int comment_id)
    {
        return jdbctemplate.update("EXEC medium.sp_delete_comment ?,?",user_id,comment_id);
    }
}

