package fr.epita.tests.jadtraboulsi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.data.Contact;
import fr.epita.services.data.ContactDAO;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigForUnitTest.class)
public class TestDAO1 {
    @Inject
    @Named("services.data.mainDS")
    private DataSource ds;

    @Inject
    @Named("services.data.contactDAO")
    private ContactDAO dao;
    
    @Before
    public void loadDatabase() throws IOException{
        String s = Files.readString(new File("src\\main\\resources\\data.sql").toPath());
        try (Connection connection = ds.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(s);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @Test
    // public void testCreate(){
    // Contact c = new Contact("Lenna","Paprocki","Feltz Printing Service","639 Main
    // St","Anchorage","Anchorage","AK",99501,"907-385-4412","907-921-2010","lpaprocki@hotmail.com");

    // dao.create(c);

    // try (Connection connection = ds.getConnection();) {
    // PreparedStatement preparedStatement = connection.prepareStatement("select
    // first_name, last_name from \"contacts\"");
    // ResultSet resultSet = preparedStatement.executeQuery();
    // resultSet.next();
    // String name = resultSet.getString("first_name");
    // String lastName = resultSet.getString("last_name");
    // Assert.assertEquals("Lenna", name);
    // Assert.assertEquals("Paprocki", lastName);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    @Test
    public void testSearch(){
    int zip = 99501;
    try{
    ResultSet rs = dao.search(zip);
    Assert.assertNotNull(rs);
    ResultSetMetaData metadata = rs.getMetaData();
   
    while (rs.next()) {
        for (int i = 1; i < metadata.getColumnCount() + 1; i++) {
            System.out.print(" " + metadata.getColumnName(i) + "=" + rs.getObject(i));
        }
        System.out.println("");
    }
    } catch (Exception e) {
    e.printStackTrace();
    }   
    }


}
