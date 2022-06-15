import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class Java16_StringInFileNio {
    public static void main(String[] args) throws IOException {
        String filepath = "C:\\Users\\himan\\Desktop\\Nithing project.txt";
        String searchValue = "database";
        //Method 1
        String s = new String(Files.readAllBytes(Paths.get(filepath)));
        if(s.contains(searchValue)){
            System.out.println("String found");
        }else{
            System.out.println("String not found");
        }

        //Method 2
        List<String> list = Collections.emptyList();
        list = Files.readAllLines(Paths.get(filepath));

        Optional<String> opt = list.stream().filter(i->i.contains(searchValue)).findFirst();
        if(opt.isPresent()){
            System.out.println("String found");
        }else{
            System.out.println("String not found");
        }

        //Method 3
        boolean flag = list.stream().anyMatch(searchValue::contains);
        System.out.println(flag);
    }
}
