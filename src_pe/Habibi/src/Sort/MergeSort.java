package Sort;

public class MergeSort {
    
    void merge(int[] a, int low, int mid, int high) {
        int i, j, k;
        //create a temporary array b and copy a to b
        int[] b = new int[a.length];
        for (i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        i = low;
        j = mid + 1;
        k = low;
        while (i <= mid && j <= high) {
            if (b[i] > b[j]) {
                a[k++] = b[j++];
            } else {
                a[k++] = b[i++];
            }
        }
        while (i <= mid) {
            a[k++] = b[i++];
        }
        while (j <= high) {
            a[k++] = b[j++];
        }
    }

    void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int k = (low + high) / 2;
            mergesort(a, low, k);
            mergesort(a, k + 1, high);
            merge(a, low, k, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 4, 6, 3, 0, 8, 9};
        
        MergeSort ms = new MergeSort();
        ms.mergesort(arr, 0, arr.length - 1);
    }
}

