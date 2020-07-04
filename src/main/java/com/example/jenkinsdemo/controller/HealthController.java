package com.example.jenkinsdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lichaoyang
 * @Date: 2020-07-04 18:11
 */

@RestController
public class HealthController {

    @GetMapping(value = "/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("hello wold", HttpStatus.OK);
    }

}
