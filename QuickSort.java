public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the partition index (pivot's final position)
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort left and right of pivot
            quickSort(arr, low, pivotIndex - 1);  // Left side
            quickSort(arr, pivotIndex + 1, high); // Right side
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        // Choose rightmost element as pivot
        int pivot = arr[high];
        
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
        
        // Compare each element with pivot
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (arr[j] < pivot) { 
                i++;    // increment index of smaller element
                // Swap elements
                swap(arr, i, j);
            }
        }
        
        // Place pivot in its correct position
        swap(arr, i + 1, high);
        
        // Return the position from where partition is done
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        System.out.println("Original array:");
        printArray(arr);
        
        quickSort(arr);
        
        System.out.println("\nSorted array:");
        printArray(arr);
    }
    
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}