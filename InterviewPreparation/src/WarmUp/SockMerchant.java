package WarmUp;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> colours = new HashMap<>();
        for (int x : ar){
            if (colours.containsKey(x)) colours.replace(x, colours.get(x) + 1);
            else colours.put(x, 1);
        }
        AtomicInteger pairs = new AtomicInteger();
        colours.forEach((key, value) -> {
            if(value % 2 != 0){
                if((value - 1) > 0 && (value - 1) % 2 == 0){
                    pairs.addAndGet((value - 1) / 2);
                }
            }else pairs.addAndGet(value / 2);
        });
        return pairs.get();
    }

    public static void main(String[] args) {
        int[] x = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        sockMerchant(x.length, x);
    }
}
