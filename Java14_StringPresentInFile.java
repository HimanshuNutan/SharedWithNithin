import java.io.*;

public class Java14_StringPresentInFile {
    public static void main(String[] args) throws IOException {
        String filepath = "C:\\Users\\himan\\Desktop\\Nithing project.txt";
        String searchValue = "databasi";
        File file = new File(filepath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s="";
        while(bufferedReader.readLine()!=null){
             s = bufferedReader.readLine();
            if(s.contains(searchValue)){
                s = searchValue;
                System.out.println("String found");break;
            }
        }
        if(!s.equals(searchValue)){
            System.out.println("String not found");
        }
    }
}
