package part2324;

/**
 *
 * @author Reyes
 */
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

class PhoneBook implements Serializable {

    private HashMap<Person, BookEntry> phonebook = new HashMap<>();
    private HashMap<PhoneNumber, BookEntry> pbbypn = new HashMap<>();
    private static final long serialVersionUID = 1001L;

    public void addEntry(BookEntry entry) {
        phonebook.put(entry.getPerson(), entry);
        pbbypn.put(entry.getNumber(), entry);
    }

    public BookEntry getEntry(Person key) {
        return phonebook.get(key);
    }

    public BookEntry getEntry(PhoneNumber key) {

        for (PhoneNumber n : pbbypn.keySet()) {
            if (n.compareTo(key) == 0) {
                return pbbypn.get(n);
            }
        }
        return null;
    }

    public LinkedList<BookEntry> getEntry(String key) {
        LinkedList<BookEntry> entries = new LinkedList<>();
        for (Person person : phonebook.keySet()) {
            if (person.getSurname().equals(key)) {
                entries.add(phonebook.get(person));
            }
        }
        return entries;
    }

    public PhoneNumber getNumber(Person key) {
        BookEntry entry = getEntry(key);
        if (entry != null) {
            return entry.getNumber();
        } else {
            return null;
        }
    }

    public Person getNumber(PhoneNumber key) {
        BookEntry entry = getEntry(key);
        if (entry != null) {
            return entry.getPerson();
        } else {
            return null;
        }
    }

    public void listEntries() {
        LinkedList<BookEntry> entries = new LinkedList<>(phonebook.values());
        Collections.sort(entries);
        for (BookEntry entry : entries) {
            System.out.println(entry);
        }
    }
}
