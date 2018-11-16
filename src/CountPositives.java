import java.util.Arrays;

public class CountPositives {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countPositivesSumNegatives(null)));
    }

    public static int[] countPositivesSumNegatives(int[] input){
        if(input == null || input.length == 0){
            return new int[] {};
        }
        int positive = 0;
        int negative = 0;

        for (int number : input){
            if(number>0){
                positive++;
            }
            if(number<0){
                negative+=number;
            }
        }

        return new int[] {positive, negative};

    }
}

/**
 *Given an array of integers.
 *
 * Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers.
 *
 * If the input array is empty or null, return an empty array.
 *
 * Example
 * For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65].
 */