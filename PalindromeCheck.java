import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println("Enter string to check ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals(reverse(str)))
            System.out.println("Palindrome String");
        else
            System.out.println("Not a palindrome String");
    }
    public static String reverse(String s){
        String rev ="";
        for(int i=s.length()-1;i>=0;i--){
            rev = rev +s.charAt(i);
        }
        return rev;
    }
}
