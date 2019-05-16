package com.simplemultidbsource.mdbs.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

//    @Bean
//    @Primary
//    public DataSource getDataSourceTestCommon() {
//
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////        dataSourceBuilder.driverClassName("org.h2.Driver");
////        dataSourceBuilder.url("jdbc:h2:mem:test");
////        dataSourceBuilder.username("SA");
////        dataSourceBuilder.password("");
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:33062/multi_db_common");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("root");
//        return dataSourceBuilder.build();
//    }

//    @Bean
//    public DataSource getDataSourceTest1() {
//
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////        dataSourceBuilder.driverClassName("org.h2.Driver");
////        dataSourceBuilder.url("jdbc:h2:mem:test");
////        dataSourceBuilder.username("SA");
////        dataSourceBuilder.password("");
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:33062/multi_db_c1");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("root");
//        return dataSourceBuilder.build();
//    }
}
