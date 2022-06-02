public class Java9_BinarySearchByRecursion {
    public static void main(String[] args) {
        int ar[] = {3,4,5,6,7,8,19};
        int e=15;
        int pos = search(ar,e,0,ar.length-1);
        if(pos != -1)
        System.out.println("Item found"+pos);
        else
            System.out.println("Not found");

    }
    public static int search(int ar[], int e,int l, int r){
        if(l>ar.length-1||r<0||r<l){
            return -1;
        }
        int mid = l+(r-l)/2;
        if(ar[mid]>e){
            return search(ar,e,l,mid-1);
        }else if(ar[mid]<e){
            return search(ar,e,mid+1,r);
        }else if(l>r){
            return -1;
        }
        else{
            return mid;
        }
    }
}
