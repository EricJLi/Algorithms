import java.util.Arrays;

public class QuickSort {
    public static int[] numbers;
 
    public static void swap(int a, int b){
        int tmp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = tmp;
    }

    public static int partition(int left, int right){

        int pIndex = left, pValue = numbers[right];

        for (int i = left; i <= right - 1; i++){
            if (numbers[i] < pValue){
                swap(i, pIndex);
                pIndex++;
            }
        }

        swap(pIndex, right);

        return pIndex;
    }

    public static void quickSort(int left, int right){
        if (left >= right) return;

        int pivotIndex = partition(left, right);
        quickSort(left, pivotIndex - 1);
        quickSort(pivotIndex + 1, right);
    }

    public static void main(String[] args){
    	
        numbers = new int[] {7, 2, 1, 6, 8, 5, 3, 4};
        quickSort(0, numbers.length - 1);

        System.out.println(Arrays.toString(numbers));
    }
}