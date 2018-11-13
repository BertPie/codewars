import java.util.ArrayList;
import java.util.Arrays;

public class SumOfDivided {
    public static void main(String[] args) {
        int[] intArray = {1500, 30, -45};
        System.out.println(Arrays.toString(intArray) + " - " + maxInArray(intArray));
        System.out.println(Arrays.toString(intArray) + " - " + primesToCheck(maxInArray(intArray)));
        System.out.println(Arrays.toString(intArray) + " - " + sumOfDivided(intArray));
    }

    public static String sumOfDivided(int[] l) {
        StringBuilder sb = new StringBuilder();
        int maxNumber = maxInArray(l);
        int sumOfDivided;
        ArrayList<Integer> primes = primesToCheck(maxNumber);
        for(int prime: primes){
            boolean foundOne = false;
            sumOfDivided = 0;
            for(int amIDivided : l){
                if(amIDivided%prime == 0){
                    sumOfDivided+= amIDivided;
                    foundOne = true;
                }
            }
            if(foundOne){
                sb.append("(").append(prime).append(" ").append(sumOfDivided).append(")");
            }
        }
        return sb.toString();
    }

    public static ArrayList<Integer> primesToCheck(int maxNumber) {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= maxNumber; i++) {
            int addMe = i;
            for (int prime : primes) {
                if (i % prime == 0) {
                    addMe = 0;
                    break;
                }
            }
            if (addMe > 0) {
                primes.add(addMe);
            }

        }
        return primes;
    }

    public static int maxInArray(int[] intArray) {
        int[] tempArray = arrayToAbsoluteValues(intArray);
        int max = tempArray[0];
        for (int number : tempArray) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int[] arrayToAbsoluteValues(int[] intArray) {
        int[] tempArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            tempArray[i] = Math.abs(intArray[i]);
        }
        return tempArray;
    }
}
/**
 * Given an array of positive or negative integers
 *
 * I= [i1,..,in]
 *
 * you have to produce a sorted array P of the form
 *
 * [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij] ...]
 *
 * P will be sorted by increasing order of the prime numbers. The final result has to be given as a string in
 * Java, C#, C, C++ and as an array of arrays in other languages.
 *
 * Example:
 *
 * I = {12, 15}; // result = "(2 12)(3 27)(5 15)"
 * [2, 3, 5] is the list of all prime factors of the elements of I, hence the result.
 *
 * Notes:
 *
 * It can happen that a sum is 0 if some numbers are negative!
 * Example: I = [15, 30, -45] 5 divides 15, 30 and (-45) so 5 appears in the result, the sum of the numbers
 * for which 5 is a factor is 0 so we have [5, 0] in the result amongst others.
 *
 * In Fortran - as in any other language - the returned string is not permitted to contain any redundant
 * trailing whitespace: you can use dynamically allocated character strings.
 */