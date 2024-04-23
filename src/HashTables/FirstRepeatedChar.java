package HashTables;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {
    public static void main(String[] args) {
        String word = "green apple";
        var chars = word.toCharArray();
        Set<Character> set = new HashSet<>();
        for (var ch : chars)
            if (!set.add(ch)) {
                System.out.println(ch);
                return;
            };
    }
}
