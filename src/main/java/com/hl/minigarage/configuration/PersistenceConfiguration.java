package com.hl.minigarage.configuration;

import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addAnnotatedClasses(Idea.class);
        sessionBuilder.addAnnotatedClasses(Challenge.class);

        return sessionBuilder.buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}