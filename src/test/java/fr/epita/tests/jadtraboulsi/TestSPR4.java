package fr.epita.tests.jadtraboulsi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSPR4 {

    @Inject
    @Named("mainDS")
    DataSource ds;
    
    @Test
    public void testDatasource() throws SQLException {
        // given - a proper spring configuration

        // when - injection occurs when junit starts the test

        // then
        Assert.assertNotNull(ds);
        Connection connection = ds.getConnection();

        String schema = connection.getSchema();
        Assert.assertEquals("PUBLIC", schema);
        connection.close();

    }

    @Test
    public void createTable(){
        try {
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE CONTACTS");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
