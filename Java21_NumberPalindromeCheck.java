public class Java21_NumberPalindromeCheck {
    public static void main(String[] args) {
        int n = 12321;
        if(n==reverse(n)){
            System.out.println("Palindrome Number");
        }else{
            System.out.println("Not a Palindrome Number");
        }
    }
    public static int reverse(int n){
        int rev=0;

        while(n>0){
            rev = (n%10)+rev*10;
            n=n/10;
        }
//        System.out.println("Reverse is "+rev);
        return rev;
    }
}
