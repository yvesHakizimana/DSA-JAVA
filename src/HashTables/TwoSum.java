package HashTables;

import java.util.*;

public class TwoSum {
    public static void main(String[] args){
//        int[] numArray = {2, 7, 11, 15};
//        int targetNum = 18;
//        Map<Integer, Integer> nums = new HashMap<>();
//        for(int i = 0; i < numArray.length; i++){
//            nums.put(numArray[i], i);
//        }
//        Set<int[]> unique =  new HashSet<>();
//
//        for(int i = 0; i < numArray.length; i++){
//            int target = targetNum - numArray[i];
//            if(nums.containsKey(target) && nums.get(target) != i){
//                unique.add(new int[]{i, nums.get(target)});
//            }
//        }
//        for(var el : unique){
//            for( int i : el)
//                System.out.println(i);
//        }
        int[] numArray = {2, 7, 4, 3 ,11, 15, 3};
        int targetNum = 6;
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i = 0; i < numArray.length; i++) {
            int complement = targetNum - numArray[i];
            if (nums.containsKey(complement)) {
                System.out.println("Indices: " + nums.get(complement) + ", " + i);
                return; // Found a solution, exit the program
            }
            nums.put(numArray[i], i);
        }

        System.out.println("No solution found.");
    }
}
