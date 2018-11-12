import java.util.ArrayList;
import java.util.Arrays;

public class SumOfDivided {
    public static void main(String[] args) {
        int[] intArray = {12, 14, -15};
        System.out.println(Arrays.toString(intArray) + " - " + maxInArray(intArray));
    }

    // todo: find an Array of primes to check
    // todo: make a loop checking if the numbers are divided by a given prime
    // todo: add used primes to a list
    // todo: add those numbers to a String (prime sum)

//    public static ArrayList<Integer> primesToCheck(int maxNumber){
//        ArrayList<>
//        for (int i = 2; i <= maxNumber/2; i++) {
//
//        }
//        return primes;
//    }


    public static int maxInArray(int[] intArray) {
        int[] tempArray = arrayToAbsoluteValues(intArray);
        int max = tempArray[0];
        for (int number : tempArray) {
            if(number>max){
                max = number;
            }
        }
        return max;
    }

    public static int[] arrayToAbsoluteValues(int[] intArray) {
        int[] tempArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            tempArray[i] = absolute(intArray[i]);
        }
        return tempArray;
    }

    public static int absolute(int number) {
        return number < 0 ? -number : number;
    }


}
