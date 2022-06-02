import java.util.Arrays;

public class Java10_CompareArrays {
    public static void main(String[] args) {
        Integer ar[] = {2,3,5,7,9};
        Integer ar1[] = {3,7,9,2,5};

        if(ar.length!=ar1.length){
            System.out.println("Not equal");
        }else{
            Arrays.sort(ar);
            Arrays.sort(ar1);
            if(Arrays.equals(ar,ar1)){
                System.out.println("Same");
            }else{
                System.out.println("Not same");
            }
        }

    }

}
