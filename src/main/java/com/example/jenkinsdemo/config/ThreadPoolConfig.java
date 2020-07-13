package com.example.jenkinsdemo.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Author: lichaoyang
 * @Date: 2020-07-12 00:06
 */

@Configuration
@Slf4j
public class ThreadPoolConfig {

    @Bean("stressThreadPool")
    public ExecutorService stressThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-pool-%d").build();

        //阿里云服务器的CPU核心数量为1
        int cpuNumber = Runtime.getRuntime().availableProcessors();

        return new ThreadPoolExecutor(
                (cpuNumber * 2) + 4,
                (cpuNumber * 2) + 8,
                300,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10240),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
