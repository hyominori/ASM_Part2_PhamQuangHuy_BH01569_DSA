package TimeSpaceComplexity;
import java.util.Arrays;
import java.util.Random;
public class SortingTestCase {
    public static void main(String[] args) {
        // Test case 1: Small dataset
        System.out.println("Test Case 1: Small dataset\n=====================");
        testSortingAlgorithms(10, 0, 100);

        // Test case 2: Large dataset
        System.out.println("\nTest Case 2: Large dataset\n=====================");
        testSortingAlgorithms(100000, 0, 10000000);

        // Test case 3: Already sorted dataset
        System.out.println("\nTest Case 3: Already sorted dataset\n=====================");
        testSortedInput(1000);

        // Test case 4: Reverse sorted dataset
        System.out.println("\nTest Case 4: Reverse sorted dataset\n=====================");
        testReverseSortedInput(1000);

        // Test case 5: All elements the same
        System.out.println("\nTest Case 5: All elements the same\n=====================");
        testUniformInput(1000, 42);
    }

    public static void testSortingAlgorithms(int size, int minValue, int maxValue) {
        // Generate random arrays
        int[] randomArrayBubble = new Random().ints(size, minValue, maxValue).toArray();
        int[] randomArrayQuick = Arrays.copyOf(randomArrayBubble, size);
        int[] randomArrayMerge = Arrays.copyOf(randomArrayBubble, size);

        // Bubble Sort
        long startTime = System.nanoTime();
        AnalysisAlgorithmDemo.bubbleSort(randomArrayBubble.length, randomArrayBubble);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort completed in: " + (endTime - startTime) + " ns");
        System.out.println("Is correctly sorted: " + isSorted(randomArrayBubble));

        // Quick Sort
        startTime = System.nanoTime();
        AnalysisAlgorithmDemo.quickSort(randomArrayQuick, 0, randomArrayQuick.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort completed in: " + (endTime - startTime) + " ns");
        System.out.println("Is correctly sorted: " + isSorted(randomArrayQuick));

        // Merge Sort
        startTime = System.nanoTime();
        AnalysisAlgorithmDemo.mergeSort(randomArrayMerge, 0, randomArrayMerge.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort completed in: " + (endTime - startTime) + " ns");
        System.out.println("Is correctly sorted: " + isSorted(randomArrayMerge));
    }

    public static void testSortedInput(int size) {
        int[] sortedArray = new Random().ints(size, 0, 10000).sorted().toArray();
        runAlgorithmsOnInput(sortedArray);
    }

    public static void testReverseSortedInput(int size) {
        int[] reverseSortedArray = new Random().ints(size, 0, 10000).boxed()
                .sorted((a, b) -> b - a).mapToInt(i -> i).toArray();
        runAlgorithmsOnInput(reverseSortedArray);
    }

    public static void testUniformInput(int size, int value) {
        int[] uniformArray = new int[size];
        Arrays.fill(uniformArray, value);
        runAlgorithmsOnInput(uniformArray);
    }

    private static void runAlgorithmsOnInput(int[] inputArray) {
        int[] arrayForBubble = Arrays.copyOf(inputArray, inputArray.length);
        int[] arrayForQuick = Arrays.copyOf(inputArray, inputArray.length);
        int[] arrayForMerge = Arrays.copyOf(inputArray, inputArray.length);

        // Bubble Sort
        long startTime = System.nanoTime();
        AnalysisAlgorithmDemo.bubbleSort(arrayForBubble.length, arrayForBubble);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort completed in: " + (endTime - startTime) + " ns");
        System.out.println("Is correctly sorted: " + isSorted(arrayForBubble));

        // Quick Sort
        startTime = System.nanoTime();
        AnalysisAlgorithmDemo.quickSort(arrayForQuick, 0, arrayForQuick.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort completed in: " + (endTime - startTime) + " ns");
        System.out.println("Is correctly sorted: " + isSorted(arrayForQuick));

        // Merge Sort
        startTime = System.nanoTime();
        AnalysisAlgorithmDemo.mergeSort(arrayForMerge, 0, arrayForMerge.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort completed in: " + (endTime - startTime) + " ns");
        System.out.println("Is correctly sorted: " + isSorted(arrayForMerge));
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
