package com.backSpringBatch;


import com.diosmar.services.exception.InterceptExceptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@InterceptExceptions
@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@EnableEurekaClient
@EnableScheduling
@ComponentScan({"com.*", "com.diosmar.*"})
public class SpringBatchApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

}
