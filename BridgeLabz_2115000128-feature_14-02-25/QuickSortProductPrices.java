import java.util.Scanner;

public class QuickSortProductPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of product prices: ");
        int n = scanner.nextInt();
        double[] productPrices = new double[n];
        
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            productPrices[i] = scanner.nextDouble();
        }
        
        quickSort(productPrices, 0, n - 1);
        
        System.out.println("Sorted product prices in ascending order:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }
        
        scanner.close();
    }
    
    private static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}