import java.util.*;

public class Java31_FindDuplicatesUsingStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(40);
        list.stream().forEach(i->map.put(i,0));
        list.stream().forEach(i->map.put(i,map.get(i)+1));
        map.entrySet().stream().filter(i->i.getValue()>1).forEach(i->{System.out.println(i.getKey());});

    }
}
