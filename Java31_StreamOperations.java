import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java31_StreamOperations {
    static int count =0,greatest=Integer.MIN_VALUE,smallest=Integer.MAX_VALUE;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i=100;i>0;i--){
            list.add(i);
        }
        System.out.println("Size of list - "+listSize(list));
        System.out.println("Max value - "+findMax(list));
        System.out.println("Smallest Value - "+findMin(list));
        String a = "HHiimaanshumhhh";
        System.out.println("First non repeating character in string "+a+" is "+findFirstNonRepeatingChar(a));
        System.out.println("Count of characters for string"+a+" is ");
        printCountOfChars(a);
        System.out.println("First repeating character in string "+a+" is "+findFirstRepeatingChar(a));
        System.out.println("List before sorting "+list.toString());
        System.out.println("List after sorting"+sortList(list).toString());
    }

    private static int listSize(List<Integer> list) {
         list.stream().forEach(i->{count++;});
         return count;
    }
    private static int findMax(List<Integer> list){
        list.stream().forEach(i->{
            if(i>greatest)
                greatest=i;
        });
        return greatest;
    }
    private static int findMin(List<Integer> list){
        list.stream().forEach(i->{
            if(i<smallest)
                smallest=i;
        });
        return smallest;
    }
    private static Character findFirstNonRepeatingChar(String str){

       Character c = str.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new,Collectors.counting()))
                .entrySet().stream().filter(i->i.getValue()==1).findFirst().get().getKey();
return c;

    }
    private static void printCountOfChars(String str){
        str.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
                .collect(Collectors.groupingBy(Function.identity(),HashMap::new,Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }
    private static Character findFirstRepeatingChar(String str){
       return str.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(i->i.getValue()>1).findFirst().get().getKey();
    }
    private static List<Integer> sortList(List<Integer> list){
        return list.stream().sorted().collect(Collectors.toList());
    }
}
