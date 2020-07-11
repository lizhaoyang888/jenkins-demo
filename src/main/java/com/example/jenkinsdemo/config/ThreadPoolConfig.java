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

        try {
            int cpuNumber = Runtime.getRuntime().availableProcessors();
            return new ThreadPoolExecutor(
                    4,4,
                    300,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(10240),
                    threadFactory,
                    new ThreadPoolExecutor.AbortPolicy()
            );
        }catch (Exception e){
            log.info("我知道哪儿错了");
        }
        return null;
    }

}
