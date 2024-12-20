public class csExample {
    public static void main(String[] args) {
        // int[] arr = {5, 2, 4, 6, 1, 3, 2, 4, 3, 1};
        int[] arr = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};

        Cs.countingSort(arr);

        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}