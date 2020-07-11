package com.example.jenkinsdemo.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Author: lichaoyang
 * @Date: 2020-07-12 00:06
 */

@Configuration
public class ThreadPoolConfig {

    @Bean("threadPool")
    public ExecutorService threadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-pool-%d").build();

        int cpuNumber = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(
                (cpuNumber * 2) + 4,
                cpuNumber * 4,
                300,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10240),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
