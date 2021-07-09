package com.example.assign.demo.service;

import com.example.assign.demo.model.Product;
import com.example.assign.demo.repository.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductMapper productMapper;

    public Product getProductById(Long id){
        return productMapper.findProductById(id);
    }

    public List<Product> getAllProducts(){
        return productMapper.findAllProduct();
    }

    @Transactional
    public void addProduct(Product product){
        productMapper.insertProduct(product);
    }

    @Transactional
    public void changePrice(Product product){
        productMapper.updatePrice(product);
    }

    @Transactional
    public void deleteProduct(Product product){
        productMapper.deleteProduct(product);
    }
}
