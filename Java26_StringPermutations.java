import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Java26_StringPermutations {
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        String s ="abc";

        permutation("",s);
        set.stream().sorted().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                    return 1;
                else return -1;

            }
        }).forEach(System.out::println);


    }

    private static void permutation(String perm, String word) {

        if(word.isEmpty()){
            String setString = perm+word;
            set.add(setString);
        }else{
            for(int i=0;i<word.length();i++){
                if(!(word.charAt(i)+"").equals(""))
                set.add(word.charAt(i)+"");
                if(!(word.substring(0,i)+word.substring(i+1,word.length())).equals(""))
                set.add(word.substring(0,i)+word.substring(i+1,word.length()));
                permutation(perm+word.charAt(i),word.substring(0,i)+word.substring(i+1,word.length()));
            }
        }
    }

}
