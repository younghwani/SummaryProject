package com.younghwani.summarize.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class MySQLRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()){
            System.out.println("MySQL Connection : " + connection);
            String URL = connection.getMetaData().getURL();
            System.out.println("MySQL URL : " + URL);
            String User = connection.getMetaData().getUserName();
            System.out.println("MySQL User : " + User);
        }
    }
}
