package com.sgt.mediumoverflow.service;


import com.sgt.mediumoverflow.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;

    public List<Map<String,Object>> fetchProducts()

    {
        return productRepository.fetchProducts();
    }

    public List<Map<String,Object>> fetchProductsById( int category_id)
    {
        return productRepository.fetchProductsById(category_id);
    }

    public List<Map<String,Object>> fetchcategoriesOfProducts()
    {
        return productRepository.fetchcategoriesOfProducts();
    }



}
