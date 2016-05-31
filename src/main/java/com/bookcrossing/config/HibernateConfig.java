package com.bookcrossing.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:properties/database.properties")
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
//    @Profile("dev")
    public DataSource dataSource(
            @Value("jdbc:mysql://localhost:3306/bookcrossing3") String url,
            @Value("root") String username,
            @Value("admin") String password
    ) throws SQLException {
        DriverManagerDataSource source = new DriverManagerDataSource(
                url, username, password
        );
        source.setDriverClassName("com.mysql.jdbc.Driver");
        return source;
    }

//    @Bean
//    @Profile("production")
//    public DataSource dataSourceHeroku(
//            @Value("jdbc:mysql://ivgz2rnl5rh7sphb.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/vw9i9thqd6ahzzl7") String url,
//            @Value("a1cz5y3jut8ha1hs") String username,
//            @Value("kie1l00fuojkesi8") String password
//    ) throws SQLException {
//        DriverManagerDataSource source = new DriverManagerDataSource(
//                url, username, password
//        );
//        source.setDriverClassName("com.mysql.jdbc.Driver");
//        return source;
//    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.bookcrossing.dataLayer.entity");
        sessionFactory.setHibernateProperties(this.hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                setProperty("hibernate.show_sql", "true");
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.connection.useUnicode", "true");
                setProperty("hibernate.connection.characterEncoding", "utf8mb4");
                setProperty("hibernate.connection.charSet", "utf8mb4");
            }
        };
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
