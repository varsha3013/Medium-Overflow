package com.sgt.mediumoverflow.web;


import com.sgt.mediumoverflow.service.BlogService;
import com.sgt.mediumoverflow.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class ProductResource
{
    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public List<Map<String,Object>> fetchProducts()

    {
        return productService.fetchProducts();
    }


    @GetMapping("/products/category/{category_id}")
    public List<Map<String,Object>> fetchProductsById(@PathVariable int category_id)
    {
        return productService.fetchProductsById(category_id);
    }

    @GetMapping("/categoriesOfProducts")
    public List<Map<String,Object>> fetchcategoriesOfProducts()

    {
        return productService.fetchcategoriesOfProducts();
    }

}
