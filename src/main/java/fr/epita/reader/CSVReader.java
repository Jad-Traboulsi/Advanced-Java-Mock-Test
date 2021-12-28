package fr.epita.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.epita.data.Contact;

public class CSVReader {

    public List<Contact> getContacts() throws IOException {
        List<String> listOfLines = Files.readAllLines(new File("src/main/resources/17-contacts.csv").toPath());
        List<Contact> contacts = new ArrayList<Contact>();
        listOfLines.remove(0);

        for (String line : listOfLines) {

            String[] l = line.split(",");
            try {
                contacts.add(new Contact(l[0], l[1], l[2], l[3], l[4], l[5], l[6], Integer.parseInt(l[7]), l[8], l[9],
                        l[10]));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                for (String r:l)
                    System.out.println(r);
            }

        }

        return contacts;

    }

    public void sortContacts(List<Contact> c) {

        //c.sort((c1,c2)-> c1.getState().compareTo(c2.getState()));
        c.sort(Comparator.comparing(Contact::getState));

    }

}
