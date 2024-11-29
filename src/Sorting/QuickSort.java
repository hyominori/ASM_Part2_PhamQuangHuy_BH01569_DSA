package Sorting;
import java.util.Arrays;

public class QuickSort {
    // Function to partition the array and place the pivot in the correct position
    public static int partition(int[] arr, int left, int right) {
        // Choose the last element as pivot

        int pivot = arr[right];
        // i represents the boundary for elements less than or equal to the pivot
        int i = left - 1;

        // Loop through the array and rearrange elements based on pivot
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j] to place smaller elements before pivot
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot in the correct position by swapping with arr[i+1]
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        // Return the index of the pivot
        return i + 1;
    }

    // Recursive function to perform Quick Sort on subarrays
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, left, right);

            // Recursively sort the elements before and after the pivot
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6, 7};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Perform Quick Sort on the array
        quickSort(arr, 0, arr.length - 1);

        // Display the sorted array
        System.out.println("Sorted using Quick Sort: " + Arrays.toString(arr));
    }
}
