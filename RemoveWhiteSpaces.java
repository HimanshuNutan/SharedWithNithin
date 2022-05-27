public class RemoveWhiteSpaces {
    public static void main(String[] args) {
        String str = "This is a test string.";

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str = str.substring(0,i)+str.substring(i+1,str.length());
            }
        }
        System.out.println(str);
    }
}
