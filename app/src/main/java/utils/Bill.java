package utils;

public class Bill {
    public static float totalAmount = 0;

    public static void addToTotal(float amount) {
        totalAmount += amount;
    }
}
