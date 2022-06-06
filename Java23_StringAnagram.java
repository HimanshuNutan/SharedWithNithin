import java.util.HashMap;

public class Java23_StringAnagram {
    public static void main(String[] args) {
        String s1 = "aabbccddeeefff";
        String s2 = "fefefedcdcbaab";

        if(s1.length()==s2.length()){

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),0);
        }
        for(int i=0;i<s2.length();i++){
            map2.put(s2.charAt(i),0);
        }

            for(int i=0;i<s1.length();i++){
                map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1);
            }
            for(int i=0;i<s2.length();i++){
                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
            }
        if(map1.equals(map2)){
            System.out.println("Anagrams");
        }else{
            System.out.println("Not Anagrams");
        }

    }else{
            System.out.println("Not Anagrams");
        }

    }
}
