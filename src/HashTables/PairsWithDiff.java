package HashTables;

import java.util.*;

public class PairsWithDiff {
    public static void main(String[] args){
        int[] numbers = {1, 7, 5, 9, 2, 12, 3};
        int difference = 2;
        Set<Integer> numSet = new HashSet<>();
        Set<int[]> unique = new HashSet<>();
        for(var nbr : numbers)
            numSet.add(nbr);
        for(var nbr : numbers){
            var target = nbr -  difference;
            if(numSet.contains(target))
                unique.add(new int[]{nbr, target});
        }
        System.out.println(unique.size());

    }
}
