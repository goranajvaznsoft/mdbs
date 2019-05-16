package com.simplemultidbsource.mdbs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "test2EntityManagerFactory",
        transactionManagerRef = "test2TransactionManager",
        basePackages = {"com.simplemultidbsource.mdbs.repository.test2"})
public class Test2DbConfig {

    private final Environment env;

    @Autowired
    public Test2DbConfig(Environment env) {
        this.env = env;
    }

    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.test2")
    public DataSource test2dataSource() {
//        return DataSourceBuilder.create().build();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.test2.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.test2.url"));
        dataSource.setUsername(env.getProperty("spring.test2.username"));
        dataSource.setPassword(env.getProperty("spring.test2.password"));

        return dataSource;
    }

    @Bean(name = "test2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean commonEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("test2DataSource") DataSource test2dataSource) {
        return builder.dataSource(test2dataSource).packages("com.simplemultidbsource.mdbs.domain.model").persistenceUnit("multi_db_c2")
                .build();
    }

    @Bean(name = "test2TransactionManager")
    public PlatformTransactionManager test2TransactionManager(
            @Qualifier("test2EntityManagerFactory") EntityManagerFactory commonEntityManagerFactory) {
        return new JpaTransactionManager(commonEntityManagerFactory);
    }
}
