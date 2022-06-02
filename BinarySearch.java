public class BinarySearch {
    public static void main(String[] args) {
        int ar[] = {3,4,5,6,7,8,9};
        int mid = ar.length/2,left = 0,right = ar.length-1;
        int e = 5;
        while(left<=right){
            mid = (left+right)/2;
            if(ar[mid]>e){
                right = mid-1;
            }else if(ar[mid]<e){
                left = mid+1;
            }else{
                System.out.println("Element found at "+mid);break;
            }
        }
    }
}
