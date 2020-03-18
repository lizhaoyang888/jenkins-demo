package com.example.jenkinsdemo.controller;

import com.example.jenkinsdemo.service.StressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-18 21:41
 */

@RestController
@RequestMapping("/stress")
public class StressController {

    @Autowired
    private StressService stressService;

    @GetMapping("/easy")
    public ResponseEntity<String> easy(){
        long startTime=System.currentTimeMillis();
        stressService.easy();
        long endTime=System.currentTimeMillis();
        return new ResponseEntity<>("程序运行时间："+(endTime-startTime)+"ms", HttpStatus.OK);
    }

    @GetMapping("/hard")
    public ResponseEntity<String> hard(){
        long startTime=System.currentTimeMillis();
        stressService.hard();
        long endTime=System.currentTimeMillis();
        return new ResponseEntity<>("程序运行时间："+(endTime-startTime)+"ms", HttpStatus.OK);
    }

}
