package com.example.assign.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@RequiredArgsConstructor
@Component
public class TestRunner implements ApplicationRunner {

    final DataSource dataSource;
    final JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Connection conn = dataSource.getConnection();
        log.info("Url : " + conn.getMetaData().getURL());

        String query = "insert into products (prod_name, prod_price) values ('버킷햇', 7900)";
        jdbcTemplate.execute(query);
    }
}
