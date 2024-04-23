package HashTables;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        String word = "a green apple";
        var chars = word.toCharArray();
        for(var ch : chars)
        {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put( ch , count + 1);
        }

        for(var item : map.entrySet())
            if(item.getValue() == 1){
                System.out.println("The First Non Repeated char is here : " + item.getKey());
                break;
            }
    }
}
