import java.util.Arrays;

public class MaxAbsNumber {
    public static void main(String[] args) {
        double[] array = {-3.5, 2.0, 1.8, -4.2, 3.9, -1.6};
        int maxAbsIndex = findMaxAbsIndex(array);
        double sumAfterPositive = sumAfterPositive(array);
        transformArray(array, -2, 2);
        System.out.println("Index of max abs number: " + maxAbsIndex);
        System.out.println("Sum of elements after first positive: " + sumAfterPositive);
        System.out.println("Transformed array: " + Arrays.toString(array));
    }

    public static int findMaxAbsIndex(double[] arr) {
        int maxAbsIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(arr[maxAbsIdx])) {
                maxAbsIdx = i;
            }
        }
        return maxAbsIdx;
    }

    public static double sumAfterPositive(double[] arr) {
        double sum = 0.0;
        boolean foundPositive = false;

        for (double num : arr) {
            if (foundPositive) {
                sum += num;
            } else if (num > 0) {
                foundPositive = true;
            }
        }

        return sum;
    }

    public static void transformArray(double[] arr, int a, int b) {
        int writeIdx = 0;
        for (double num : arr) {
            if ((int) num >= a && (int) num <= b) {
                arr[writeIdx++] = num;
            }
        }

        for (int i = writeIdx; i < arr.length; i++) {
            arr[i] = 0.0;
        }
    }
}
