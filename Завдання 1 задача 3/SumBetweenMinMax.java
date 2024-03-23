import java.util.Arrays;

public class SumBetweenMinMax {
    public static void main(String[] args) {
        double[] array = {-3.5, 2.0, 1.8, -4.2, 3.9, -1.6};
        double sum = sumPositiveBetweenMinMax(array);
        Arrays.sort(array);
        System.out.println("Sum between min and max (absolute values): " + sum);
        System.out.println("Sorted array in descending order: " + Arrays.toString(array));
    }

    public static double sumPositiveBetweenMinMax(double[] arr) {
        double minAbs = Double.MAX_VALUE, maxAbs = Double.MIN_VALUE;
        int minIdx = -1, maxIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            double absValue = Math.abs(arr[i]);
            if (absValue < minAbs) {
                minAbs = absValue;
                minIdx = i;
            }
            if (absValue > maxAbs) {
                maxAbs = absValue;
                maxIdx = i;
            }
        }

        int startIdx = Math.min(minIdx, maxIdx) + 1;
        int endIdx = Math.max(minIdx, maxIdx) - 1;
        double sum = 0.0;

        for (int i = startIdx; i <= endIdx; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }

        return sum;
    }
}
