import java.util.Arrays;

public class MinAbsNumber {
    public static void main(String[] args) {
        double[] array = {-3.5, 2.0, 1.8, -4.2, 3.9, -1.6};
        int minAbsIndex = findMinAbsIndex(array);
        double sumAfterNegatives = sumAfterNegative(array);
        compressArray(array, -2.0, 2.0);
        System.out.println("Index of min abs number: " + minAbsIndex);
        System.out.println("Sum of elements after first negative: " + sumAfterNegatives);
        System.out.println("Compressed array: " + Arrays.toString(array));
    }

    public static int findMinAbsIndex(double[] arr) {
        int minAbsIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) < Math.abs(arr[minAbsIdx])) {
                minAbsIdx = i;
            }
        }
        return minAbsIdx;
    }

    public static double sumAfterNegative(double[] arr) {
        double sum = 0.0;
        boolean foundNegative = false;

        for (double num : arr) {
            if (foundNegative) {
                sum += Math.abs(num);
            } else if (num < 0) {
                foundNegative = true;
            }
        }

        return sum;
    }

    public static void compressArray(double[] arr, double a, double b) {
        int writeIdx = 0;
        for (int readIdx = 0; readIdx < arr.length; readIdx++) {
            if (arr[readIdx] < a || arr[readIdx] > b) {
                arr[writeIdx++] = arr[readIdx];
            }
        }

        while (writeIdx < arr.length) {
            arr[writeIdx++] = 0.0;
        }
    }
}
