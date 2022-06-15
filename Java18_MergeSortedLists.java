import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Java18_MergeSortedLists {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,8,11,14);
        List<Integer> list1 = Arrays.asList(5,6,7,9,10,15);
        List<Integer> mergedList = new ArrayList<>();

        int j=0,k=0;
        for(int i=0;i<list.size()+list1.size();i++){

           if(k<list1.size()&&j<list.size()) {
               if (list.get(j) >= list1.get(k)) {
                   mergedList.add(list1.get(k));
                   k++;
               } else {
                   mergedList.add(list.get(j));
                   j++;
               }
           }
        }

        if(j<list.size()){
            for(int a=j;a<list.size();a++){
                mergedList.add(list.get(a));
            }
        }

        if(k<list1.size()){
            for(int a=j;a<list1.size();a++){
                mergedList.add(list1.get(a));
            }
        }
        System.out.println("Merged List - ");
        System.out.println(mergedList.toString());
    }
}
