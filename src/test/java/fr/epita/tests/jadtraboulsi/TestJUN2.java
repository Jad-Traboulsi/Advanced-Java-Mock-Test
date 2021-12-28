package fr.epita.tests.jadtraboulsi;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.epita.data.Contact;
import fr.epita.reader.CSVReader;



public class TestJUN2 {


    @BeforeClass
    public static void inBeforeClass() {
        System.out.println("I am inBeforeClass");
    }
    @Before
    public void inBefore() {
        System.out.println("I am inBefore");
    }


    @Test
    public void testing() throws IOException {
        // given
        CSVReader reader = new CSVReader();
        // when 
        List<Contact> contacts = reader.getContacts();

        Assert.assertNotNull(contacts);

        // then

        for(Contact c: contacts)
            System.out.println(c);

    }

    @After
    public void inAfter() {
        System.out.println("I am inAfter");
    }

    @AfterClass
    public static void inAfterClass() {
        System.out.println("I am inAfterClass");
    }
}
