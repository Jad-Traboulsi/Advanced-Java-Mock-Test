package fr.epita.services.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import fr.epita.data.Contact;

@Repository("services.data.contactDAO")
public class ContactDAO {
    @Inject
    @Named("services.data.mainDS")
    private DataSource ds;
    
    public void create(Contact c) {
        try (Connection connection = ds.getConnection();) {
            String s = "INSERT INTO \"contacts\" (first_name,last_name,company_name,address,city,country,state,zip,phone1,phone,email) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.setString(1, c.getName());
            ps.setString(2, c.getLast_name());
            ps.setString(3, c.getCompany_name());
            ps.setString(4, c.getAddress());
            ps.setString(5, c.getCity());
            ps.setString(6, c.getCounty());
            ps.setString(7, c.getState());
            ps.setInt(8, c.getZip());
            ps.setString(9, c.getPhone1());
            ps.setString(10, c.getPhone());
            ps.setString(11, c.getEmail());

            ps.execute();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    
    public ResultSet search(int zip) {
        ResultSet rs = null;
        try (Connection connection = ds.getConnection();) {
            String s = "select * from \"contacts\" where zip = ?";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.setInt(1, zip);
            rs =  ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        
        return rs;
    }
}
