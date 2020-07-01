public class Operators {

    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        System.out.println(Math.round(meal_cost + ((meal_cost / 100) * (tip_percent + tax_percent))));
    }

    public static void main(String[] args) {
        solve(12.00,
                20,
                8);
    }
}
