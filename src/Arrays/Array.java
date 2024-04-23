package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Array {
    private int count;
    private int[] numbers;
    private int length;
    public Array(int size){
        count = 0;
        numbers = new int[size];
        length = size;
    }

    public void insert(int number){
        if(count == length ){
            resize(number);
        }
        else
            numbers[count++] = number;
    }

    private void resize(int number) {
        length *= 2;
        int[] newArray = new int[length];
        for(int i = 0; i < count; i++)
            newArray[i] = numbers[i];
        numbers = newArray;
        numbers[count++] = number;
    }

    public void removeAt(int index){
        if(index < 0 || index >= count)
           throw  new IllegalArgumentException("Invalid Index");
        for(int i = index; i < count - 1; i++)
            numbers[i] = numbers[i+1];
        count--;
    }

    public int max(){
        int max = numbers[0];
        for(int i : numbers)
            if(i > max)
                max = i;
        return max;
    }

    public ArrayList<Integer> intersect(int[] arr){
        ArrayList<Integer> commonNumbers = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < count ; i++){
            set.add(numbers[i]);
        }
        for(int j = 0; j < arr.length; j++){
            if(set.contains(arr[j]) && !commonNumbers.contains(arr[j])){
                commonNumbers.add(arr[j]);
            }
        }
        return commonNumbers;
    }

    public void reverse(){
        int start = 0;
        int end = count - 1;
        while(start < end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }


    public void insertAt(int item, int index){
        // case1: Validating Index
        if(index < 0 || index > count){
            throw new IllegalArgumentException("Invalid index");
        }

        //case2: if The array is full
        if(count == numbers.length){
            resize(item);
        }

        // case3: if the number to be added is still in the index / boundaries of count
        for(int i = count; i > index; i--){
            numbers[i] = numbers[i - 1];
        }

        numbers[index] = item;
        count++;
    }

    @Override
    public String toString() {
        return "Array{" +
                "count=" + count +
                ", numbers=" + Arrays.toString(numbers) +
                ", length=" + length +
                '}';
    }
}
