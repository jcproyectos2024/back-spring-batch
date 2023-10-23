package com.backSpringBatch.conf;

import com.diosmar.LogProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogProducerConfig {

    @Bean
    public LogProducer createInstance(){
        return new LogProducer();
    }
}