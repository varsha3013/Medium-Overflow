package com.sgt.mediumoverflow.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository
{

    @Autowired
    JdbcTemplate jdbctemplate;


    public List<Map<String,Object>> fetchProducts()
    {
        return jdbctemplate.queryForList("EXEC ecommerce.sp_fetch_all_products");
    }


    public List<Map<String,Object> > fetchProductsById(int category_id)
    {
        return jdbctemplate.queryForList("EXEC ecommerce.sp_fetch_all_products ?",category_id);
    }

    public List<Map<String,Object>> fetchcategoriesOfProducts()
    {
        return jdbctemplate.queryForList("EXEC ecommerce.sp_fetch_category");
    }
}
