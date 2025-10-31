/**
 * Implementation of Bubble Sort algorithm
 * Time Complexity: O(n²) in the worst and average cases, O(n) in the best case (when array is already sorted)
 * Space Complexity: O(1) - It's an in-place sorting algorithm as it only uses a constant amount of additional space
 * Stability: Yes, Bubble Sort is stable as it preserves the relative order of equal elements
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
