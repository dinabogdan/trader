package com.freesoft.wssintegration.config;

import com.freesoft.wssintegration.utils.HikariConfigAssembler;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    @Primary
    public DataSource createDatSource(DataSourceProperties dataSourceProperties) {
        return new HikariDataSource(HikariConfigAssembler.assemble(dataSourceProperties));
    }
}
