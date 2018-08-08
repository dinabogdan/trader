package com.freesoft.wssintegration.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperties {

    private String dbUsername;
    private String password;
    private Integer minimumIdle;
    private Integer maximumPoolSize;
    private Long connectionTimeout;
    private Long idleTimeout;
    private String jdbcUrl;
}
