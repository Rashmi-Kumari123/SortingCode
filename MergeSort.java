public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) { //This check controls the splitting
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            // Divide the array into two halves i.e. Creating left and right sub-arrays
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            for (int i = mid; i < arr.length; i++) {
                right[i - mid] = arr[i];
            }

            // RECURSION: This is what keeps splitting down
            mergeSort(left); // Split left side
            mergeSort(right);  // Split right side

            // After recursive calls, this merge combines sorted pieces
            merge(arr, left, right);  // This is where we go back up!
        }  //When arr.length <= 1, we do nothing and return
        // Because a single element is already sorted
    }

    // The merge method then combines two sorted arrays:
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two sorted halves  (using pointers i,j and k)
        // logic is i tracks position in left array, j tracks position in right array,
        // k tracks where we're placing items in the final array and We increment the pointer of whichever array provided the smaller element 
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Add any remaining elements from the left or right arrays if leftover
        while (i < left.length) {
            arr[k++] = left[i++];  // first assignment , then moves to next position
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}