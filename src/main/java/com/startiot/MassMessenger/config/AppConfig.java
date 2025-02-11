package com.startiot.MassMessenger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AppConfig implements AsyncConfigurer {

    @Bean(name = "threadPoolTaskExecutor")
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3); // Número mínimo de hilos.
        executor.setMaxPoolSize(5); // Número máximo de hilos.
        executor.setQueueCapacity(1000); // Capacidad máxima del buffer (cola).

        // Configura el comportamiento cuando se alcanza el límite:
        executor.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

        executor.afterPropertiesSet(); // Inicializa los hilos.

        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor();
    }

}