import java.util.Arrays;
import java.util.Random;

public class Java13_ShuffleArray {
    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5,6,7};
        Random random = new Random();
        System.out.println("Before Shuffling the array is - ");
        System.out.println(Arrays.toString(ar));
        for(int i=0;i<ar.length;i++){
            int r = random.nextInt(6);

            int temp = ar[i];
            ar[i] = ar[r];
            ar[r] = temp;
        }
        System.out.println("After Shuffling");
        System.out.println(Arrays.toString(ar));

    }
}
