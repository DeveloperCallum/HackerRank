package WarmUp;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int[] ar) {
        int max = 0, count = 0;
        for(int i : ar){
            if(i > max) max = i;
        }

        for (int i : ar){
            if(i == max) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 1, 3};
        System.out.println(birthdayCakeCandles(arr));
    }
}
