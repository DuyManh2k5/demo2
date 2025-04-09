package javaswing;

public class OperationDiv {
    public static double divide(double a, double b) {
        if (b == 0) return Double.NaN; // xử lý chia cho 0
        return a / b;
    }
}