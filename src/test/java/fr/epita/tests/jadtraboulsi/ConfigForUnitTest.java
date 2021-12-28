package fr.epita.tests.jadtraboulsi;

import java.sql.Driver;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.epita.services.data.ContactDAO;

//import fr.epita.contacts.services.data.ContactDAO;

@Configuration
@ComponentScan(basePackages = { "fr.epita.services.data" })
public class ConfigForUnitTest {

    @Bean("services.data.contactDAO")
    public ContactDAO getContactDAO(){
    return new ContactDAO();
    }

    @Bean("services.data.mainDS")
    public DataSource getMainDS() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Driver.class.getName());
        driverManagerDataSource.setUrl("jdbc:postgresql:exam");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("jad");
        
        return driverManagerDataSource;

    }

}