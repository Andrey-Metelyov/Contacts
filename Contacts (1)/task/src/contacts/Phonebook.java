package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Phonebook implements Serializable {
    List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public int count() {
        return contacts == null ? 0 : contacts.size();
    }

    public void edit(int index) {
        Contact contact = contacts.get(index);
        System.out.println("Select a field (" + contact.listFields().toString());

    }

    public void add(Contact contact) {
//        System.out.println("add " + contact.toString());
        contacts.add(contact);
    }

    public void remove(int index) {
        contacts.remove(index);
    }

    public void deserialize(String filename) {
        System.out.println("open " + filename);
    }

    public Contact get(int index) {
        return contacts.get(index);
    }

    public List<Contact> search(String query) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.contains(query)) {
                result.add(contact);
            }
        }
        return result;
    }
}
