package com.example.jenkinsdemo.controller;

import com.example.jenkinsdemo.bean.MaxObj;
import com.example.jenkinsdemo.service.StressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-18 21:41
 */

@RestController
@RequestMapping("/stress")
@Slf4j
public class StressController {

    @Autowired
    private StressService stressService;

    @GetMapping(value = "/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("stress", HttpStatus.OK);
    }

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

    @PostMapping("/flow")
    public ResponseEntity flow(@RequestBody MaxObj maxObj){
        return new ResponseEntity(maxObj,HttpStatus.OK);
    }

}
