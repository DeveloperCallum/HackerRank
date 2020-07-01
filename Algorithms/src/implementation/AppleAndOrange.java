package implementation;

import java.util.HashMap;

public class AppleAndOrange {

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount = 0;
        for(int value : apples){
            int landedAt = value + a;
            if(landedAt >= s && landedAt <= t) appleCount++;
        }

        int orangeCount = 0;
        for(int value : oranges){
            int landedAt = value + b;
            if(landedAt >= s && landedAt <= t) orangeCount++;
        }

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    public static void main(String[] args) {
        int[] apples = {-2, 2, 1};
        int[] oranges = {5, -6};
        countApplesAndOranges(7, 11,5, 15, apples, oranges);
    }
}
