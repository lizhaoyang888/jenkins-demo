package com.example.jenkinsdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutorService;

/**
 * @Author: lichaoyang
 * @Date: 2020-07-12 00:13
 */

@Service
@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String maxString = "面朝大海，春暖花开\n" +
            "从明天起，做一个幸福的人\n" +
            "喂马，劈柴，周游世界\n" +
            "从明天起，关心粮食和蔬菜\n" +
            "我有一所房子，面朝大海，春暖花开\n" +
            "\n" +
            "从明天起，和每一个亲人通信\n" +
            "告诉他们我的幸福\n" +
            "那幸福的闪电告诉我的\n" +
            "我将告诉每一个人\n" +
            "\n" +
            "给每一条河每一座山取一个温暖的名字\n" +
            "陌生人，我也为你祝福\n" +
            "愿你有一个灿烂的前程\n" +
            "愿你有情人终成眷属\n" +
            "愿你在尘世获得幸福\n" +
            "我只愿面朝大海，春暖花开";

    @Qualifier("threadPool")
    @Autowired
    private ExecutorService executorService;

    public void memoryLeak(){
        executorService.submit(()->{
            threadLocal.set(Thread.currentThread().getName()+UUID.randomUUID()+maxString);
            log.info(threadLocal.get());
        });
    }


}
