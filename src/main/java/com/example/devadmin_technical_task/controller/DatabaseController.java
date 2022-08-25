package com.example.devadmin_technical_task.controller;

import com.example.devadmin_technical_task.infrastructure.DeleteRequest;
import com.example.devadmin_technical_task.infrastructure.InsertRequest;
import com.example.devadmin_technical_task.infrastructure.SelectOrCreateRequest;
import com.example.devadmin_technical_task.model.service.DatabaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DatabaseController {
    private final DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @PostMapping("/select")
    public ResponseEntity<?> select(@RequestBody @Valid SelectOrCreateRequest selectOrCreateRequest) {
        try {
            String result = databaseService.selectQuery(selectOrCreateRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid SelectOrCreateRequest selectOrCreateRequest) {
        try {
            databaseService.createQuery(selectOrCreateRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteRequest deleteRequest) {
        try {
            databaseService.deleteQuery(deleteRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody @Valid InsertRequest insertRequest) {
        try {
            databaseService.insertQuery(insertRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
