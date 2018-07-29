package com.freesoft.wssintegration.config;

import com.freesoft.wssintegration.factory.JsonLoginFactory;
import com.freesoft.wssintegration.factory.JsonObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonObjectFactoryConfiguration {

    @Bean(name = "jsonLoginFactory")
    public JsonObjectFactory createJsonLoginFactory() {
        return JsonLoginFactory.builder().build();
    }
}
