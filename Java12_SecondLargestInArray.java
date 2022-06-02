public class Java12_SecondLargestInArray {
    public static void main(String[] args) {
        int ar[] = {10,84,1,8,56,33,82};
        int g = -9998,sg = -9999;
        for(int i=0;i<ar.length;i++){
            if(ar[i]>g){
                sg=g;
                g=ar[i];
            }
            else if(ar[i]<=g&&ar[i]>sg){
                sg=ar[i];
            }
        }
        System.out.println("Second Greatest element - "+sg);
    }
}
