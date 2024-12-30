package clase;

import búsqueda.Search;
import ordenación.Sort;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 34, 84, 91, 110};
        int[] searchNumbers = {45, 54};

        // Comparación de búsquedas
        Search search = new Search();
        for (int num : searchNumbers) {
            System.out.println("Resultados de búsqueda para el número: " + num);
            search.sequentialSearch(array, num);
            search.binarySearch(array, num);
            search.interpolationSearch(array, num);
            System.out.println();
        }

        // Comparación de algoritmos de ordenación
        Sort sort = new Sort();
        sort.compareSortingAlgorithms(array);
    }
}
