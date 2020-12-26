import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddNumbers {

    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> numbers = new ArrayList<>();

        for(int x = l; x <= r; x++){
            if(x % 2 == 1) numbers.add(x);
        }

        return numbers;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(oddNumbers(2, 5).toArray()));
    }
}
