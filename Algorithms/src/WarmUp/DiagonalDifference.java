package WarmUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int[] sum1 = new int[arr.size()];
        int[] sum2 = new int[arr.size()];
        for(int x = 0; x < ((ArrayList) arr).size(); x++){
            sum2[x] = arr.get(x).get(x);
            sum1[x] = arr.get(x).get((arr.size() - 1) - x);
        }

        int result1 = 0;
        for (int x : sum1) result1 += x;

        int result2 = 0;
        for (int x : sum2) result2 += x;
        if(result1 > result2) return result1 - result2;
        else return result2 - result1;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        String numbers = "6 6 7 -10 9 -3 8 9 -1 9 7 -10 6 4 1 6 1 1 -1 -2 4 -6 1 -4 -6 3 9 -8 7 6 -1 -6 -6 6 -7 2 -10 -4 9 1 -7 8 -5 3 -5 -8 -3 -4 2 -3 7 -5 1 -5 -2 -7 -4 8 3 -1 8 2 3 -3 4 6 -7 -7 -8 -3 9 -6 -2 0 5 4 4 4 -3 3 0";
        String[] arr = numbers.split(" ");
        byte columnsRows = 9;
        for (int x = 0; x < columnsRows; x++){
            System.out.println("Creating row " + (x + 1));
            List<Integer> temp = new ArrayList<>();
            for(int y = 9; y <= 9 && y > 0; y--){
                if(y == 9) System.out.println("-- Start Number: " + arr[(x + 1) * columnsRows - y]);
                if(y == 1) System.out.println("-- End Number: " + arr[(x + 1) * columnsRows - y]);
                temp.add(Integer.parseInt(arr[(x + 1) * columnsRows - y]));
            }
            matrix.add(temp);
        }
        System.out.println("Running Test!");
        System.out.println(diagonalDifference(matrix));
    }
}
