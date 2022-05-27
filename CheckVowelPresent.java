import java.util.Scanner;

public class CheckVowelPresent {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.matches(".*[aeiou].*")){
            System.out.println("Contains a vowel");
        }else{
            System.out.println("Doesn't contain any vowel");
        }
    }
}
