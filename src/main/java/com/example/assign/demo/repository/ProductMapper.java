package com.example.assign.demo.repository;

import com.example.assign.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product findProductById(Long id);
    List<Product> findAllProduct();
    void insertProduct(Product product);
    void updatePrice(Product product);
    void deleteProduct(Product product);
}
