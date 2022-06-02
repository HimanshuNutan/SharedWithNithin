import java.util.Scanner;

public class Java3_RemoveWhiteSpaces {
    public static void main(String[] args) {
        String str = "This       is a     test    string.";

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                int j=i;
                String prefix = str.substring(0,i);
                while(str.charAt(j)==' '){j++;}
                str = prefix+str.substring(j,str.length());
            }
        }
        System.out.println(str);

    }
}
