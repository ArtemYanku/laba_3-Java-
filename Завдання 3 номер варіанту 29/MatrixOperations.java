import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(5, 5, 0, 100);
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        int[] positiveElementsCount = countPositiveElements(matrix);
        System.out.println("\nNumber of Positive Elements in Each Row:");
        printArray(positiveElementsCount);
        
        int maxModulusElement = findMaxModulusElement(matrix);
        System.out.println("\nMaximum Modulus Element in the Matrix: " + maxModulusElement);
        
        double averageMaxElement = calculateAverageMaxElement(matrix);
        double averageMinElement = calculateAverageMinElement(matrix);
        System.out.println("\nAverage of Maximum Element: " + averageMaxElement);
        System.out.println("Average of Minimum Element: " + averageMinElement);
        
        int rowIndex = 2; // Assume we want to replace elements in the 3rd row
        replaceRowWithAverage(matrix, rowIndex, averageMaxElement);
        System.out.println("\nModified Matrix after Replacing Row " + (rowIndex + 1) + " with Average of Maximum Element:");
        printMatrix(matrix);
    }

    public static int[][] generateRandomMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static int[] countPositiveElements(int[][] matrix) {
        int[] countArray = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int num : matrix[i]) {
                if (num > 0) {
                    count++;
                }
            }
            countArray[i] = count;
        }
        return countArray;
    }

    public static int findMaxModulusElement(int[][] matrix) {
        int maxModulus = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                maxModulus = Math.max(maxModulus, Math.abs(num));
            }
        }
        return maxModulus;
    }

    public static double calculateAverageMaxElement(int[][] matrix) {
        int maxElement = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                maxElement = Math.max(maxElement, num);
            }
        }
        return (double) maxElement / matrix.length;
    }

    public static double calculateAverageMinElement(int[][] matrix) {
        int minElement = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                minElement = Math.min(minElement, num);
            }
        }
        return (double) minElement / matrix.length;
    }

    public static void replaceRowWithAverage(int[][] matrix, int rowIndex, double average) {
        for (int i = 0; i < matrix[rowIndex].length; i++) {
            matrix[rowIndex][i] = (int) average;
        }
    }
}
