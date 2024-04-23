package Arrays;

public class Main {
    public static void main(String[] args){
        Array numbers  = new Array(5);
        numbers.insert(10);
        numbers.insert(3);
        numbers.insert(4);
        numbers.insert(5);
        numbers.insert(6);
        numbers.insert(7);
        numbers.insert(11);
        numbers.insert(12);
        numbers.insert(2);
        numbers.insert(1);
        System.out.println(numbers);
        numbers.insertAt(9, 1);
        System.out.println(numbers);
    }

}
