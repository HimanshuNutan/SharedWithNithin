import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Java22_ArrayRemoveDuplicates {
    public static void main(String[] args) {
        int ar[] = {1,2,1,2,3,8,7,9,2,3,4,5,6,6,6,7,8,8,9};
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<ar.length;i++){
           if(!set.contains(ar[i])){
               set.add(ar[i]);
           }
        }
        int j=0;
        for(int i:set){
            ar[j]=i;j++;
        }

        Integer[] ar1=set.toArray(new Integer[j]);
        System.out.println(Arrays.toString(ar1));
    }
}
