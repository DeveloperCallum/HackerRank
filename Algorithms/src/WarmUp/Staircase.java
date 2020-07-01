package WarmUp;

public class Staircase {
    static void staircase(int n) {
        for(int x = n; x <= n && x != 0; x--){
            String line = "";
            for(int y = 0; y < n; y++){
                if(x <= y + 1) line += "#";
                else line += " ";
            }
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        staircase(100);
    }
}
