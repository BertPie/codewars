public class CountZeros {
    public static void main(String[] args) {
        int test = 0;
        System.out.println("test: " + test + " - " + zeros(test));
        test = 6;
        System.out.println("test: " + test + " - " + zeros(test));
        test = 14;
        System.out.println("test: " + test + " - " + zeros(test));
        test = 438;
        System.out.println("test: " + test + " - " + zeros(test));
        test = 100000;
        System.out.println("test: " + test + " - " + zeros(test));
    }

//    How many zeros depends on how many times the number was divided by 2 and 5, together they make 10.
//    It is unnecessary to check how many times it is divided by 2, because it's always more than 5!

    public static int zeros(int n) {
        if(n<5){
            return 0;
        }
        int countDivisionsByFive = 0;
        for (int i = 5; i <= n; i++) {
            int temp = i;
            boolean notDivisibleBy5 = false;
            while (!notDivisibleBy5) {
                if (temp % 5 == 0) {
                    countDivisionsByFive++;
                    temp /= 5;
                }
                else {
                    notDivisibleBy5 = true;
                }
            }
        }
        return countDivisionsByFive;
    }

/**
 * Write a program that will calculate the number of trailing zeros in a factorial of a given number.
 *
 * N! = 1 * 2 * 3 * ... * N
 *
 * Be careful 1000! has 2568 digits...
 *
 * For more info, see: http://mathworld.wolfram.com/Factorial.html
 *
 * Examples
 * zeros(6) = 1
 * # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
 *
 * zeros(12) = 2
 * # 12! = 479001600 --> 2 trailing zeros
 * Hint: You're not meant to calculate the factorial. Find another way to find the number of zeros.
 */
}
