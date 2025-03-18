public class Util {
    private Util() {
    }

    public static float max(float num1, float num2) {
        if (num1 >= num2) {
            return num1;
        }
        return num2;
    }

    public static float min(float num1, float num2) {
        if (num1 <= num2) {
            return num1;
        }
        return num2;
    }
}
