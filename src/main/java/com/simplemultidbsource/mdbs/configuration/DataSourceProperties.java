package com.simplemultidbsource.mdbs.configuration;

import com.simplemultidbsource.mdbs.repository.test_common.DbConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * DataSourceProperties stores the properties for a particular datasource.
 * In a normal, non-dynamic bean program these properties could come from
 *
 * @ConfigurationProperties but this won't where we want to support a dynamic
 * prefix.
 * <p>
 * The properties are
 * <p>
 * prefix1.datasource.driver=
 * prefix1.datasource.url=
 * prefix1.datasource.username=
 * prefix1.datasource.password=
 * <p>
 * prefix2.datasource.driver=
 * prefix2.datasource.url=
 * prefix2.datasource.username=
 * prefix2.datasource.password=
 * <p>
 * .
 * .
 * .
 * prefixn.datasource.driver=
 * prefixn.datasource.url=
 * prefixn.datasource.username=
 * prefixn.datasource.password=
 * <p>
 * Each instance of this class stores the properties for a prefix.
 */
public class DataSourceProperties {

    private String driver;
    private String url;
    private String username;
    private String password;
    private String prefix;
    private Boolean primary = false;

    private ConfigurableEnvironment environment;

    private static String propertyBase = "datasource";
    private final DbConfigRepository dbConfigRepository;

    @Autowired
    public DataSourceProperties(ConfigurableEnvironment environment,
                                String prefix,
                                DbConfigRepository dbConfigRepository) {
        this.prefix = prefix;
        this.environment = environment;
        this.dbConfigRepository = dbConfigRepository;
        driver = getProperty("driver");
        url = getProperty("url");
        username = getProperty("username");
        password = getProperty("password");
        primary = getProperty("primary", Boolean.class);

    }

    public static boolean isUrlProperty(String property) {
        return property.endsWith(propertyBase + ".url");
    }


    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPrefix() {
        return prefix;
    }

    public ConfigurableEnvironment getEnvironment() {
        return environment;
    }

    public static String getPropertyBase() {
        return propertyBase;
    }

    public Boolean getPrimary() {
        return primary;
    }

    private String getProperty(String property) {
        return getProperty(property, String.class);
    }

    private <T> T getProperty(String property, Class<T> type) {

        T value = environment.getProperty(prefix + "." + propertyBase + "." + property, type);
        if (value == null) {
            throw new IllegalStateException(prefix + "." + propertyBase + "." + property + " is not found");
        }
        return value;
    }
}
