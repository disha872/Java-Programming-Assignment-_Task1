/**
 * @Filename - Main.java
 * @Description - Definition of functions
 * @Author - Disha Toshniwal
 */
public class MyOperation {

    // 1. Count Unique Palindromes (Length >= 3)
    public int countUniquePalindromes(String inputString) {
        if (inputString == null || !inputString.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input! Please enter a valid alphabetic string.");
            return 0;
        }

        int palindromeCount = 0;
        for (int startIndex = 0; startIndex < inputString.length(); startIndex++) {
            for (int endIndex = startIndex + 1; endIndex < inputString.length(); endIndex++){
                if (isPalindrome(inputString, startIndex, endIndex)) {
                    palindromeCount++;
                }
            }
        }
        return palindromeCount;
    }

    private boolean isPalindrome(String text, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (text.charAt(startIndex) != text.charAt(endIndex)) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }

    // 2. Nth Fibonacci (Recursive)
    public int nthFibonacci(int number) {
        if (number < 0) {
            System.out.println("Invalid input! Please enter a non-negative integer.");
            return -1;
        }
        if (number <= 1) return number;
        return nthFibonacci(number - 1) + nthFibonacci(number - 2);
    }

    // 3. Snake to Camel Case
    public String snakeToCamel(String snakeString) {
        if (snakeString == null || !snakeString.matches("[a-z_]+")) {
            System.out.println("Invalid input! Please enter a valid lowercase snake_case string.");
            return "";
        }

        StringBuilder camelCaseResult = new StringBuilder();
        boolean convertNext = false;

        for (int index = 0; index < snakeString.length(); index++) {
            char currentChar = snakeString.charAt(index);
            if (currentChar == '_') {
                convertNext = true;
            } else {
                if (convertNext && Character.isLowerCase(currentChar)) {
                    camelCaseResult.append(Character.toUpperCase(currentChar));
                } else {
                    camelCaseResult.append(currentChar);
                }
                convertNext = false;
            }
        }
        return camelCaseResult.toString();
    }

    // 4. Count Consonants
    public int countConsonants(String inputText) {
        if (inputText == null || !inputText.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input! Please enter a valid alphabetic string.");
            return 0;
        }

        int consonantCount = 0;
        for (int index = 0; index < inputText.length(); index++) {
            char ch = Character.toLowerCase(inputText.charAt(index));
            if (ch >= 'a' && ch <= 'z' && "aeiou".indexOf(ch) == -1) {
                consonantCount++;
            }
        }
        return consonantCount;
    }

    // 5. Binary to Decimal
    public int binaryToDecimal(String binaryString) {
        if (binaryString == null || !binaryString.matches("[01]+")) {
            System.out.println("Invalid input! Please enter a valid binary string (only 0s and 1s).");
            return -1;
        }

        int decimalValue = 0;
        int base = 1;
        for (int index = binaryString.length() - 1; index >= 0; index--) {
            if (binaryString.charAt(index) == '1') {
                decimalValue += base;
            }
            base *= 2;
        }
        return decimalValue;
    }

    // 6. Display Characters (e.g., "a1b3" → "abbb")
    public void displayCharacters(String inputString) {
    if (inputString == null || !inputString.matches("([a-zA-Z][0-9]+)+")) {
        System.out.println("Invalid input! Please enter a valid pattern like 'a1b2c3'.");
        return;
    }

    StringBuilder expandedString = new StringBuilder();
    int index = 0;

    while (index < inputString.length()) {
        char currentChar = inputString.charAt(index);

        // Ensure currentChar is a letter
        if (Character.isLetter(currentChar)) {
            index++;
            StringBuilder numStr = new StringBuilder();

            // Collect all following digits (for multi-digit numbers)
            while (index < inputString.length() && Character.isDigit(inputString.charAt(index))) {
                numStr.append(inputString.charAt(index));
                index++;
            }

            // Convert collected number string to integer
            int repeatCount = Integer.parseInt(numStr.toString());

            // Repeat the character
            expandedString.append(String.valueOf(currentChar).repeat(repeatCount));
        } else {
            index++; // skip any invalid character just in case
        }
    }

    System.out.println("Expanded String: " + expandedString);
}


    // 7. Character Frequency Compression (e.g., "aaabb" → "a3b2")
    public String charFrequencyCompressed(String inputString) {
        if (inputString == null || !inputString.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input! Please enter a valid alphabetic string.");
            return "";
        }

        StringBuilder compressedString = new StringBuilder();
        int index = 0;

        while (index < inputString.length()) {
            char currentChar = inputString.charAt(index);
            int count = 1;
            int nextIndex = index + 1;
            while (nextIndex < inputString.length() && inputString.charAt(nextIndex) == currentChar) {
                count++;
                nextIndex++;
            }
            compressedString.append(currentChar).append(count);
            index = nextIndex;
        }

        return compressedString.toString();
    }

    // 8. Check Prime Number
    public boolean isPrime(int number) {
        if (number <= 1) {
            System.out.println("Invalid input! Please enter a number greater than 1.");
            return false;
        }
        for (int divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    // 9. Number to Words (0–9999)
    public String numberToWords(int number) {
        if (number < 0 || number > 9999) {
            System.out.println("Invalid input! Please enter a number between 0 and 9999.");
            return "";
        }

        if (number == 0) return "zero";

        String[] ones = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
        };
        String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        StringBuilder words = new StringBuilder();

        if (number / 1000 > 0) {
            words.append(ones[number / 1000]).append(" thousand ");
            number %= 1000;
        }
        if (number / 100 > 0) {
            words.append(ones[number / 100]).append(" hundred ");
            number %= 100;
        }
        if (number > 0) {
            if (number < 20) {
                words.append(ones[number]);
            } else {
                words.append(tens[number / 10]);
                if (number % 10 > 0) {
                    words.append(" ").append(ones[number % 10]);
                }
            }
        }
        return words.toString().trim();
    }

    // 10. Longest Substring Without Repeating Characters
    public int longestSubstringWithoutRepeat(String inputString) {
        if (inputString == null || !inputString.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input! Please enter a valid alphabetic string.");
            return 0;
        }

        int maxLength = 0;
        for (int start = 0; start < inputString.length(); start++) {
            boolean[] seenCharacters = new boolean[256];
            int currentLength = 0;

            for (int end = start; end < inputString.length(); end++) {
                char currentChar = inputString.charAt(end);
                if (seenCharacters[currentChar]) break;
                seenCharacters[currentChar] = true;
                currentLength++;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
