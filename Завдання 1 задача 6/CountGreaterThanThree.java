import java.util.Arrays;

public class CountGreaterThanThree {
    public static void main(String[] args) {
        double[] array = {-3.5, 2.0, 1.8, -4.2, 3.9, -1.6};
        int countGreaterThanThree = countGreaterThan(array, 3);
        double productAfterMaxAbs = productAfterMaxAbs(array);
        transformArrayNegativeFirst(array);
        System.out.println("Count of elements greater than 3: " + countGreaterThanThree);
        System.out.println("Product after max abs element: " + productAfterMaxAbs);
        System.out.println("Transformed array: " + Arrays.toString(array));
    }

    public static int countGreaterThan(double[] arr, double threshold) {
        int count = 0;
        for (double num : arr) {
            if (num > threshold) {
                count++;
            }
        }
        return count;
    }

    public static double productAfterMaxAbs(double[] arr) {
        double maxAbs = 0.0;
        int maxAbsIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > maxAbs) {
                maxAbs = Math.abs(arr[i]);
                maxAbsIdx = i;
            }
        }

        double product = 1.0;
        for (int i = maxAbsIdx + 1; i < arr.length; i++) {
            product *= arr[i];
        }

        return product;
    }

    public static void transformArrayNegativeFirst(double[] arr) {
        int negativeIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                double temp = arr[i];
                arr[i] = arr[negativeIdx];
                arr[negativeIdx] = temp;
                negativeIdx++;
            }
        }
    }
}
