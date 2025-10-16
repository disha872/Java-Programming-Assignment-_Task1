/**

* @Filename- Main.java
* @Description- For taking user input and calling string functions
* @Author- Disha Toshniwal
  */
  import java.util.*;

public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Mystring myStringFunctions = new Mystring();

System.out.println("Enter a string : ");
String mainString = scanner.nextLine();
System.out.println("Choose an operation : ");
System.out.println("1. Append ");
System.out.println("2. Count Words ");
System.out.println("3. Replace ");
System.out.println("4. isPalindrome ");
System.out.println("5. Splice ");
System.out.println("6. Split ");
System.out.println("7. Max Repeat ");
System.out.println("8. Sort ");
System.out.println("9. Shift ");
System.out.println("10. Reverse ");
System.out.println("11. Exit ");

System.out.print("Enter your choice (1 – 11) : ");
int userChoice = scanner.nextInt();
scanner.nextLine(); // clear buffer

switch (userChoice) {
    case 1:
        System.out.println("Enter a string to append : ");
        String appendString = scanner.nextLine();
        myStringFunctions.append(mainString, appendString);
        break;

    case 2:
        System.out.println("Enter string to count total number of words : ");
        String wordCountString = scanner.nextLine();
        myStringFunctions.countWords(wordCountString);
        break;

    case 3:
        System.out.println("Enter character you want to replace : ");
        char oldCharacter = scanner.next().charAt(0);
        System.out.println("Enter new character : ");
        char newCharacter = scanner.next().charAt(0);
        myStringFunctions.replace(mainString, oldCharacter, newCharacter);
        break;

    case 4:
        myStringFunctions.isPalindrome(mainString);
        break;

    case 5:
        System.out.println("Enter starting index : ");
        int startIndex = scanner.nextInt();
        System.out.println("Enter length to remove : ");
        int removeLength = scanner.nextInt();
        myStringFunctions.splice(mainString, startIndex, removeLength);
        break;

    case 6:
        scanner.nextLine(); // clear buffer
        System.out.println("Enter pattern to split by : ");
        String splitPattern = scanner.nextLine();
        myStringFunctions.split(mainString, splitPattern);
        break;

    case 7:
        myStringFunctions.maxrepeat(mainString);
        break;

    case 8:
        myStringFunctions.sort(mainString);
        break;

    case 9:
        System.out.println("Enter shift count : ");
        int shiftCount = scanner.nextInt();
        myStringFunctions.shift(mainString, shiftCount);
        break;

    case 10:
        myStringFunctions.reverse(mainString);
        break;

    case 11:
        System.out.println("Exiting... ");
        break;

    default:
        System.out.println("Invalid choice! Please enter a number between 1 and 11. ");
}

scanner.close();
}


}
