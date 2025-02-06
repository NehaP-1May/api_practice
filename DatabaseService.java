package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public List<String> getDataFromDatabase() {
        List<String> data = new ArrayList<>();
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection to the Oracle DB
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Execute a query to fetch data
            Statement stmt = connection.createStatement();
            String sql = "SELECT column_name FROM table_name"; // Update with your query
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result
            while (rs.next()) {
                data.add(rs.getString("column_name")); // Update with your column name
            }

            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

//- Replace `table_name` and `column_name` in the `DatabaseService` with the actual table and column names from your Oracle database.

//Test 2

