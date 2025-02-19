import java.util.Scanner;

public class MergeSortBookPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of book prices: ");
        int n = scanner.nextInt();
        double[] bookPrices = new double[n];
        
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            bookPrices[i] = scanner.nextDouble();
        }
        
        mergeSort(bookPrices, 0, n - 1);
        
        System.out.println("Sorted book prices in ascending order:");
        for (double price : bookPrices) {
            System.out.print(price + " ");
        }
        
        scanner.close();
    }
    
    private static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}