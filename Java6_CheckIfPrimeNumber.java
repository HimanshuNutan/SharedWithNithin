import java.util.Scanner;

public class Java6_CheckIfPrimeNumber {
    public static void main(String[] args) {

        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean flag = true;
        for(int i=2;i<=squareRoot(n);i++){
            if(n%i==0){
                flag = false;
                break;
            }
        }
        if(flag == true){
            System.out.println("Prime Number");
        }else{
            System.out.println("Not a prime number");
        }
    }
    public static double squareRoot(int num){
        double t;
        double sqrtroot = num/2;
        do {
            t = sqrtroot;
            sqrtroot=(t+(num/t))/2;
        }while(t-sqrtroot!=0);
        return sqrtroot;
    }
}
