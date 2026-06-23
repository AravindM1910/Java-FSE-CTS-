public class Main {

    public static double futureValue(double p, double r, int n) {
        if (n <= 0)
            return p;

        return futureValue(p * (1 + r), r, n - 1);
    }

    public static void main(String[] args) {
        double p = 1000;
        double r = 0.055;
        int n = 20;

        double ans = futureValue(p, r, n);

        System.out.println("Future Value after " + n + " years = " + ans);
    }
}