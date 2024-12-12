package movierentalsystem;

public class SelectionSort {
    public static void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // Assume the current element is the smallest
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }
            // Swap the smallest element found with the current element
            String temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}