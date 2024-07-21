package com.sgt.mediumoverflow.web;

import com.sgt.mediumoverflow.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins="http://localhost:49296")


public class CategoryResource
{

    @Autowired
    CategoryService categoryService;
    @GetMapping("/categories")
    public List<Map<String,Object>> fetchCategories()

    {
        return categoryService.fetchCategories();
    }



}

