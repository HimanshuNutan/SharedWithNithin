public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
    }
    public static String reverse(String str){
        char temp =' ';
        for(int i=0;i<=(str.length()/2)-1;i++){
            str = str.substring(0,i)
                    +str.charAt(str.length()-1-i)
                    +str.substring(i+1,str.length()-1-i)
                    +str.charAt(i)
                    +str.substring(str.length()-i,str.length());
        }
        return str;
    }
}
