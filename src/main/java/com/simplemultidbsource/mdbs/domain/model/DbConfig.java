package com.simplemultidbsource.mdbs.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "DbConfig")
@Table(name = "db_config")
public class DbConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String url;

    @Column(length = 32)
    private String username;

    @Column(length = 32)
    private String password;

    @Column(length = 64)
    private String driver;

    @Column(length = 128)
    private String dialect;

    @Column(length = 16)
    private String ddl;

    @Column(length = 128)
    private Short sql;

    @Column
    private Boolean primary;

    public DbConfig() {
    }

    public DbConfig(String name, String url, String username, String password, String driver, String dialect, String ddl, Short sql, Boolean primary) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
        this.dialect = dialect;
        this.ddl = ddl;
        this.sql = sql;
        this.primary = primary;
    }
}
