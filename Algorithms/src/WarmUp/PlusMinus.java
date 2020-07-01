package WarmUp;

public class PlusMinus {

    static void plusMinus(int[] arr) {
        int positive = 0, negitive = 0, zero = 0;
        for (int value : arr) {
            if(value == 0){
                zero++;
                continue;
            }
            if(value > 0) positive++;
            if(value < 0) negitive++;
        }

        System.out.println((float) positive / arr.length); //A decimal representing of the fraction of positive numbers in the array compared to its size.
        System.out.println((float) negitive / arr.length); //A decimal representing of the fraction of negative numbers in the array compared to its size.
        System.out.println((float) zero / arr.length); //A decimal representing of the fraction of zeros in the array compared to its size.
    }

    public static void main(String[] args) {
        int[] a = {12, -12, 0, 0, 32, -1, 0, 23 };
        plusMinus(a);
    }
}
