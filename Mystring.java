import java.util.*;
class Mystring{
    public static void append(String str1,String str2){
    System.out.println("After append :\n "+str1+str2);
    }
    public static void countWords(String str2){
        int cnt=0;
        for(char c:str2.toCharArray()){
            if(c==' '){
                cnt++;
            }
        }
        System.out.println("Total number of words are:"+(cnt+1));
    }
    public static void replace(String str, char oldChar, char newChar) {
    String result = "";

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == oldChar) {
            result += newChar;   // replace manually
        } else {
            result += c;         // keep original
        }
    }

    System.out.println("String after Replace: " + result);
}

    public static void isPalindrome(String str){
         int i=0;
         int j=str.length()-1;
         while(i<j){
         if(str.charAt(i) != str.charAt(j)){
            System.out.println("It is not palindrome");
            return;
         }
         else{
            i++;
            j--;
         }
        }
         System.out.println("It is a palindrome");
    }
    public static void splice(String str, int start, int length) {
    // remove substring from 'start' to 'start + length'
    String result = str.substring(0, start) + str.substring(start + length);
    System.out.println("After splice: " + result);
}
    public static void split(String str) {
    int spaces = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ') spaces++;
    }

    String[] words = new String[spaces + 1];
    String word = "";
    int index = 0;

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c != ' ') {
            word += c;
        } else {
            words[index++] = word;
            word = "";
        }
    }
    words[index] = word; // last word

    System.out.println(Arrays.toString(words));
}
    public static void maxrepeat(String str) {
    int[] freq = new int[256]; // for ASCII characters

    // count frequency of each character
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        freq[c]++;
    }

    int max = -1;
    char result = ' ';

    // find the character with maximum frequency
    for (int i = 0; i < str.length(); i++) {
        if (max < freq[str.charAt(i)]) {
            max = freq[str.charAt(i)];
            result = str.charAt(i);
        }
    }

    System.out.println("Character with maximum frequency: " + result);
    System.out.println("Frequency: " + max);
}
public static void Sort(String str){
    
    char[] arr = str.toCharArray();  // convert string to char array

    // Bubble Sort on characters
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
public static void Shift(String str,int n){
    n = n % str.length();  // handle if n > length

    // move first n chars to end
    String shifted = str.substring(str.length() - n) + str.substring(0, str.length() - n);

    System.out.println("Shifted string: " + shifted);
}
public static void Reverse(String str){
    String word="";
    for(int i=str.length()-1;i>=0;i--){
        word+=str.charAt(i);
    }
    System.out.println("Reversed String is :"+word);
}


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string :");
        String str=sc.nextLine();
        System.out.println("Choose a operation :");
        System.out.println("1. Append ");
        System.out.println("2. Count Words ");
        System.out.println("3. Replace ");
        System.out.println("4. isPalindrome ");
        System.out.println("5. Splice ");
        System.out.println("6. Split ");
        System.out.println("7. maxrepeat ");
        System.out.println("8. Sort ");
        System.out.println("9. Shift ");
        System.out.println("10. Reverse ");
        System.out.println("11. Exit ");
        System.out.println("Enter the operation you want to choose from 1 to 11:");
        int choice=sc.nextInt();
        sc.nextLine();
        switch(choice){
        case 1:
        System.out.println("Enter a string to append:");
        String str1=sc.nextLine();
        append(str,str1);
            break;
        
        case 2:
        System.out.println("Enter String to count total number of words:");
        String str2=sc.nextLine();
        countWords(str2);
            break;
        
        case 3:
        System.out.println("Enter character you want to replace:");
        char a = sc.next().charAt(0);
        System.out.println("Enter new character:");
        char b = sc.next().charAt(0);
        replace(str,a,b);
            break;
        
        case 4:
        isPalindrome(str);
            break;
        
        case 5:
        splice(str,0,2);
            break;
        
        case 6:
        System.out.println("Enter string you want to split ");
        String s=sc.nextLine();
        split(s);
            break;
        
        case 7:
        maxrepeat(str);
            break;
        
        case 8:
        Sort(str);
            break;
        
        case 9:
        System.out.println("Enter shift count:");
        int n = sc.nextInt();
        Shift(str,n);
            break;
        
        case 10:
        Reverse(str);
            break;
        
        case 11:
            break;
        
    }
    }
};