import java.util.ArrayList;
import java.util.List;
//Given a list of integers, find out all the numbers starting with 1 using Stream functions?
public class Java30_StreamExample1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10000;i++){
            list.add(i);
        }
        list.stream().filter(i->startsWithOne(i)).forEach(System.out::println);
    }

    private static boolean startsWithOne(Integer i) {
        String s = ""+i;
        if(s.startsWith("1"))
            return true;
        else
            return false;
    }
}
