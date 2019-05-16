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
        entityManagerFactoryRef = "test1EntityManagerFactory",
        transactionManagerRef = "test1TransactionManager",
        basePackages = {"com.simplemultidbsource.mdbs.repository.test1"})
public class Test1DbConfig {

    private final Environment env;

    @Autowired
    public Test1DbConfig(Environment env) {
        this.env = env;
    }

    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.test1")
    public DataSource test1dataSource() {
//        return DataSourceBuilder.create().build();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.test1.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.test1.url"));
        dataSource.setUsername(env.getProperty("spring.test1.username"));
        dataSource.setPassword(env.getProperty("spring.test1.password"));

        return dataSource;
    }

    @Bean(name = "test1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean commonEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("test1DataSource") DataSource test1dataSource) {
        return builder.dataSource(test1dataSource).packages("com.simplemultidbsource.mdbs.domain.model").persistenceUnit("multi_db_c1")
                .build();
    }

    @Bean(name = "test1TransactionManager")
    public PlatformTransactionManager test1TransactionManager(
            @Qualifier("test1EntityManagerFactory") EntityManagerFactory commonEntityManagerFactory) {
        return new JpaTransactionManager(commonEntityManagerFactory);
    }
}
