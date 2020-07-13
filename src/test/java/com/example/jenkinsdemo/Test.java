package com.example.jenkinsdemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: lichaoyang
 * @Date: 2020-07-13 11:02
 */
public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = threadPool();
        executorService.submit(()->{
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            System.out.println("hello world");
        });
    }

    public static ExecutorService threadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-pool-%d").build();

        int cpuNumber = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(
                (cpuNumber * 2) + 4,
                cpuNumber * 1,
                300,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10240),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
