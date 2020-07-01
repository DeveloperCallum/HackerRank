import java.util.Scanner;

public class DataTypes {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);
        int intInput = scan.nextInt();
        double doubleInput = scan.nextDouble();
        while (scan.hasNextLine()) {
            s += scan.nextLine();
            if(s.length() <= 11) continue;
            System.out.println(i + intInput);
            System.out.println(d + doubleInput);
            System.out.println(s);
        }

        scan.close();
    }

//    public static void main(String[] args) {
//        int i = 0;
//        double d = 0;
//
//        Scanner scanner = new Scanner(System.in);
//        i = scanner.nextInt();
//        d = scanner.nextDouble();
//        while (scanner.hasNextLine()) {
//            String value = scanner.nextLine();
//            if(value.length() <= 0) continue;
//            System.out.println(i + (int) d);
//            System.out.println(d + d);
//            System.out.println("HackerRank " + value);
//            scanner.close();
//        }
//    }
}
