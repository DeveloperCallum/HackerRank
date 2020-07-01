package WarmUp;

import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> points = new ArrayList<>();
        if(a.size() != b.size()) return null;

        for (int x = 0, alice = 0, bob = 0; x < a.size(); x++){
            if(a.get(x).equals(b.get(x)))continue;
            if (a.get(x) > b.get(x)) alice++;
            else bob++;

            if(x == a.size() - 1){
                points.add(alice);
                points.add(bob);
            }
        }

        return points;
    }

    public static void main(String[] args) {
        List<Integer> alice = new ArrayList<>();
        List<Integer> bob= alice;
        alice.add(1);
        alice.add(2);
        alice.add(3);
//        bob.add(3);
//        bob.add(6);
//        bob.add(10);
        System.out.println(compareTriplets(alice, bob));
    }
}
