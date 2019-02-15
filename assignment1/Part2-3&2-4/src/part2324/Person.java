package part2324;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Reyes
 */
public class Person implements Comparable<Person>, Serializable {

    private String firstName;
    private String surname;
    private static final long serialVersionUID = 1001L;

    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public static Person readPerson() {
        String firstName = null;
        String surname = null;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first name: ");
        firstName = in.nextLine().trim();
        System.out.print("Enter surname: ");
        surname = in.nextLine().trim();
        return new Person(firstName, surname);
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Person person) {
        int result = surname.compareTo(person.surname);
        return result == 0 ? firstName.compareTo(person.firstName) : result;
    }

    @Override
    public boolean equals(Object person) {
        return compareTo((Person) person) == 0;
    }

    @Override
    public int hashCode() {
        return 7 * firstName.hashCode() + 13 * surname.hashCode();
    }

    @Override
    public String toString() {
        return firstName + " " + surname;
    }
}
