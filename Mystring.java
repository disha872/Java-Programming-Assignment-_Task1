/**
 * @Filename-Mystring.java
 * @Desciption-Definition of all string functions
 * @Author-Disha Toshniwal
 */
import java.util.*;

public class Mystring {   // class name should match file name (Mystring.java)

    public void append(String str1, String str2) {
        System.out.println("After append :\n " + str1 + str2);
    }

    public void countWords(String str2) {
        int cnt = 0;
        for (char c : str2.toCharArray()) {
            if (c == ' ') {
                cnt++;
            }
        }
        System.out.println("Total number of words are: " + (cnt + 1));
    }

    public void replace(String str, char oldChar, char newChar) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == oldChar) {
                result += newChar;
            } else {
                result += c;
            }
        }
        System.out.println("String after Replace: " + result);
    }

    public void isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                System.out.println("It is not palindrome");
                return;
            } else {
                i++;
                j--;
            }
        }
        System.out.println("It is a palindrome");
    }

    public void splice(String str, int start, int length) {
        String result = str.substring(0, start) + str.substring(start + length);
        System.out.println("After splice: " + result);
    }

    
public void split(String str, String pattern) {
    ArrayList<String> words = new ArrayList<>();
    String temp = "";

    for (int i = 0; i < str.length(); ) {
        // if the pattern matches starting at position i
        if (i + pattern.length() <= str.length() &&
            str.substring(i, i + pattern.length()).equals(pattern)) {
            words.add(temp);
            temp = "";
            i += pattern.length(); // skip the pattern
        } else {
            temp += str.charAt(i);
            i++;
        }
    }

    // add the last word
    if (!temp.isEmpty()) {
        words.add(temp);
    }

    // print the result
    System.out.println("Result after splitting:");
    for (String word : words) {
        System.out.print(word + "\t");
    }
}



    public void maxrepeat(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq[c]++;
        }

        int max = -1;
        char result = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (max < freq[str.charAt(i)]) {
                max = freq[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        System.out.println("Character with maximum frequency: " + result);
        System.out.println("Frequency: " + max);
    }

    public void Sort(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        String sortedStr = new String(arr);
        System.out.println("Sorted string: " + sortedStr);
    }

    public void Shift(String str, int n) {
        n = n % str.length();
        String shifted = str.substring(str.length() - n) + str.substring(0, str.length() - n);
        System.out.println("Shifted string: " + shifted);
    }

    public void Reverse(String str) {
        String word = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            word += str.charAt(i);
        }
        System.out.println("Reversed String is: " + word);
    }
}
