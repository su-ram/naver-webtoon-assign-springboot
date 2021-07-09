package com.example.assign.demo.service;

import com.example.assign.demo.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class ProductMapper implements RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product p = new Product();
            p.setProdId(resultSet.getLong("prod_id"));
            p.setProdName(resultSet.getString("prod_name"));
            p.setProdPrice(resultSet.getInt("prod_price"));
            return p;
        }
    }

    @Test
    public void getProductById(){
        Product prod = productService.getProductById(1L);
        prod.setProdPrice(12000);
        productService.changePrice(prod);
        Product newProd = new Product("에어포스", 200000);
        productService.addProduct(newProd);
        productService.deleteProduct(prod);

        for(Product p : productService.getAllProducts()) {
            System.out.println(p);
        };
    }

    @Test
    public void setJdbcTemplate(){

        String query = "insert into products (prod_name, prod_price) values (?, ?)";
        Product newProd = new Product("에어포스", 200000);
        jdbcTemplate.update(query, newProd.getProdName(), newProd.getProdPrice());
        jdbcTemplate.update("delete from products where prod_id >3");

        query = "select * from products";
        for(Product p : jdbcTemplate.query(query, new ProductMapper())){
            System.out.println(p);
        }

    }



}
