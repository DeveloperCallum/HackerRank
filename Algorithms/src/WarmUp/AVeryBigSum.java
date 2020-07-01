package WarmUp;

public class AVeryBigSum {
    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long result = 0;
        for (long i : ar){
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        long[] ar = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        System.out.println(aVeryBigSum(ar));
    }
}
