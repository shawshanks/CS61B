
/**
 *  Tests Body and pairwise 
 */

public class TestBody {
    /**
     *  Tests Body.
     */

    public static void main(String[] args) {
        checkTestBody();
    }

    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            System.out.println("Fail: " + label + "Expected " + expected + 
                " and you gave " + actual);}
        else if (Math.abs(expected - actual) <= eps *Math.max(expected, actual)) {
            System.out.println("Pass "+ label
                + ": Expected " + expected + " and you gave " + actual);
        }
        else {
            System.out.println("Fail: " + label + "Expected " + expected +
                " and you gave " + actual);
        }
    }   

    private static void checkTestBody() {
        System.out.println("Checking TestBody...");

        Body b1 = new Body(1.0, 1.0, 1.0, 1.0, 1.0, "jupiter.gif");
        Body b2 = new Body(2.0, 2.0, 2.0, 2.0, 2.0, "jupiter.gif");


        checkEquals(b1.calcForceExertedBy(b2), 6.67e-11, "calcForceExertedBy()", 0.01);

    }
}