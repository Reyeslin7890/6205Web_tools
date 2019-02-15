/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2324;

import java.io.Serializable;

/**
 *
 * @author Reyes
 */
class BookEntry implements Comparable<BookEntry>, Serializable {

    private Person person;
    private PhoneNumber number;
    private static final long serialVersionUID = 1001L;

    public BookEntry(Person person, PhoneNumber number) {
        this.person = person;
        this.number = number;
    }

    @Override
    public int compareTo(BookEntry entry) {
        int result = person.compareTo(entry.getPerson());
        return result == 0 ? number.compareTo(entry.getNumber()) : 1;
    }

    public Person getPerson() {
        return person;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return person.toString() + ' ' + number.toString();
    }
    // Read an entry from the keyboard

    public static BookEntry readEntry() {
        return new BookEntry(Person.readPerson(), PhoneNumber.readNumber());
    }

}
