import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckListForOdd {
    public static void main(String[] args) {
        boolean flag = false;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3,4,6,8,10));
        for(int i=0;i<list.size();i++){
            if(isOdd(list.get(i))){
                flag = true;
                break;
            }
        }
        if(flag)
            System.out.println("Contains odd number");
        else
            System.out.println("Doesn't contain odd number");
    }
    public static boolean isOdd(int num){
        if(num%2==1)
            return true;
        else return false;
    }
}
