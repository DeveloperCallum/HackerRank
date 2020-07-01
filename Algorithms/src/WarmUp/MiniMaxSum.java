package WarmUp;

import java.util.Arrays;

public class MiniMaxSum {
    static void miniMaxSum(int[] arr) {

        //Bubble Sort
        Boolean wasActionTaken;
        do {
            wasActionTaken = false;
            for (int x = 0; x < arr.length; x++) {
                if (x - 1 < 0) continue;
                if (arr[x - 1] > arr[x]) {
                    int max = arr[x - 1];
                    int min = arr[x];

                    arr[x] = max;
                    arr[x - 1] = min;
                    wasActionTaken = true;
                }
            }
        } while (wasActionTaken);
        //Bubble Sort End

        //TODO: chop off last (toRemove) items for min and revise for max

        long min = 0;
        long max = 0;
        for (int x = 0; x < arr.length; x++){
            if(x < 4) min += arr[x];
            if(x >= arr.length - 4) max += arr[x];
        }

        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        int[] arr = {793810624, 895642170, 685903712, 623789054, 468592370};
        miniMaxSum(arr);
    }
}
