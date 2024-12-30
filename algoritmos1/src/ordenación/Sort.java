package ordenación;

import java.util.Arrays;

public class Sort {

    // Método para comparar algoritmos de ordenación
    public void compareSortingAlgorithms(int[] array) {
        System.out.println("Comparación de algoritmos de ordenación:");
        
        measureSorting("Bubble Sort", array, this::bubbleSort);
        measureSorting("Selection Sort", array, this::selectionSort);
        measureSorting("Merge Sort", array, this::mergeSort);
        measureSorting("Shell Sort", array, this::shellSort);
    }

    // Bubble Sort
    public int bubbleSort(int[] array) {
        int comparisons = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return comparisons;
    }

    // Selection Sort
    public int selectionSort(int[] array) {
        int comparisons = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return comparisons;
    }

    // Merge Sort
    public int mergeSort(int[] array) {
        return mergeSortHelper(array, 0, array.length - 1);
    }

    private int mergeSortHelper(int[] array, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int comparisons = mergeSortHelper(array, left, mid);
        comparisons += mergeSortHelper(array, mid + 1, right);
        comparisons += merge(array, left, mid, right);
        return comparisons;
    }

    private int merge(int[] array, int left, int mid, int right) {
        int comparisons = 0;
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            comparisons++;
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        System.arraycopy(temp, 0, array, left, temp.length);
        return comparisons;
    }

    // Shell Sort
    public int shellSort(int[] array) {
        int comparisons = 0;
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    comparisons++;
                    array[j] = array[j - gap];
                    j -= gap;
                }
                comparisons++;
                array[j] = temp;
            }
        }
        return comparisons;
    }

    // Método para medir tiempo y comparaciones
    private void measureSorting(String algorithm, int[] array, SortingAlgorithm sorter) {
        int[] copy = Arrays.copyOf(array, array.length);
        int comparisons = sorter.sort(copy);
        System.out.println(algorithm + " - Comparaciones: " + comparisons);
    }

    @FunctionalInterface
    interface SortingAlgorithm {
        int sort(int[] array);
    }
}
