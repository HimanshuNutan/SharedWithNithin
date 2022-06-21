import java.util.HashSet;

public class Java28_PalindromeSubstrings {
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        String word = "heollo";
        permutations("",word);
        if(set.contains(""))
            set.remove("");
        set.stream().filter(s->isPalindrome(s)).sorted().forEach(System.out::println);
    }

    private static boolean isPalindrome(String s) {
        int j=s.length()-1;
        boolean flag = true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(j)){
                flag = false;
                break;
            }
            j--;
        }
        return flag;
    }

    public static void permutations(String perm,String word){
        if(word.isEmpty()){
            set.add(perm+word);
        }
        for(int i=0;i<word.length();i++){
            set.add(perm+word.charAt(i));
            set.add(word.substring(0,i)+word.substring(i+1,word.length()));
            permutations(perm+word.charAt(i),word.substring(0,i)+word.substring(i+1,word.length()));
        }
    }
}
