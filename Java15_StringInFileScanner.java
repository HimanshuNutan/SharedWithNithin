import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Java15_StringInFileScanner {
    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "C:\\Users\\himan\\Desktop\\Nithing project.txt";
        File file = new File(filepath);
        String searchValue = "database";

        Scanner scanner = new Scanner(file);
        String s ="";
        while(scanner.hasNextLine()){
            s = scanner.nextLine();
            if(s.contains(searchValue)){
                System.out.println("String found");
                s=searchValue;
                break;
            }
        }
        if(!s.equals(searchValue)){
            System.out.println("String not found");
        }

    }
}
