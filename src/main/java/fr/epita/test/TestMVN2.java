package fr.epita.test;

import java.io.IOException;
import java.util.List;

import fr.epita.data.Contact;
import fr.epita.reader.CSVReader;

public class TestMVN2 {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader();
        List<Contact> contacts = reader.getContacts();
        reader.sortContacts(contacts);
        System.out.println(contacts);
    }
}
