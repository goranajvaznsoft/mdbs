package com.simplemultidbsource.mdbs.application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbConfigDto {

    private Integer id;

    private String name;

    private String url;

    private String username;

    private String password;

    private String driver;

    private String dialect;

    private String ddl;

    private Short sql;

    private Boolean primary;

    public DbConfigDto() {
    }

    public DbConfigDto(Integer id, String name, String url, String username, String password, String driver, String dialect, String ddl, Short sql, Boolean primary) {
        this.id = id;
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
