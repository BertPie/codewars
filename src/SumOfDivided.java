import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumOfDivided {
    public static void main(String[] args) {
        int[] intArray = {100000, 1000000};
//        System.out.println(Arrays.toString(intArray) + " - " + maxInList(makeListOfIntegers(intArray)));
//        System.out.println(Arrays.toString(intArray) + " - " + primesToCheck(maxInList(makeListOfIntegers(intArray))));
        System.out.println(sumOfDivided(intArray));
        // todo: why 5653 is not a prime?
    }

    public static String sumOfDivided(int[] l) {
        List lObj = makeListOfIntegers(l);
        StringBuilder sb = new StringBuilder();
        int maxNumber = maxInList(lObj);
        int sumOfDivided;
        ArrayList<Integer> primes = primesToCheck(maxNumber);
        for (int prime : primes) {
            boolean foundOne = false;
            sumOfDivided = 0;
            for (int amIDivided : l) {
                if (amIDivided % prime == 0) {
                    sumOfDivided += amIDivided;
                    foundOne = true;
                }
            }
            if (foundOne) {
                sb.append("(").append(prime).append(" ").append(sumOfDivided).append(")");
            }
        }
        return sb.toString();
    }

    public static List<Integer> makeListOfIntegers(int[] intArray) {
        List<Integer> intList = new ArrayList<>();
        for (int integer : intArray) {
            intList.add(integer);
        }
        return intList;
    }

    public static ArrayList<Integer> primesToCheck(int maxNumber) {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 2; i <= maxNumber; i++) {
            int addMe = i;
            for (int prime : primes) {
                if (prime > Math.sqrt(maxNumber)) {
                    break;
                }
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

    public static int maxInList(List<Integer> intList) {
        int max = Math.abs(Collections.max(intList));
        int min = Math.abs(Collections.min(intList));
        return (max > min) ? max : min;
    }

}
/**
 * Given an array of positive or negative integers
 * <p>
 * I= [i1,..,in]
 * <p>
 * you have to produce a sorted array P of the form
 * <p>
 * [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij] ...]
 * <p>
 * P will be sorted by increasing order of the prime numbers. The final result has to be given as a string in
 * Java, C#, C, C++ and as an array of arrays in other languages.
 * <p>
 * Example:
 * <p>
 * I = {12, 15}; // result = "(2 12)(3 27)(5 15)"
 * [2, 3, 5] is the list of all prime factors of the elements of I, hence the result.
 * <p>
 * Notes:
 * <p>
 * It can happen that a sum is 0 if some numbers are negative!
 * Example: I = [15, 30, -45] 5 divides 15, 30 and (-45) so 5 appears in the result, the sum of the numbers
 * for which 5 is a factor is 0 so we have [5, 0] in the result amongst others.
 * <p>
 * In Fortran - as in any other language - the returned string is not permitted to contain any redundant
 * trailing whitespace: you can use dynamically allocated character strings.
 */