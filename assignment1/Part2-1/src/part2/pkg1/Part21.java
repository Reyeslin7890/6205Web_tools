package part2.pkg1;

import java.util.Vector;
import java.util.Scanner;

/**
 *
 * @author Reyes
 */
public class Part21 {

    public static boolean calculate(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vector<Integer> primes = new Vector<>(100, 50);
        Integer num = -1;
        try {
            while (num != 0) {
                System.out.println(" Caluclate prime number, enter 1;\n View entered prime numbers, enter 2;\n Exit, enter 0\n ");
                num = in.nextInt();
                switch (num) {
                    case 2: {
                        for (int number : primes) {
                            System.out.print(number + " ");
                        }
                        System.out.println("");
                        break;
                    }
                    case 1: {
                        num = in.nextInt();
                        if (calculate(num)) {
                            primes.add(num);
                            System.out.println(num + " is a prime number!\n");
                        } else {
                            System.out.println(num + " is NOT a prime number!\n");
                        }
                        break;
                    }
                    case 0:
                        System.out.println("Goodbye!");
                        break;

                }
            }

        } catch (Exception e) {
        }

    }

}
