/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2324;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Reyes
 */
public class Part2324 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook(); // The phone book
        Scanner in = new Scanner(System.in); // Keyboard input
        Person someone;
        PhoneNumber number;
        BookEntry entry;
        while (true) {
            System.out.println("Enter 1 to enter a new phone book entry\n"
                    + "Enter 2 to find the number for a name\n"
                    + "Enter 3 to list all the entries\n"
                    + "Enter 4 to find the name for a number\n"
                    + "Enter 5 to find the number for a surname\n"
                    + "Enter 9 to quit.");
            int what = 0; // Stores input selection
            try {
                what = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nTry again.");
                break;
            }
            switch (what) {
                case 1:
                    book.addEntry(BookEntry.readEntry());
                    break;
                case 2:
                    someone = Person.readPerson();
                    entry = book.getEntry(someone);
                    if (entry == null) {
                        System.out.println("The number for " + someone + " was not found.");
                    } else {
                        System.out.println("The number for " + someone + " is " + entry.getNumber());
                    }
                    break;
                case 3:
                    book.listEntries();
                    break;
                case 4:
                    number = PhoneNumber.readNumber();
                    entry = book.getEntry(number);
                    if (entry == null) {
                        System.out.println("The person for " + number + " was not found.");
                    } else {
                        System.out.println("The person for " + number + " is " + entry.getPerson());
                    }
                    break;
                case 5:
                    System.out.print("Enter surname: ");
                    String surnmae = in.nextLine().trim();
                    surnmae = in.nextLine().trim();
                    LinkedList<BookEntry> entries = book.getEntry(surnmae);
                    if (entries.size() == 0) {
                        System.out.println("The number for " + surnmae + " was not found.");
                    } else {
                        for (Iterator<BookEntry> it = entries.iterator(); it.hasNext();) {
                            entry = it.next();
                            System.out.println(entry);
                        }
                    }
                    break;
                case 9:
                    System.out.println("Ending program.");
                    return;
                default:
                    System.out.println("Invalid selection, try again.");
                    break;
            }
        }
    }
}
