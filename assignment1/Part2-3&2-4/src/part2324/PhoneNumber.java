package part2324;

/**
 *
 * @author Reyes
 */
import java.io.*;
import java.util.Scanner;

class PhoneNumber implements Comparable<PhoneNumber>, Serializable {

    private String areacode;
    private String number;
    private static final long serialVersionUID = 1001L;

    public PhoneNumber(String areacode, String number) {
        this.areacode = areacode;
        this.number = number;
    }

    public static PhoneNumber readNumber() {
        String area = null; // Stores the area code
        String localcode = null; // Stores the local code
        Scanner in = new Scanner(System.in);
        System.out.print("Enter area code: ");
        area = in.nextLine().trim();
        System.out.print("Enter local code: ");
        localcode = in.nextLine().trim();
        System.out.print("Enter the number: ");
        localcode += in.nextLine().trim();
        return new PhoneNumber(area, localcode);
    }
    
    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        int result = areacode.compareTo(phoneNumber.areacode);
        return result == 0 ? number.compareTo(phoneNumber.number) : result;
    }

    @Override
    public boolean equals(Object phoneNumber) {
        return compareTo((PhoneNumber) phoneNumber) == 0;
    }
    @Override
    public String toString() {
        return areacode + number;
    }

}
