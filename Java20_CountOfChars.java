import java.util.HashMap;

public class Java20_CountOfChars {
    public static void main(String[] args) {
        CharacterCount("dumbledore");
    }
    public static void CharacterCount(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),0);
        }
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        map.entrySet().stream().forEach(System.out::println);
    }
}
