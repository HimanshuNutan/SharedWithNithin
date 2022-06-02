import java.util.*;

public class Java19_SortHashMapbyValue {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("Sachin",150);
        map.put("Dhoni",140);
        map.put("Sehwag",130);
        map.put("Kohli",100);
        LinkedHashMap<String,Integer> orderedmap = new LinkedHashMap<>();
        //Method 1
        map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }).forEach(e->{
            orderedmap.put(e.getKey(),e.getValue());
//            System.out.println(e.getKey()+"  "+e.getValue());
        });
        orderedmap.entrySet().stream().forEach(System.out::println);
        //Method 2
        Comparator<Map.Entry<String,Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        map.entrySet().stream().sorted(comparator).forEach(System.out::println);

    }
}
