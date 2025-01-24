package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
    * Main program: The entry point of the program. The local time will be printed first,
    * Then it will create two binary variables, add them and print the result.
    *
    * @param args: not used
    */
    public static void main( String[] args )
    {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Binary binary1 = new Binary("00010001000");
        System.out.println("First binary number is " + binary1.getValue());

        Binary binary2 = new Binary("111000");
        System.out.println("Second binary number is " + binary2.getValue());

        Binary sum = Binary.add(binary1, binary2);
        System.out.println("Their summation is " + sum.getValue());

        // New functionality to accept user input and perform operations
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nEnter another first binary number: ");
        String bin1 = scanner.nextLine();
        Binary newBinary1 = new Binary(bin1);

        System.out.println("Enter another second binary number: ");
        String bin2 = scanner.nextLine();
        Binary newBinary2 = new Binary(bin2);

        Binary newSum = Binary.add(newBinary1, newBinary2);
        System.out.println("New summation is: " + newSum.getValue());

        Binary orResult = Binary.or(newBinary1, newBinary2);
        System.out.println("OR result is: " + orResult.getValue());

        Binary andResult = Binary.and(newBinary1, newBinary2);
        System.out.println("AND result is: " + andResult.getValue());

        Binary multiplyResult = Binary.multiply(newBinary1, newBinary2);
        System.out.println("Multiplication result is: " + multiplyResult.getValue());

        scanner.close();
    }
}
