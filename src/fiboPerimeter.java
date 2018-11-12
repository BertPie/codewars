import java.math.BigInteger;

public class fiboPerimeter {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("1");
        System.out.println(n + ": " + perimeter(n));
        n = new BigInteger("3");
        System.out.println(n + ": " + perimeter(n));
        n = new BigInteger("5");
        System.out.println(n + ": " + perimeter(n));
        n = new BigInteger("7");
        System.out.println(n + ": " + perimeter(n));
        n = new BigInteger("30");
        System.out.println(n + ": " + perimeter(n));
    }

    public static BigInteger perimeter(BigInteger n) {
        n = n.add(new BigInteger("1"));
        BigInteger fibo0 = new BigInteger("0");
        BigInteger fibo1 = new BigInteger("1");
        BigInteger sumOfFibo = new BigInteger("1");

        for (BigInteger i = new BigInteger("1"); i.compareTo(n) < 0; i = i.add(new BigInteger("1"))){
            BigInteger temp = fibo0;
            fibo0 = fibo1;
            fibo1 = fibo0.add(temp);
            sumOfFibo = sumOfFibo.add(fibo1);
        }
        return sumOfFibo.multiply(new BigInteger("4"));
    }

//  FOR INT
//    public static void main(String[] args) {
//        int n = 1;
//        System.out.println(n + ": " + perimeter(n));
//        n = 5;
//        System.out.println(n + ": " + perimeter(n));
//        n = 7;
//        System.out.println(n + ": " + perimeter(n));
//        n = 10;
//        System.out.println(n + ": " + perimeter(n));
//    }
//
//    public static int perimeter(int n) {
//        n++;
//        int fibo0 = 0;
//        int fibo1 = 1;
//        int sumOfFibo = 1;
//        for(int i = 1; i < n; i++){
//            int temp = fibo0;
//            fibo0 = fibo1;
//            fibo1 = temp + fibo0;
//            sumOfFibo += fibo1;
//        }return sumOfFibo * 4;
//    }
}
/**
 * The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8. It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80
 * <p>
 * Could you give the sum of the perimeters of all the squares in a rectangle when there are n + 1 squares disposed in the same manner as in the drawing:
 * <p>
 * alternative text
 * <p>
 * #Hint: See Fibonacci sequence
 * <p>
 * #Ref: http://oeis.org/A000045
 * <p>
 * The function perimeter has for parameter n where n + 1 is the number of squares (they are numbered from 0 to n) and returns the total perimeter of all the squares.
 * <p>
 * perimeter(5)  should return 80
 * perimeter(7)  should return 216
 */