package Sorting.MergeSort;

public class MergeSort {
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        // find a midpoint
        int mid = n / 2;

        // create two arrays to sort
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        // populate them
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        // recursive to make them smaller
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        // merge them all together!
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        // place them in the correct position
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        // When we run out of elements in either array
        // pick up the remaining elements and put in A[p..r]
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
