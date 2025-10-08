/**

* @Filename-Mystring.java
* @Description-Definition of all string functions
* @Author-Disha Toshniwal
  */
import java.util.*;

public class Mystring {


public void append(String firstString, String secondString) {
    System.out.println("After append :\n " + firstString + secondString);
}

public void countWords(String inputString) {
    int wordCount = 0;
    for (char currentChar : inputString.toCharArray()) {
        if (currentChar == ' ') {
            wordCount++;
        }
    }
    System.out.println("Total number of words are: " + (wordCount + 1));
}

public void replace(String inputString, char oldCharacter, char newCharacter) {
    String replacedString = "";
    for (int index = 0; index < inputString.length(); index++) {
        char currentChar = inputString.charAt(index);
        if (currentChar == oldCharacter) {
            replacedString += newCharacter;
        } else {
            replacedString += currentChar;
        }
    }
    System.out.println("String after Replace: " + replacedString);
}

public void isPalindrome(String inputString) {
    int leftIndex = 0;
    int rightIndex = inputString.length() - 1;

    while (leftIndex < rightIndex) {
        if (inputString.charAt(leftIndex) != inputString.charAt(rightIndex)) {
            System.out.println("It is not palindrome");
            return;
        }
        leftIndex++;
        rightIndex--;
    }
    System.out.println("It is a palindrome");
}

public void splice(String inputString, int startIndex, int removeLength) {
    String splicedString = inputString.substring(0, startIndex) +
                           inputString.substring(startIndex + removeLength);
    System.out.println("After splice: " + splicedString);
}

public void split(String inputString, String delimiter) {
    ArrayList<String> splitParts = new ArrayList<>();
    String currentSegment = "";

    for (int index = 0; index < inputString.length();) {
        if (index + delimiter.length() <= inputString.length() &&
            inputString.substring(index, index + delimiter.length()).equals(delimiter)) {
            splitParts.add(currentSegment);
            currentSegment = "";
            index += delimiter.length();
        } else {
            currentSegment += inputString.charAt(index);
            index++;
        }
    }

    if (!currentSegment.isEmpty()) {
        splitParts.add(currentSegment);
    }

    System.out.println("Result after splitting:");
    for (String segment : splitParts) {
        System.out.print(segment + "\t");
    }
}

public void maxrepeat(String inputString) {
    int[] frequency = new int[256];
    for (int index = 0; index < inputString.length(); index++) {
        char currentChar = inputString.charAt(index);
        frequency[currentChar]++;
    }

    int maxFrequency = -1;
    char mostFrequentChar = ' ';

    for (int index = 0; index < inputString.length(); index++) {
        char currentChar = inputString.charAt(index);
        if (maxFrequency < frequency[currentChar]) {
            maxFrequency = frequency[currentChar];
            mostFrequentChar = currentChar;
        }
    }

    System.out.println("Character with maximum frequency: " + mostFrequentChar);
    System.out.println("Frequency: " + maxFrequency);
}

public void sort(String inputString) {
    char[] charArray = inputString.toCharArray();
    for (int i = 0; i < charArray.length - 1; i++) {
        for (int j = 0; j < charArray.length - i - 1; j++) {
            if (charArray[j] > charArray[j + 1]) {
                char tempChar = charArray[j];
                charArray[j] = charArray[j + 1];
                charArray[j + 1] = tempChar;
            }
        }
    }
    String sortedString = new String(charArray);
    System.out.println("Sorted string: " + sortedString);
}

public void shift(String inputString, int shiftCount) {
    shiftCount = shiftCount % inputString.length();
    String shiftedString = inputString.substring(inputString.length() - shiftCount) +
                           inputString.substring(0, inputString.length() - shiftCount);
    System.out.println("Shifted string: " + shiftedString);
}

public void reverse(String inputString) {
    String reversedString = "";
    for (int index = inputString.length() - 1; index >= 0; index--) {
        reversedString += inputString.charAt(index);
    }
    System.out.println("Reversed String is: " + reversedString);
}


}
