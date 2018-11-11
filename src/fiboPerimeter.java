import java.math.BigInteger;

public class fiboPerimeter {

    public static BigInteger perimeter(BigInteger n) {


        BigInteger sumOfFibo = new BigInteger("1");
        BigInteger perimeter = new BigInteger("4");
        perimeter.multiply(sumOfFibo);

        return perimeter;
    }

}
