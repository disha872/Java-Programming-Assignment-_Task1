/**
 * @Filename - Main.java
 * @Description - For taking user input and calling string functions
 * @Author - Disha Toshniwal
 */
import java.util.*;
public class MainOperation{
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyOperation operation = new MyOperation();
        while (true) {
            System.out.println("\n========= MENU =========\n1. Count Unique Palindromes\n2. Nth Fibonacci\n3. Snake to Camel Case\n4. Count Consonants\n5. Binary to Decimal\n6. Display Characters\n7. Character Frequency Compression\n8. Check Prime Number\n9. Number to Words\n10. Longest Substring Without Repeating Characters\n0. Exit");
            System.out.print("Enter your choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 0 and 10.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    System.out.println("Unique Palindromes Count: " + operation.countUniquePalindromes(scanner.nextLine()));
                    break;
                case 2:
                    System.out.print("Enter n: ");
                    try {
                        System.out.println("Fibonacci Number: " + operation.nthFibonacci(Integer.parseInt(scanner.nextLine())));
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter an integer.");
                    }
                    break;
                case 3:
                    System.out.print("Enter snake_case string: ");
                    System.out.println("CamelCase: " + operation.snakeToCamel(scanner.nextLine()));
                    break;
                case 4:
                    System.out.print("Enter a string: ");
                    System.out.println("Consonant Count: " + operation.countConsonants(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Enter binary string: ");
                    System.out.println("Decimal Value: " + operation.binaryToDecimal(scanner.nextLine()));
                    break;
                case 6:
                    System.out.print("Enter pattern (like a1b2): ");
                    operation.displayCharacters(scanner.nextLine());
                    break;
                case 7:
                    System.out.print("Enter a string: ");
                    System.out.println("Compressed String: " + operation.charFrequencyCompressed(scanner.nextLine()));
                    break;
                case 8:
                    System.out.print("Enter number: ");
                    try {
                        int num = Integer.parseInt(scanner.nextLine());
                        System.out.println(num + (operation.isPrime(num) ? " is Prime" : " is Not Prime"));
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                    }
                    break;
                case 9:
                    System.out.print("Enter a number (0-9999): ");
                    try {
                        System.out.println("In Words: " + operation.numberToWords(Integer.parseInt(scanner.nextLine())));
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a valid integer between 0 and 9999.");
                    }
                    break;
                case 10:
                    System.out.print("Enter a string: ");
                    System.out.println("Longest Unique Substring Length: " + operation.longestSubstringWithoutRepeat(scanner.nextLine()));
                    break;
                default:
                    System.out.println("Invalid choice! Please enter between 0–10.");
            }
        }

        scanner.close();
    }
}