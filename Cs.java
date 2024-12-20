public class Cs {
    public static void countingSort(int[] arr) {
        int n = arr.length;
        // Find the maximum element in the array
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        int[] output = new int[n];

        // Count the occurrences of each element
        for (int i = 0; i < n; ++i) {
            count[arr[i]]++;
        }

        // Modify the count array to get the actual position of each element in the output array
        for (int i = 1; i <= max; ++i) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the output array to the original array
        for (int i = 0; i < n; ++i) {
            arr[i] = output[i];
        }
    }
}