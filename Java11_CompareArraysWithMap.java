import java.util.Collections;
import java.util.HashMap;

public class Java11_CompareArraysWithMap {
    public static void main(String[] args) {
        int ar[] = {2,3,5,7,9};
        int ar1[] = {3,7,9,2,4};

        if(ar.length!=ar1.length){
            System.out.println("Not Same");
        }else {
            HashMap<Integer,Integer> map1 = new HashMap<Integer, Integer>();
            HashMap<Integer,Integer> map2 = new HashMap<Integer, Integer>();

            for(int i=0;i<ar.length;i++){
                map1.put(ar[i],0);
            }
            for(int i=0;i<ar1.length;i++){
                map2.put(ar1[i],0);
            }

            for(int i=0;i<ar.length;i++){
                map1.put(ar[i],map1.get(ar[i])+1);
            }
            for(int i=0;i<ar1.length;i++){
                map2.put(ar1[i],map2.get(ar1[i])+1);
            }

            if(map1.equals(map2)){
                System.out.println("Same");
            }else{
                System.out.println("Not same");
            }
        }
    }
}
