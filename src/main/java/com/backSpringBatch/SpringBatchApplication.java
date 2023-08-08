package com.backSpringBatch;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@EnableScheduling
//@EnableEurekaClient
public class SpringBatchApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

}
