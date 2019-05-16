package com.simplemultidbsource.mdbs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "testCommonEntityManagerFactory",
        transactionManagerRef = "testCommonTransactionManager",
        basePackages = {"com.simplemultidbsource.mdbs.repository.test_common"})
public class TestCommonDbConfig {

    private final Environment env;

    @Autowired
    public TestCommonDbConfig(Environment env) {
        this.env = env;
    }

    @Primary
    @Bean(name = "testCommonDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource testCommonDataSource() {
//        return DataSourceBuilder.create().build();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean(name = "testCommonEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean commonEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("testCommonDataSource") DataSource testCommonDataSource) {
        return builder.dataSource(testCommonDataSource).packages("com.simplemultidbsource.mdbs.domain.model").persistenceUnit("multi_db_common")
                .build();
    }

    @Primary
    @Bean(name = "testCommonTransactionManager")
    public PlatformTransactionManager testCommonTransactionManager(
            @Qualifier("testCommonEntityManagerFactory") EntityManagerFactory commonEntityManagerFactory) {
        return new JpaTransactionManager(commonEntityManagerFactory);
    }
}
