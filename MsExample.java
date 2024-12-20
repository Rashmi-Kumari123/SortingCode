public class MsExample {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        System.out.println("Original array: ");
        printArray(arr);

        MergeSort.mergeSort(arr);

        System.out.println("\nSorted array: ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}