package com.freesoft.wssintegration.utils;

import com.freesoft.wssintegration.config.DataSourceProperties;
import com.zaxxer.hikari.HikariConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HikariConfigAssembler {

    public static HikariConfig assemble(DataSourceProperties dataSourceProperties) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dataSourceProperties.getJdbcUrl());
        hikariConfig.setUsername(dataSourceProperties.getDbUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        hikariConfig.setConnectionTimeout(dataSourceProperties.getConnectionTimeout());
        hikariConfig.setMinimumIdle(dataSourceProperties.getMinimumIdle());
        hikariConfig.setMaximumPoolSize(dataSourceProperties.getMaximumPoolSize());
        hikariConfig.setInitializationFailFast(false);
        hikariConfig.setPoolName("TraderPool");
        return hikariConfig;
    }
}
