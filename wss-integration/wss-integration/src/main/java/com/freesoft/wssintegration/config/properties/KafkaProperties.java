package com.freesoft.wssintegration.config.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@Setter(AccessLevel.PROTECTED)
@ConfigurationProperties
public class KafkaProperties {

    private String bootstrapServers;
    private String loginTopic;
}
