package com.example.jenkinsdemo.controller;

import com.example.jenkinsdemo.bean.ParaObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: lichaoyang
 * @Date: 2020-03-17 00:29
 */

@RestController
public class TestController {

    @GetMapping(value = "/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("hello wold", HttpStatus.OK);
    }

    @GetMapping(value = "/branch")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("master", HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<ParaObj> get(ParaObj obj){
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<ParaObj> post(@RequestBody ParaObj obj){
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PostMapping(value = "/post2")
    public ResponseEntity<ParaObj> post2(ParaObj obj){
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
}
