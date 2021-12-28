package fr.epita.tests.jadtraboulsi;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.data.Contact;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSPR3 {
    @Inject
    @Named("contact")
    Contact cont;

    @Test
    public void createContact() {
        System.out.println(cont);
    }
}
