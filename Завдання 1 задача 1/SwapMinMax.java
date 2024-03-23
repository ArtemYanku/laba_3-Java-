import java.util.Arrays;

public class SwapMinMax {
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 6, 1};
        swapMaxMin(array);
        System.out.println(Arrays.toString(array));
    }

    public static void swapMaxMin(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }

        int temp = arr[minIdx];
        arr[minIdx] = arr[maxIdx];
        arr[maxIdx] = temp;
    }
}
