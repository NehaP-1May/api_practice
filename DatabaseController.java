package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/data")
    public List<String> getData() {
        return databaseService.getDataFromDatabase();
    }
}
