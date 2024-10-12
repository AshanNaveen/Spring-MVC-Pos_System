package lk.ijse.sprinpos.config;

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Naveen Theekshana
 * @date 10/11/2024
 * @project SpringPos
 */

@Configuration
@ComponentScan("lk.ijse.sprinpos")
@EnableJpaRepositories
@EnableTransactionManagement
public class WebAppRootConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dbms = new DriverManagerDataSource();
        dbms.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbms.setUrl("jdbc:mysql://localhost:3306/springpos?createDatabaseIfNotExist=true");
        dbms.setUsername("Ashan");
        dbms.setPassword("Ashan@12345");
        return dbms;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("lk.ijse.sprinpos.entity");
        factory.setDataSource(dataSource());

        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
