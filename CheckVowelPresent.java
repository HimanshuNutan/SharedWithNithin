import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckVowelPresent {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        if(str.matches(".*[aeiou].*")){
//            System.out.println("Contains a vowel");
//        }else{
//            System.out.println("Doesn't contain any vowel");
//        }
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        boolean flag = false;
        for(int i=0;i<str.length();i++){
            if(vowels.contains(str.charAt(i))){flag = true; break;}
        }
        if(flag){
            System.out.println("Contains vowel");
        }else{
            System.out.println("Doesn't contain vowel");
        }
    }
}
