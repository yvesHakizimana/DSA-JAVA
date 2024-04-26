package HashTables;

import java.util.*;

public class MostRepeatedNumber {
    public static void main(String[] args){
        int[] numbers = {1, 5, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};
        Map<Integer, Integer> numMap = new TreeMap<>();
        for(var number : numbers){
            var count = numMap.containsKey(number) ? numMap.get(number) : 0;
            numMap.put(number, count + 1);
        }
        var frequency = Collections.max(numMap.values());
        for(var entry: numMap.entrySet())
            if(Objects.equals(entry.getValue(), frequency)){
                System.out.println("The Most Repeated Number is  : " + entry.getKey());
                return;
            }
    }



}
