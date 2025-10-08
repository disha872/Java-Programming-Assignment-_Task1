/**
 * @Filename- Main.java
 * @Desciption- For Taking user input and calling String functions
 * @Author-Disha Toshniwal
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mystring mystr = new Mystring();

        

        // Calling your methods through the object
       
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
        mystr.append(str,str1);
            break;
        
        case 2:
        System.out.println("Enter String to count total number of words:");
        String str2=sc.nextLine();
        mystr.countWords(str2);
            break;
        
        case 3:
        System.out.println("Enter character you want to replace:");
        char a = sc.next().charAt(0);
        System.out.println("Enter new character:");
        char b = sc.next().charAt(0);
        mystr.replace(str,a,b);
            break;
        
        case 4:
        mystr.isPalindrome(str);
            break;
        
        case 5:
        System.out.println("Enter starting index");
        int x=sc.nextInt();
        System.out.println("Enter length");
        int y=sc.nextInt();
        mystr.splice(str,x,y);
            break;

        case 6: 
        System.out.println("Enter pattern:");
        String pattern = sc.nextLine();
        mystr.split(str, pattern);
        break;
        
        case 7:
        mystr.maxrepeat(str);
            break;
        
        case 8:
        mystr.Sort(str);
            break;
        
        case 9:
        System.out.println("Enter shift count:");
        int n = sc.nextInt();
        mystr.Shift(str,n);
            break;
        
        case 10:
        mystr.Reverse(str);
            break;
        
        case 11:
            break;
        
    
}
    }
    };