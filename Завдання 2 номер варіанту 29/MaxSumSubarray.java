import java.util.Arrays;
import java.util.Random;

public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] array = generateRandomArray(200, 0, 100);
        int[] maxSubarray = findMaxSumSubarray(array, 10);

        System.out.println("Generated Array: " + arrayToString(array));
        System.out.println("Max Sum Subarray: " + arrayToString(maxSubarray));
        System.out.println("Sum of Max Sum Subarray: " + sumArray(maxSubarray));
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static int[] findMaxSumSubarray(int[] array, int subarraySize) {
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        for (int i = 0; i <= array.length - subarraySize; i++) {
            int currentSum = 0;
            for (int j = i; j < i + subarraySize; j++) {
                currentSum += array[j];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = i;
            }
        }
        return Arrays.copyOfRange(array, startIndex, startIndex + subarraySize);
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}
