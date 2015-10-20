package org.kbss.webdb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Serhii Kryvtsov
 */
@Configuration
@ComponentScan(basePackages = {"org.kbss.webdb"}, scopeResolver = org.springframework.context.annotation.Jsr330ScopeMetadataResolver.class)
@EnableJpaRepositories(basePackages = "org.kbss.webdb", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class StorageConfiguration {
    @Inject
    private Environment env;

    @Bean
    public PlatformTransactionManager transactionManager() throws NamingException {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPersistenceUnitName("webdbPU");
        factoryBean.setPackagesToScan("org.kbss.webdb");
        factoryBean.setJpaProperties(additionalProperties());
        return factoryBean;
    }

    private final Properties additionalProperties() {
        return new Properties() {
            {
                setProperty("hibernate.connection.driver_class", env.getProperty("web.db.jdbc.driver", "org.h2.Driver"));
                setProperty("hibernate.dialect", env.getProperty("web.db.jdbc.dialect", "org.hibernate.dialect.H2Dialect"));
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("web.db.jdbc.hbm2ddl.auto", "update"));
                setProperty("hibernate.show_sql", env.getProperty("web.db.jdbc.show_sql", "true"));
                setProperty("hibernate.connection.SetBigStringTryClob", "true");
                setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
                setProperty("jadira.usertype.autoRegisterUserTypes", "true");
                setProperty("javax.persistence.validation.mode", env.getProperty("web.db.jdbc.javax.persistence.validation.mode", "NONE"));
                setProperty("jadira.usertype.databaseZone", env.getProperty("web.db.jadira.usertype.databaseZone", "jvm"));
                setProperty("jadira.usertype.javaZone", env.getProperty("web.db.jadira.usertype.javaZone", "jvm"));
            }
        };
    }

    private DataSource dataSource() throws NamingException {
        String jndi = env.getProperty("web.db.jndi");
        if (jndi != null) {
            JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
            factoryBean.setJndiName(env.getProperty("web.db.jndi"));
            factoryBean.setResourceRef(env.getProperty("web.db.ref", Boolean.class, true));
            factoryBean.afterPropertiesSet();
            return (DataSource) factoryBean.getObject();
        }
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUrl("jdbc:h2:~/db-manager.h2");
        return dataSource;
    }
}
