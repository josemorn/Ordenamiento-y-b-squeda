package búsqueda;


public class Search {

    // Búsqueda secuencial
    public void sequentialSearch(int[] array, int target) {
        int comparisons = 0;
        for (int num : array) {
            comparisons++;
            if (num == target) {
                System.out.println("Secuencial: Encontrado en " + comparisons + " comparaciones.");
                return;
            }
        }
        System.out.println("Secuencial: No encontrado tras " + comparisons + " comparaciones.");
    }

    // Búsqueda binaria
    public void binarySearch(int[] array, int target) {
        int comparisons = 0;
        int low = 0, high = array.length - 1;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                System.out.println("Binaria: Encontrado en " + comparisons + " comparaciones.");
                return;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binaria: No encontrado tras " + comparisons + " comparaciones.");
    }

    // Búsqueda por interpolación
    public void interpolationSearch(int[] array, int target) {
        int comparisons = 0;
        int low = 0, high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            comparisons++;
            int pos = low + ((target - array[low]) * (high - low)) / (array[high] - array[low]);

            if (array[pos] == target) {
                System.out.println("Interpolación: Encontrado en " + comparisons + " comparaciones.");
                return;
            } else if (array[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        System.out.println("Interpolación: No encontrado tras " + comparisons + " comparaciones.");
    }
}
